package com.example.todoapp

import android.content.Intent
import android.graphics.Color

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.databinding.ViewBinding
import java.util.Locale


class Adapter(var data: List<CardInfo>) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    inner class ViewHolder(val binding: ViewBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       return ViewHolder(ViewBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        when (data[position].priority.lowercase(Locale.getDefault())) {
            "high" -> holder.binding.mLayout.setBackgroundColor(Color.parseColor("#F05454"))
            "medium" -> holder.binding.mLayout.setBackgroundColor(Color.parseColor("#EDC988"))
            else->holder.binding.mLayout.setBackgroundColor(Color.parseColor("#80CBC4"))

        }

        holder.binding.title.text = data[position].title
        holder.binding.priority.text = data[position].priority

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context,UpdateCard::class.java)
            intent.putExtra("id",position)
            holder.itemView.context.startActivity(intent)
        }
    }
}