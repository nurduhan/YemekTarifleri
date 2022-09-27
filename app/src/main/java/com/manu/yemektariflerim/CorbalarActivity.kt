package com.manu.yemektariflerim

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.manu.yemektariflerim.databinding.ActivityCorbalarBinding

class CorbalarActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCorbalarBinding
    private lateinit var corbalarList: ArrayList<Corbalar>
    private lateinit var tempCorbalarAdapter: CorbalarAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCorbalarBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        supportActionBar!!.hide()

        corbalarList = ArrayList<Corbalar>()

        val mercimekCorbasi = Corbalar("Mercimek Çorbası", R.drawable.corbalarmercimekimage, getString(R.string.mercimekCorbaMalzemeler), getString(R.string.mercimekCorbaYapilisi))
        val yaylaCorbasi = Corbalar("Yayla Çorbası", R.drawable.corbalaryaylaimage, getString(R.string.yaylaCorbaMalzemeler), getString(R.string.yaylaCorbaYapilisi))
        val domatesCorbasi = Corbalar("Domates Çorbası", R.drawable.corbalardomatesimage, getString(R.string.domatesCorbaMalzemeler), getString(R.string.domatesCorbaYapilisi))
        val yogurtCorbasi = Corbalar("Yoğurt Çorbası", R.drawable.corbalaryogurtimage, getString(R.string.yogurtCorbaMalzemeler), getString(R.string.yogurtCorbaYapilisi))
        val mantarCorbasi = Corbalar("Mantar Çorbası", R.drawable.corbalarmantarimage, getString(R.string.mantarCorbaMalzemeler), getString(R.string.mantarCorbaYapilisi))
        val telSehriyeliTarhanaCorbasi = Corbalar("Tel Şehriyeli Tarhana Çorbası", R.drawable.corbalartelsehriyelitarhanaimage, getString(R.string.telSehriyeliTarhanaCorbaMalzemeler), getString(R.string.telSehriyeliTarhanaCorbaYapilisi))
        val brokoliCorbasi = Corbalar("Brokoli Çorbası", R.drawable.corbalarbrokoliimage, getString(R.string.brokoliCorbaMalzemeler), getString(R.string.brokoliCorbaYapilisi))
        val patatesCorbasi = Corbalar("Patates Çorbası", R.drawable.corbalarpatatesimage, getString(R.string.patatesCorbaMalzemeler), getString(R.string.patatesCorbaYapilisi))
        val kabakCorbasi = Corbalar("Kabak Çorbası", R.drawable.corbalarkabakimage, getString(R.string.kabakCorbaMalzemeler), getString(R.string.kabakCorbaYapilisi))
        val hanimAgaCorbasi = Corbalar("Hanım Ağa Çorbası", R.drawable.corbalarhanimagaimage, getString(R.string.hanimAgaCorbaMalzemeler), getString(R.string.hanimAgaCorbaYapilisi))
        val mahlutaCorbasi = Corbalar("Mahluta Çorbası", R.drawable.corbalarmahlutaimage, getString(R.string.mahlutaCorbaMalzemeler), getString(R.string.mahlutaCorbaYapilisi))
        val analiKizliCorbasi = Corbalar("Analı Kızlı Çorbası", R.drawable.corbalaranalikizliimage, getString(R.string.analiKizliCorbaMalzemeler), getString(R.string.analiKizliCorbaYapilisi))
        val havucCorbasi = Corbalar("Havuç Çorbası", R.drawable.corbalarhavucimage, getString(R.string.havucCorbaMalzemeler), getString(R.string.havucCorbaYapilisi))
        val lebeniyeCorbasi = Corbalar("Lebeniye Çorbası", R.drawable.corbalarlebeniyeimage, getString(R.string.lebeniyeCorbaMalzemeler), getString(R.string.lebeniyeCorbaYapilisi))


        corbalarList.add(mercimekCorbasi)
        corbalarList.add(yaylaCorbasi)
        corbalarList.add(domatesCorbasi)
        corbalarList.add(yogurtCorbasi)
        corbalarList.add(mantarCorbasi)
        corbalarList.add(telSehriyeliTarhanaCorbasi)
        corbalarList.add(brokoliCorbasi)
        corbalarList.add(patatesCorbasi)
        corbalarList.add(kabakCorbasi)
        corbalarList.add(hanimAgaCorbasi)
        corbalarList.add(mahlutaCorbasi)
        corbalarList.add(analiKizliCorbasi)
        corbalarList.add(havucCorbasi)
        corbalarList.add(lebeniyeCorbasi)


        binding.corbalarRecyclerView.layoutManager = LinearLayoutManager(this)
        val corbalarAdapter = CorbalarAdapter(corbalarList)
        binding.corbalarRecyclerView.adapter = corbalarAdapter



        binding.corbalarSearchView.clearFocus()
        binding.corbalarSearchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
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

        var filteredList = ArrayList<Corbalar>()

        for (i in corbalarList) {

            if(i.name.lowercase().contains(text.lowercase())) {
                filteredList.add(i)
            }

        }

        if(filteredList.isEmpty()) {
            filteredList.clear()
            tempCorbalarAdapter = CorbalarAdapter(filteredList)
            tempCorbalarAdapter.notifyDataSetChanged()
            binding.corbalarRecyclerView.adapter = tempCorbalarAdapter
            Toast.makeText(this, "Sonuç bulunamadı", Toast.LENGTH_SHORT).show()
        }
        else {
            tempCorbalarAdapter = CorbalarAdapter(filteredList)
            tempCorbalarAdapter.notifyDataSetChanged()
            binding.corbalarRecyclerView.adapter = tempCorbalarAdapter
        }
    }
}