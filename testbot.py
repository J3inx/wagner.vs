import os
import time
from selenium import webdriver
from selenium.webdriver.chrome.options import Options
from appium import webdriver as appium_webdriver
from dotenv import load_dotenv

# Load environment variables from the .env file
load_dotenv()

# Print the PATH environment variable to verify dotenv is working
print(os.environ['PATH'])

# Proxy details for ScraperAPI (your API key included)
PROXY_API_URL = "http://api.scraperapi.com?api_key=c171fdfad8a78066023d95db165b3771&url="  # Your ScraperAPI key

# Function to set up the proxy
def set_proxy(proxy_address):
    # Define ChromeOptions
    options = Options()

    # Enable mobile emulation (for iPhone X) - using only 'deviceName'
    mobile_emulation = {
        "deviceName": "iPhone X"  # Emulate iPhone X; this can be adjusted to other devices as needed
    }
    options.add_experimental_option("mobileEmulation", mobile_emulation)

    # Add proxy to Chrome options
    options.add_argument(f'--proxy-server={proxy_address}')

    # Create the WebDriver instance with proxy settings
    driver = webdriver.Chrome(options=options)
    return driver

def wait_seconds(seconds):
    time.sleep(seconds)

# Function to visit the URL
def visit_url():
    try:
        # Get the target URL from the user
        target_url = "https://" + input("Enter the URL you want to visit (including http:// or https://): ").strip()

        if not target_url:
            print("Error: The URL cannot be empty.")
            return

        if not target_url.startswith("http://") and not target_url.startswith("https://"):
            print("Error: The URL must start with 'http://' or 'https://'.")
            return

        # Input time to be on the website
        entered = input("How long do you want the site to be open in seconds? (Enter 0 to leave open indefinitely): ").strip()
        
        try:
            entered = int(entered)
        except ValueError:
            print("Invalid time input. Please enter a valid integer.")
            return

        # Set up the proxy URL with ScraperAPI
        proxy_address = PROXY_API_URL + target_url
        driver = set_proxy(proxy_address)
        
        # Visit the URL
        driver.get(target_url)
        
        # Wait for the specified time or indefinitely
        if entered == 0:
            print("No time limit entered, the browser will stay open until manually closed.")
            while True:
                if not driver.window_handles:
                    break
                time.sleep(1)
        else:
            print(f"Browser will stay open for {entered} seconds.")
            wait_seconds(entered)

        driver.quit()
        print("Browser session ended.")
    except Exception as e:
        print(f"Error opening the URL: {str(e)}")

# Function for app emulation (updated)
def app_emulation():
    print("App emulation selected. Setting up the appium driver...")

    # Desired capabilities
    desired_capabilities = {
       "platformName": "Android",  # or 'iOS' if targeting iOS
       "deviceName": "device2",  # Change to your emulator or device name
       "app": os.path.expanduser("~/Desktop/wagner.vs/app-location"),  # Path to your APK
       "automationName": "UiAutomator2",  # Automation framework
    }

    # Connect to the Appium server
    driver = appium_webdriver.Remote("http://127.0.0.1:4723/wd/hub", desired_capabilities)

    # Perform actions on the app (e.g., find an element and click it)
    element = driver.find_element("id", "com.example:id/button")
    element.click()

    # Close the session
    driver.quit()

# Main entry point
def main():
    # Ask the user whether to run mobile or app emulation
    emulation_type = input("Do you want to run web emulation or app emulation? (Enter 'web' or 'app'): ").strip().lower()

    if emulation_type == 'web':
        visit_url()  # Run the mobile emulation (webpage emulation)
    elif emulation_type == 'app':
        app_emulation()  # Run app emulation
    else:
        print("Invalid input. Please enter 'web' or 'app'.")

# Run the program
main()
