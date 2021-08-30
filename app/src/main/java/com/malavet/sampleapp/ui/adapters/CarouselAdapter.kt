package com.malavet.sampleapp.ui.adapters

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.helper.widget.Carousel
import com.squareup.picasso.Picasso

/**
 * Adapter for the [Carousel].
 */

class CarouselAdapter() : Carousel.Adapter  {

    var photoListOf: List<String> = listOf(
        "https://picsum.photos/id/1025/4951/3301",
        "https://picsum.photos/id/1024/1920/1280",
        "https://picsum.photos/id/1023/3955/2094",
        "https://picsum.photos/id/1022/6000/3376",
        "https://picsum.photos/id/1021/2048/1206"
    )
    var authorListOf: List<String> = listOf(
        "Frances Gunn",
        "Vashishtha Jogi",
        "William Hook",
        "Niko Virtanen",
        "Matthew Wiebe"
    )

    override fun count(): Int {
      return  photoListOf.size
    }

    override fun populate(view: View?, index: Int) {

        if (view is ImageView) {
            Picasso.get().load(photoListOf.get(index)).resize(200, 200)
                .centerCrop()
                .into(view)

        }
        if (view is TextView) {
            view.setText(authorListOf.get(index))

        }
    }

    override fun onNewItem(index: Int) {

    }
}
