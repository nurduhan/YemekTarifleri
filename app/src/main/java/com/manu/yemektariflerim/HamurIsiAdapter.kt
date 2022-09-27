package com.manu.yemektariflerim

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.manu.yemektariflerim.databinding.RecyclerRowBinding

class HamurIsiAdapter(val hamurIsiList: ArrayList<HamurIsi>): RecyclerView.Adapter<HamurIsiAdapter.HamurIsiHolder>() {

    class HamurIsiHolder(val binding: RecyclerRowBinding): RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HamurIsiHolder {
        val binding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return HamurIsiHolder(binding)
    }

    override fun onBindViewHolder(holder: HamurIsiHolder, position: Int) {
        holder.binding.recyclerViewImageView.setImageResource(hamurIsiList.get(position).image)
        holder.binding.recyclerViewTextView.text = hamurIsiList.get(position).name


        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context,DetailsActivity::class.java)
            intent.putExtra("check","hamurisikey")
            intent.putExtra("hamurisi",hamurIsiList.get(position))
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return hamurIsiList.size
    }

}