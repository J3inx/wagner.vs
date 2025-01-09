import asyncio
import time
from selenium import webdriver
from selenium.webdriver.chrome.options import Options

# Proxy details for ScraperAPI (your API key included)
PROXY_API_URL = "http://api.scraperapi.com?api_key=c171fdfad8a78066023d95db165b3771&url="  # Your ScraperAPI key

# Function to set up the proxy
def set_proxy(proxy_address):
    # Define ChromeOptions
    options = Options()

    # Enable mobile emulation (for iPhone X)
    mobile_emulation = {
        "deviceName": "iPhone X"
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
async def visit_url():
    try:
        # Get the target URL from the user
        target_url = input("Enter the URL you want to visit (including http:// or https://): ").strip()

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

# Main entry point
async def main():
    await visit_url()

# Run the program
asyncio.run(main())
