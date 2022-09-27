package com.manu.yemektariflerim

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.manu.yemektariflerim.databinding.RecyclerRowBinding

class AnaMenuAdapter(var anaMenuList: ArrayList<AnaMenu>): RecyclerView.Adapter<AnaMenuAdapter.AnaMenuHolder>() {

    class AnaMenuHolder(val binding: RecyclerRowBinding): RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnaMenuHolder {
        val binding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return AnaMenuHolder(binding)
    }

    override fun onBindViewHolder(holder: AnaMenuHolder, position: Int) {
        holder.binding.recyclerViewImageView.setImageResource(anaMenuList.get(position).image)
        holder.binding.recyclerViewTextView.text = anaMenuList.get(position).name

        holder.itemView.setOnClickListener {

            when(anaMenuList.get(position).name){
                "Çorbalar" -> {
                    val intent = Intent(holder.itemView.context,CorbalarActivity::class.java)
                    holder.itemView.context.startActivity(intent)
                }

                "Ana Yemekler" -> {
                    val intent = Intent(holder.itemView.context,AnaYemeklerActivity::class.java)
                    holder.itemView.context.startActivity(intent)
                }

                "Hamur İşi" -> {
                    val intent = Intent(holder.itemView.context,HamurIsiActivity::class.java)
                    holder.itemView.context.startActivity(intent)
                }
            }
        }


    }

    override fun getItemCount(): Int {
        return anaMenuList.size
    }


}