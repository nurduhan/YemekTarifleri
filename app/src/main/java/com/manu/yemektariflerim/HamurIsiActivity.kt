package com.manu.yemektariflerim

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.manu.yemektariflerim.databinding.ActivityHamurIsiBinding

class HamurIsiActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHamurIsiBinding
    private lateinit var hamurIsiList: ArrayList<HamurIsi>
    private lateinit var tempHamurIsiAdapter: HamurIsiAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHamurIsiBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        supportActionBar!!.hide()

        hamurIsiList = ArrayList<HamurIsi>()

        val mayasizUcgenPisi = HamurIsi("Mayasız Üçgen Pişi", R.drawable.hamurisimayasizucgenpisiimage, getString(R.string.mayasizUcgenPisiMalzemeler), getString(R.string.mayasizUcgenPisiYapilisi))
        val firindaPacangaBoregi = HamurIsi("Fırında Paçanga Böreği", R.drawable.hamurisifirindapacangaboregiimage, getString(R.string.firindaPacangaBoregiMalzemeler), getString(R.string.firindaPacangaBoregiYapilisi))
        val kiymaliMiniPide = HamurIsi("Kıymalı Mini Pide", R.drawable.hamurisikiymaliminipideimage, getString(R.string.kiymaliMiniPideMalzemeler), getString(R.string.kiymaliMiniPideYapilisi))
        val peynirliPankek = HamurIsi("Peynirli Pankek", R.drawable.hamurisipeynirlipankekimage, getString(R.string.peynirliPankekMalzemeler), getString(R.string.peynirliPankekYapilisi))
        val miniBazlama = HamurIsi("Mini Bazlama", R.drawable.hamurisiminibazlamaimage, getString(R.string.miniBazlamaMalzemeler), getString(R.string.miniBazlamaYapilisi))
        val cubukPisi = HamurIsi("Çubuk Pişi", R.drawable.hamurisicubukpisiimage, getString(R.string.cubukPisiMalzemeler), getString(R.string.cubukPisiYapilisi))
        val mayasizTelGozleme = HamurIsi("Mayasız Tel Gözleme", R.drawable.hamurisimayasiztelgozlemeimage, getString(R.string.mayasizTelGozlemeMalzemeler), getString(R.string.mayasizTelGozlemeYapilisi))
        val ruloMilfoy = HamurIsi("Rulo Milföy", R.drawable.hamurisirulomilfoyimage, getString(R.string.ruloMilfoyMalzemeler), getString(R.string.ruloMilfoyYapilisi))
        val kahvaltiEkmegi = HamurIsi("Kahvaltı Ekmeği", R.drawable.hamurisikahvaltiekmegiimage, getString(R.string.kahvaltiEkmegiMalzemeler), getString(R.string.kahvaltiEkmegiYapilisi))
        val sodaliDilimBorek = HamurIsi("Sodalı Dilim Börek", R.drawable.hamurisisodalidilimborekimage, getString(R.string.sodaliDilimBorekMalzemeler), getString(R.string.sodaliDilimBorekYapilisi))
        val susamliSimitPogaca = HamurIsi("Susamlı Simit Poğaça", R.drawable.hamurisisusamlisimitpogacaimage, getString(R.string.susamliSimitPogacaMalzemeler), getString(R.string.susamliSimitPogacaYapilisi))
        val patatesliGozleme = HamurIsi("Patatesli Gözleme", R.drawable.hamurisipatatesligozlemeimage, getString(R.string.patatesliGozlemeMalzemeler), getString(R.string.patatesliGozlemeYapilisi))
        val kahvaltilikKrep = HamurIsi("Kahvaltılık Krep", R.drawable.hamurisikahvaltilikkrepimage, getString(R.string.kahvaltilikKrepMalzemeler), getString(R.string.kahvaltilikKrepYapilisi))


        hamurIsiList.add(mayasizUcgenPisi)
        hamurIsiList.add(firindaPacangaBoregi)
        hamurIsiList.add(kiymaliMiniPide)
        hamurIsiList.add(peynirliPankek)
        hamurIsiList.add(miniBazlama)
        hamurIsiList.add(cubukPisi)
        hamurIsiList.add(mayasizTelGozleme)
        hamurIsiList.add(ruloMilfoy)
        hamurIsiList.add(kahvaltiEkmegi)
        hamurIsiList.add(sodaliDilimBorek)
        hamurIsiList.add(susamliSimitPogaca)
        hamurIsiList.add(patatesliGozleme)
        hamurIsiList.add(kahvaltilikKrep)


        binding.hamurIsiRecyclerView.layoutManager = LinearLayoutManager(this)
        val hamurIsiAdapter = HamurIsiAdapter(hamurIsiList)
        binding.hamurIsiRecyclerView.adapter = hamurIsiAdapter



        binding.hamurIsiSearchView.clearFocus()
        binding.hamurIsiSearchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                filterList(newText)
                return true
            }

        })
    }

    fun filterList(text: String) {

        var filteredList = ArrayList<HamurIsi>()

        for (i in hamurIsiList) {

            if(i.name.lowercase().contains(text.lowercase())) {
                filteredList.add(i)
            }

        }

        if(filteredList.isEmpty()) {
            filteredList.clear()
            tempHamurIsiAdapter = HamurIsiAdapter(filteredList)
            tempHamurIsiAdapter.notifyDataSetChanged()
            binding.hamurIsiRecyclerView.adapter = tempHamurIsiAdapter
            Toast.makeText(this, "Sonuç bulunamadı", Toast.LENGTH_SHORT).show()
        }
        else {
            tempHamurIsiAdapter = HamurIsiAdapter(filteredList)
            tempHamurIsiAdapter.notifyDataSetChanged()
            binding.hamurIsiRecyclerView.adapter = tempHamurIsiAdapter
        }
    }
}