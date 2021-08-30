package com.malavet.sampleapp.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.malavet.sampleapp.R
import com.malavet.sampleapp.data.ImagesDataType
import com.malavet.sampleapp.databinding.OneListItemBinding


/**
 * Adapter for the [RecyclerView].
 */

class PhotoListAdapter : RecyclerView.Adapter<PhotoListAdapter.ListViewHolder>() {

    var photoList: List<ImagesDataType> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding: OneListItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context), ListViewHolder.layout, parent, false
        )

        return ListViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return photoList.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
            holder.viewDataBinding.also {
               it.photo = photoList[position]

        }
    }

    class ListViewHolder(val viewDataBinding: OneListItemBinding) :
        RecyclerView.ViewHolder(viewDataBinding.root) {


        companion object {
            val layout = R.layout.one_list_item
        }
    }
}
