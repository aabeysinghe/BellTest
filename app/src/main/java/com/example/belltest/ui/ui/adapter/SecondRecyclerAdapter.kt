package com.example.belltest.ui.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.belltest.R
import com.example.fragmentcommunicate.Pojo.MovieCollection
import kotlinx.android.synthetic.main.fragment_first_item.view.itemTitle
import kotlinx.android.synthetic.main.fragment_second_item.view.*


class SecondRecyclerAdapter(private val movieList: List<MovieCollection>) :
    RecyclerView.Adapter<SecondRecyclerAdapter.ExampleViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExampleViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.fragment_second_item,
            parent, false)
        return ExampleViewHolder(itemView)
    }
    override fun onBindViewHolder(holder: ExampleViewHolder, position: Int) {
        val currentItem = movieList[position]
        holder.textTitle.text = currentItem.title
        holder.screenType.text = currentItem.style
    }
    override fun getItemCount() = movieList.size
    class ExampleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textTitle: TextView = itemView.itemTitle
        val screenType: TextView = itemView.itemStyle
    }
}