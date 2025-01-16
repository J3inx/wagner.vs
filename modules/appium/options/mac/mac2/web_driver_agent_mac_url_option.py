# Licensed to the Software Freedom Conservancy (SFC) under one
# or more contributor license agreements.  See the NOTICE file
# distributed with this work for additional information
# regarding copyright ownership.  The SFC licenses this file
# to you under the Apache License, Version 2.0 (the
# "License"); you may not use this file except in compliance
# with the License.  You may obtain a copy of the License at
#
#   http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing,
# software distributed under the License is distributed on an
# "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
# KIND, either express or implied.  See the License for the
# specific language governing permissions and limitations
# under the License.

from typing import Optional

from appium.options.common.supports_capabilities import SupportsCapabilities

WEB_DRIVER_ARGENT_MAC_URL = 'webDriverAgentMacUrl'


class WebDriverAgentMacUrlOption(SupportsCapabilities):
    @property
    def web_driver_agent_mac_url(self) -> Optional[str]:
        """
        The URL Appium will connect to an existing WebDriverAgentMac instance.
        """
        return self.get_capability(WEB_DRIVER_ARGENT_MAC_URL)

    @web_driver_agent_mac_url.setter
    def web_driver_agent_mac_url(self, value: str) -> None:
        """
        Set the URL Appium will connect to an existing WebDriverAgentMac
        instance at this URL instead of starting a new one.
        """
        self.set_capability(WEB_DRIVER_ARGENT_MAC_URL, value)
