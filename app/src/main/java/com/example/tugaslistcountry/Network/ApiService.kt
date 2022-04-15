package com.example.tugaslistcountry.Network

import com.example.tugaslistcountry.Model.GetAllCountryResponseItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("all")
    fun getallCountry(): Call<List<GetAllCountryResponseItem>>

}