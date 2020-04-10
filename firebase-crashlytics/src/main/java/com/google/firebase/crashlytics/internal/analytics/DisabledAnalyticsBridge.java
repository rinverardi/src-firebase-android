// Copyright 2020 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.firebase.crashlytics.internal.analytics;

import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.analytics.AnalyticsConnectorBridge.BreadcrumbHandler;

/**
 * Analytics bridge implementation for use when Firebase Analytics is not available.
 */
public class DisabledAnalyticsBridge implements AnalyticsBridge {
    @Override
    public void registerBreadcrumbHandler(BreadcrumbHandler breadcrumbHandler) {
      Logger.getLogger()
          .d(
              "Firebase Analytics is not present; you will not see automatic logging of "
                  + "events before a crash occurs.");
    }

    @Override
    public void recordFatalFirebaseEvent(long timestamp) {
      // Do nothing.
    }

    @Override
    public Task<Void> getAnalyticsTaskChain() {
      return Tasks.forResult(null);
    }
}
