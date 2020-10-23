package com.example.belltest.ui.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.belltest.R
import com.example.belltest.ui.ui.ImagewithTitle
import kotlinx.android.synthetic.main.third_screen_item.view.*

interface ItemClickListner {
    fun onItemClick(summary: String)
}

class ThirdRecyclerAdapter(private val movieList: List<ImagewithTitle>, private val itemClickListner: ItemClickListner) :
    RecyclerView.Adapter<ThirdRecyclerAdapter.ExampleViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExampleViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.third_screen_item,
            parent, false)
        return ExampleViewHolder(itemView)
    }
    override fun onBindViewHolder(holder: ExampleViewHolder, position: Int) {
        val currentItem = movieList[position]
        val imWidth =  holder.image.width
        val imHeight =  holder.image.height

        holder.textTitle.text = currentItem.title
        Glide.with(holder.itemView.context).load("${currentItem.image}?imWidth=$imWidth&height=$imHeight").into(holder.image)

        holder.columnOne.setOnClickListener{
            itemClickListner.onItemClick(currentItem.summary)
        }
    }
    override fun getItemCount() = movieList.size
    class ExampleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textTitle: TextView = itemView.title_text_view
        val image: ImageView = itemView.icon_image_view
        val columnOne: RelativeLayout =  itemView.column


    }
}
