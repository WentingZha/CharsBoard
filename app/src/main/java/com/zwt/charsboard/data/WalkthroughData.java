/*
 * Copyright 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.zwt.charsboard.data;

import com.zwt.charsboard.R;

import java.util.Arrays;
import java.util.List;

/**
 * A data store used to populate Carousels.
 */
class WalkthroughData {

  private WalkthroughData() { }

  static List<WalkthroughItem> createItems() {
    return Arrays.asList(
        new WalkthroughItem(R.string.cat_carousel_image_1_content_desc, R.string.game1_intro),
        new WalkthroughItem(R.string.cat_carousel_image_2_content_desc, R.string.game2_intro),
        new WalkthroughItem(R.string.cat_carousel_image_3_content_desc, R.string.game3_intro),
        new WalkthroughItem(R.string.cat_carousel_image_4_content_desc, R.string.game4_intro),
        new WalkthroughItem(R.string.cat_carousel_image_5_content_desc, R.string.game5_intro),
        new WalkthroughItem(R.string.cat_carousel_image_6_content_desc, R.string.game6_intro),
        new WalkthroughItem(R.string.cat_carousel_image_7_content_desc, R.string.game7_intro)
    );
  }
}
