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

CALENDAR_ACCESS_AUTHORIZED = 'calendarAccessAuthorized'


class CalendarAccessAuthorizedOption(SupportsCapabilities):
    @property
    def calendar_access_authorized(self) -> Optional[bool]:
        """
        Whether to enable calendar access on IOS Simulator.
        """
        return self.get_capability(CALENDAR_ACCESS_AUTHORIZED)

    @calendar_access_authorized.setter
    def calendar_access_authorized(self, value: bool) -> None:
        """
        Set this to true if you want to enable calendar access on IOS Simulator
        with given bundleId. Set to false, if you want to disable calendar access
        on IOS Simulator with given bundleId. If not set, the calendar
        authorization status will not be set.
        """
        self.set_capability(CALENDAR_ACCESS_AUTHORIZED, value)
