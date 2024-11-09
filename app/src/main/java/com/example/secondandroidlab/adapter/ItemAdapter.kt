package com.example.secondandroidlab.adapter

import android.graphics.PorterDuff
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.secondandroidlab.R
import com.example.secondandroidlab.model.Item

class ItemAdapter(private val items: List<Item>) :
    RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleTextView: TextView = itemView.findViewById(R.id.item_title)
        val imageView: ImageView = itemView.findViewById(R.id.item_image)
        val imageLikeView: ImageView = itemView.findViewById(R.id.liked_image)

        fun bind(item: Item) {
            titleTextView.text = item.title
            imageView.setImageResource(item.img)

            updateLikeIcon(item.isLiked)

            imageLikeView.setOnClickListener {
                item.isLiked = !item.isLiked
                updateLikeIcon(item.isLiked)
            }
        }

        private fun updateLikeIcon(isLiked: Boolean) {
            val likeColor = if (isLiked) R.color.red else R.color.grey
            imageLikeView.setColorFilter(
                ContextCompat.getColor(imageLikeView.context, likeColor),
                PorterDuff.Mode.SRC_IN
            )
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item, parent, false)
        return ItemViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size
}
