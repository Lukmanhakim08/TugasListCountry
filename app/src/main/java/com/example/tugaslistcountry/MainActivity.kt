package com.example.tugaslistcountry

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tugaslistcountry.Adapter.AdapterCountry
import com.example.tugaslistcountry.Model.GetAllCountryResponseItem
import com.example.tugaslistcountry.Network.ApiClient
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getDataCountry()
    }

    fun getDataCountry(){
        ApiClient.instance.getallCountry()
            .enqueue(object : retrofit2.Callback<List<GetAllCountryResponseItem>>{
                override fun onResponse(
                    call: Call<List<GetAllCountryResponseItem>>,
                    response: Response<List<GetAllCountryResponseItem>>
                ) {
                    if (response.isSuccessful){
                        val datacountry = response.body()
                        val adapterCountry = AdapterCountry(datacountry!!)
                        val tampil = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL,false)
                        rv_country.layoutManager = tampil
                        rv_country.adapter = adapterCountry
                    }else{
                        Toast.makeText(this@MainActivity, response.message(), Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<List<GetAllCountryResponseItem>>, t: Throwable) {
                    Toast.makeText(this@MainActivity, t.message, Toast.LENGTH_SHORT).show()
                }

            })
    }
}