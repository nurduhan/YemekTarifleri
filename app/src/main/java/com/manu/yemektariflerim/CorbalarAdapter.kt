package com.manu.yemektariflerim

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.manu.yemektariflerim.databinding.RecyclerRowBinding

class CorbalarAdapter(val corbalarList: ArrayList<Corbalar>): RecyclerView.Adapter<CorbalarAdapter.CorbalarHolder>() {

    class CorbalarHolder(val binding: RecyclerRowBinding): RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CorbalarHolder {
        val binding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CorbalarHolder(binding)
    }

    override fun onBindViewHolder(holder: CorbalarHolder, position: Int) {
        holder.binding.recyclerViewImageView.setImageResource(corbalarList.get(position).image)
        holder.binding.recyclerViewTextView.text = corbalarList.get(position).name


        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context,DetailsActivity::class.java)
            intent.putExtra("check","corbalarkey")
            intent.putExtra("corbalar",corbalarList.get(position))
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return corbalarList.size
    }

}