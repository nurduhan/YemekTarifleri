package com.manu.yemektariflerim

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.View
import androidx.appcompat.widget.SearchView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.manu.yemektariflerim.databinding.ActivityMainBinding
import java.io.Serializable
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var anaMenuList: ArrayList<AnaMenu>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        supportActionBar!!.hide()

        anaMenuList = ArrayList<AnaMenu>()

        val corbalar = AnaMenu("Çorbalar", R.drawable.maincorbalarimage)
        val anaYemekler = AnaMenu("Ana Yemekler", R.drawable.mainanayemeklerimage)
        val hamurIsi = AnaMenu("Hamur İşi", R.drawable.mainhamurisiimage)

        anaMenuList.add(corbalar)
        anaMenuList.add(anaYemekler)
        anaMenuList.add(hamurIsi)


        binding.mainRecyclerView.layoutManager = LinearLayoutManager(this)
        val anaMenuAdapter = AnaMenuAdapter(anaMenuList)
        binding.mainRecyclerView.adapter = anaMenuAdapter

    }
}