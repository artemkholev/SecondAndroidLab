package com.example.secondandroidlab.model

import com.example.secondandroidlab.R

data class Item(
    val id: Number,
    val title: String,
    val img: Int,
    var isLiked: Boolean,
)

fun generateRecyclerViewItems(count: Int): List<Item> {
    val items = mutableListOf<Item>()

    for (i in 1..count) {
        val item = Item(
            id = i,
            img = R.drawable.ic_person,
            title = "Item $i",
            isLiked = false,
        )
        items.add(item)
    }

    return items
}