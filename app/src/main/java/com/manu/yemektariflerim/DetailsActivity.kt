package com.manu.yemektariflerim

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.manu.yemektariflerim.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        supportActionBar!!.hide()

        val intent = intent
        val check = intent.getStringExtra("check")

        when(check) {
            "corbalarkey" -> {
                val selectedItem = intent.getSerializableExtra("corbalar") as Corbalar
                binding.detailsTextView.text = selectedItem.detail
                binding.details2TextView.text = selectedItem.detail2
                binding.detailsImageView.setImageResource(selectedItem.image)
            }
            "anayemeklerkey" -> {
                val selectedItem = intent.getSerializableExtra("anayemekler") as AnaYemekler
                binding.detailsTextView.text = selectedItem.detail
                binding.details2TextView.text = selectedItem.detail2
                binding.detailsImageView.setImageResource(selectedItem.image)
            }
            "hamurisikey" -> {
                val selectedItem = intent.getSerializableExtra("hamurisi") as HamurIsi
                binding.detailsTextView.text = selectedItem.detail
                binding.details2TextView.text = selectedItem.detail2
                binding.detailsImageView.setImageResource(selectedItem.image)
            }
        }
    }
}