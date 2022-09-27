package com.manu.yemektariflerim

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.manu.yemektariflerim.databinding.ActivityAnaYemeklerBinding

class AnaYemeklerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAnaYemeklerBinding
    private lateinit var anaYemeklerList: ArrayList<AnaYemekler>
    private lateinit var tempAnaYemeklerAdapter: AnaYemeklerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnaYemeklerBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        supportActionBar!!.hide()

        anaYemeklerList = ArrayList<AnaYemekler>()

        val firindaTavukKanat = AnaYemekler("Fırında Tavuk Kanat", R.drawable.anayemeklerfirindatavukkanatimage, getString(R.string.firindaTavukKanatMalzemeler), getString(R.string.firindaTavukKanatYapilisi))
        val terbiyeliSuluKofte = AnaYemekler("Terbiyeli Sulu Köfte", R.drawable.anayemeklerterbiyelisulukofteimage, getString(R.string.terbiyeliSuluKofteMalzemeler), getString(R.string.terbiyeliSuluKofteYapilisi))
        val firindaTavukSis = AnaYemekler("Fırında Tavuk Şiş", R.drawable.anayemeklerfirindatavuksisimage, getString(R.string.firindaTavukSisMalzemeler), getString(R.string.firindaTavukSisYapilisi))
        val peynirliPatlican = AnaYemekler("Peynirli Patlıcan", R.drawable.anayemeklerpeynirlipatlicanimage, getString(R.string.peynirliPatlicanMalzemeler), getString(R.string.peynirliPatlicanYapilisi))
        val zeytinyagliLahanaSarmasi = AnaYemekler("Zeytinyağlı Lahana Sarması", R.drawable.anayemeklerzeytinyaglilahanasarmasiimage, getString(R.string.zeytinyagliLahanaSarmasiMalzemeler), getString(R.string.zeytinyagliLahanaSarmasiYapilisi))
        val sebzeliKofte = AnaYemekler("Sebzeli Köfte", R.drawable.anayemeklersebzelikofteimage, getString(R.string.sebzeliKofteMalzemeler), getString(R.string.sebzeliKofteYapilisi))
        val sultanKebabi = AnaYemekler("Sultan Kebabı", R.drawable.anayemeklersultankebabiimage, getString(R.string.sultanKebabiMalzemeler), getString(R.string.sultanKebabiYapilisi))
        val patlicanGraten = AnaYemekler("Patlıcan Graten", R.drawable.anayemeklerpatlicangratenimage, getString(R.string.patlicanGratenMalzemeler), getString(R.string.patlicanGratenYapilisi))
        val pirasaliMucver = AnaYemekler("Pırasalı Mücver", R.drawable.anayemeklerpirasalimucverimage, getString(R.string.pirasaliMucverMalzemeler), getString(R.string.pirasaliMucverYapilisi))
        val mantarSote = AnaYemekler("Mantar Sote", R.drawable.anayemeklermantarsoteimage, getString(R.string.mantarSoteMalzemeler), getString(R.string.mantarSoteYapilisi))
        val besamelSosluTavukGuvec = AnaYemekler("Beşamel Soslu Tavuk Güveç", R.drawable.anayemeklerbesamelsoslutavukguvecimage, getString(R.string.besamelSosluTavukGuvecMalzemeler), getString(R.string.besamelSosluTavukGuvecYapilisi))



        anaYemeklerList.add(firindaTavukKanat)
        anaYemeklerList.add(terbiyeliSuluKofte)
        anaYemeklerList.add(firindaTavukSis)
        anaYemeklerList.add(peynirliPatlican)
        anaYemeklerList.add(zeytinyagliLahanaSarmasi)
        anaYemeklerList.add(sebzeliKofte)
        anaYemeklerList.add(sultanKebabi)
        anaYemeklerList.add(patlicanGraten)
        anaYemeklerList.add(pirasaliMucver)
        anaYemeklerList.add(mantarSote)
        anaYemeklerList.add(besamelSosluTavukGuvec)



        binding.anaYemeklerRecyclerView.layoutManager = LinearLayoutManager(this)
        val anaYemeklerAdapter = AnaYemeklerAdapter(anaYemeklerList)
        binding.anaYemeklerRecyclerView.adapter = anaYemeklerAdapter


        binding.anaYemeklerSearchView.clearFocus()
        binding.anaYemeklerSearchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
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

        var filteredList = ArrayList<AnaYemekler>()

        for (i in anaYemeklerList) {

            if(i.name.lowercase().contains(text.lowercase())) {
                filteredList.add(i)
            }

        }

        if(filteredList.isEmpty()) {
            filteredList.clear()
            tempAnaYemeklerAdapter = AnaYemeklerAdapter(filteredList)
            tempAnaYemeklerAdapter.notifyDataSetChanged()
            binding.anaYemeklerRecyclerView.adapter = tempAnaYemeklerAdapter
            Toast.makeText(this, "Sonuç bulunamadı", Toast.LENGTH_SHORT).show()
        }
        else {
            tempAnaYemeklerAdapter = AnaYemeklerAdapter(filteredList)
            tempAnaYemeklerAdapter.notifyDataSetChanged()
            binding.anaYemeklerRecyclerView.adapter = tempAnaYemeklerAdapter
        }
    }
}