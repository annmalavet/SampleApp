package com.malavet.sampleapp.ui.adapters

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

/**
 * Adapter for the [RecyclerView].
 */

class BindingAdapter  {
    companion object {
        @JvmStatic
        @BindingAdapter("urlImage")
        fun bindUrlImage(view: ImageView, imageUrl: String?) {
            if (imageUrl != null) {
                Picasso.get()
                    .load(imageUrl)
                    .resize(200,200)
                    .centerCrop()
                    .into(view)
            } else {
                view.setImageBitmap(null)
            }
        }
        @JvmStatic
        @BindingAdapter("textImage")
        fun bindText(view: TextView, text: String?) {
                view.setText(text)
            }
    }
}
