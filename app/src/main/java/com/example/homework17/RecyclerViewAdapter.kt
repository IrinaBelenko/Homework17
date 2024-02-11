package com.example.homework17

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class RecyclerViewAdapter (private val items: MutableList<Hero>,  val onItemClick:(item:Hero)->Unit): RecyclerView.Adapter<RecycleViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecycleViewHolder {
        val listItemView =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item_layout, parent, false)
        return RecycleViewHolder(listItemView)
    }

    override fun getItemCount(): Int = items.count()

    override fun onBindViewHolder(holder: RecycleViewHolder, position: Int) {
        holder.name.text = items[position].name
        holder.race.text = items[position].appearance.race
        Glide.with(holder.itemView.context)
            .load(items[position].images.sm)
            .into(holder.image)
        holder.itemView.setOnClickListener {
            onItemClick(items[position])
        }
    }
}

class RecycleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val name: TextView = itemView.findViewById(R.id.listName)
    val race: TextView = itemView.findViewById(R.id.listRace)
    val image: ImageView = itemView.findViewById(R.id.listImage)
}