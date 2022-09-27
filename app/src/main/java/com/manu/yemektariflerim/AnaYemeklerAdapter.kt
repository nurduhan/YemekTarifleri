package com.manu.yemektariflerim

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.manu.yemektariflerim.databinding.RecyclerRowBinding

class AnaYemeklerAdapter(val anaYemeklerList: ArrayList<AnaYemekler>): RecyclerView.Adapter<AnaYemeklerAdapter.AnaYemeklerHolder>() {

    class AnaYemeklerHolder(val binding: RecyclerRowBinding) :RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnaYemeklerHolder {
        val binding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AnaYemeklerHolder(binding)
    }

    override fun onBindViewHolder(holder: AnaYemeklerHolder, position: Int) {
        holder.binding.recyclerViewImageView.setImageResource(anaYemeklerList.get(position).image)
        holder.binding.recyclerViewTextView.text = anaYemeklerList.get(position).name

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetailsActivity::class.java)
            intent.putExtra("check","anayemeklerkey")
            intent.putExtra("anayemekler", anaYemeklerList.get(position))
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return anaYemeklerList.size
    }
}