package com.example.skeleton.presentation.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.skeleton.R
import com.example.skeleton.databinding.PhotoItemBinding
import com.example.skeleton.domain.model.PhotoItemModel
import com.squareup.picasso.Picasso

class PhotosAdapter : RecyclerView.Adapter<PhotosViewHolder>() {

    var photosList = listOf<PhotoItemModel>()
        set(value) {
            notifyDataSetChanged()
            field = value
        }

override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotosViewHolder {
    return PhotosViewHolder(
        PhotoItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ),
        parent.context
    )
}

override fun onBindViewHolder(holder: PhotosViewHolder, position: Int) {
    holder.bind(photosList[position])
}

override fun getItemCount() = photosList.size
}

class PhotosViewHolder(
    private val binding: PhotoItemBinding,
    private val context: Context
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(photoItemModel: PhotoItemModel) {
        binding.title.text = photoItemModel.title
        Picasso.get()
            .load(photoItemModel.url)
            .error(R.drawable.ic_launcher_foreground)
            .into(binding.imageView)
    }
}