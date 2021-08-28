package com.example.viewpagertask

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


class Adapter(val list:ArrayList<ViewPagerModel>,val context: Context) : RecyclerView.Adapter<Adapter.Vholder>() {

    class Vholder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val view :ImageView =itemView.findViewById<ImageView>(R.id.view)
        val middletextview :TextView =itemView.findViewById<TextView>(R.id.middletextview)
        val uppertext :TextView =itemView.findViewById<TextView>(R.id.middleuppertext)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vholder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.slider_item,parent,false)
     return Vholder(view)
    }

    override fun onBindViewHolder(holder: Vholder, position: Int) {
      Glide.with(context).load(list[position].image).into(holder.view)
        holder.middletextview.text =list[position].middlename
        holder.uppertext.text=list[position].uppername
    }

    override fun getItemCount(): Int {
     return list.size
    }
}