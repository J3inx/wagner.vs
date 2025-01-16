import sys
import os
import requests
import asyncio
from dotenv import load_dotenv

# Add the custom module path to sys.path
sys.path.insert(0, os.path.expanduser('~/Desktop/wagner.vs/modules'))
custom_modules_path = os.path.expanduser('~/Desktop/wagner.vs/modules')  # Use absolute path
if custom_modules_path not in sys.path:
    sys.path.append(custom_modules_path)

# Load environment variables from the .env file
load_dotenv()

# Print the PATH environment variable to verify dotenv is working
print(os.environ['PATH'])

# ProxyCrawl API URL (replace with actual API key)
PROXY_API_URL = "http://iLxrCSDSSvZzp9ug7f_TjA@smartproxy.crawlbase.com:8012"

# Asynchronous function to get proxies using requests
async def get_proxies():
    response = await asyncio.to_thread(requests.get, PROXY_API_URL)
    return response

# Function to finish the process and print the response
async def finish():
    response = await get_proxies()
    # Print the response text or JSON
    print(response.text)  # or response.json() if it's a JSON response

# Run the event loop to execute the asynchronous function
asyncio.run(finish())
