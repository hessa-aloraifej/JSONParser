package com.example.jsonparser

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_row.view.*

class RVAdapter(val list: ArrayList<DataItem>) : RecyclerView.Adapter<RVAdapter.ItemViewHolder>() {
    class ItemViewHolder (itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_row,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val data = list[position]

        holder.itemView.apply {
            textView2.text = " Title: ${data.title}"
            Glide.with(holder.itemView.context)
                .load(data.url)
                .into(img)

        }
    }

    override fun getItemCount(): Int = list.size
}
