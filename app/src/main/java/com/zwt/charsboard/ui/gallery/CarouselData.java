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

package com.zwt.charsboard.ui.gallery;

import com.zwt.charsboard.R;
import com.zwt.charsboard.data.CarouselItem;

import java.util.Arrays;
import java.util.List;

/**
 * A data store used to populate Carousels.
 */
class CarouselData {

  CarouselData() { }

  static List<CarouselItem> createItems() {
    return Arrays.asList(
        new CarouselItem(R.mipmap.unlock, R.string.cat_carousel_image_1_content_desc),
        new CarouselItem(R.mipmap.timestories, R.string.cat_carousel_image_2_content_desc),
        new CarouselItem(R.mipmap.escape_game, R.string.cat_carousel_image_3_content_desc),
        new CarouselItem(R.mipmap.sigularity, R.string.cat_carousel_image_4_content_desc),
        new CarouselItem(R.mipmap.escape_room, R.string.cat_carousel_image_5_content_desc),
        new CarouselItem(R.mipmap.undo, R.string.cat_carousel_image_6_content_desc),
        new CarouselItem(R.mipmap.black_stroies, R.string.cat_carousel_image_7_content_desc)
    );
  }
}
