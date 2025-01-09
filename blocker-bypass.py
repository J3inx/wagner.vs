import asyncio
import time
from selenium import webdriver
from selenium.webdriver.chrome.options import Options
from selenium.webdriver.common.by import By
import os
import signal
device = input("what device do you want to emulate, 1 for iphone x, 2 for macbook air, and 3 for an ipad pro: ").strip()
try:
    device = int(device)
except ValueError:
    print("Invalid time input. Please enter a valid integer.")
# Proxy details for ScraperAPI (your API key included)
PROXY_API_URL = "http://api.scraperapi.com?api_key=c171fdfad8a78066023d95db165b3771&url="  # Your ScraperAPI key

# Function to set up the proxy
def set_proxy(proxy_address):
    # Define ChromeOptions
    options = Options()
    
    # Enable mobile emulation (blank blank)
    device
    # Mobile emulation configuration based on the selected device
    if device == 1:  # iPhone X
        mobile_emulation = {
            "deviceName": "iPhone X"
        }
    elif device == 2:  # MacBook Air
        mobile_emulation = {
            "deviceMetrics": {
                "width": 1280,
                "height": 800,
                "pixelRatio": 2.0
            },
            "userAgent": "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/89.0.4389.82 Safari/537.36"
        }
    elif device == 3:  # iPad Pro
        mobile_emulation = {
            "deviceName": "iPad Pro"
        }
    else:
        print("Invalid device selection. Defaulting to macbook air.")
        mobile_emulation = {
            "deviceMetrics": {
                "width": 1280,
                "height": 800,
                "pixelRatio": 2.0
            },
            "userAgent": "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/89.0.4389.82 Safari/537.36"
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
    target_url = "https://" + input("Enter the URL you want to visit: ").strip() #(including http:// or https://): ").strip()

    if not target_url:
        print("Error: The URL cannot be empty.")
        return
    
    if not target_url.startswith("http://") and not target_url.startswith("https://"):
        print("Error: The URL must start with 'http://' or 'https://'.")
        return

    try:
        # Set up the proxy URL with ScraperAPI
        proxy_address = PROXY_API_URL + target_url
        driver = set_proxy(proxy_address)
        
        # Visit the URL
        driver.get(target_url)
        
        # Wait for a while to let the page load (optional)
        driver.implicitly_wait(10)  # 10 seconds wait
        
        # Print the page title
        print(f"Page title: {driver.title}")
        
        # Keep the browser open until the window is manually closed
        while True:
            # Check if the window is still open
            if not driver.window_handles:
                break
            time.sleep(1)
        
        driver.quit()

    except Exception as e:
        print(f"Error opening the URL: {str(e)}")

# Main entry point
async def main():
    await visit_url()

# Run the program
asyncio.run(main())
