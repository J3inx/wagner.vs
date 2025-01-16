import sys
import os
sys.path.insert(0, os.path.expanduser('~/Desktop/wagner.vs/modules'))
custom_modules_path = os.path.expanduser("desktop/wagner.vs/modules")
if custom_modules_path not in sys.path:
    sys.path.append(custom_modules_path)
import requests
import asyncio
import dotenv
from dotenv import load_dotenv

load_dotenv()
print(os.environ['PATH'])


# ProxyCrawl API URL (replace with actual API key)
PROXY_API_URL = "http://iLxrCSDSSvZzp9ug7f_TjA@smartproxy.crawlbase.com:8012"

async def get_proxies():
    response = await asyncio.to_thread(requests.get, PROXY_API_URL)
    return response

async def finish():
    response = await get_proxies()
    # Print the response text or JSON
    print(response.text)  # or response.json() if it's a JSON response

# Run the event loop to execute the asynchronous function
asyncio.run(finish())
