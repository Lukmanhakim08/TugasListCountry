package com.example.tugaslistcountry.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tugaslistcountry.Model.GetAllCountryResponseItem
import com.example.tugaslistcountry.R
import kotlinx.android.synthetic.main.item_country.view.*

data class AdapterCountry(private var datacountry : List<GetAllCountryResponseItem>) : RecyclerView.Adapter<AdapterCountry.ViewHolder>(){
    class ViewHolder(itemview : View) : RecyclerView.ViewHolder(itemview){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_country, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.nm_negara.text = datacountry[position].name
        holder.itemView.text_subregion.text = datacountry[position].timezones.toString()
        holder.itemView.text_population.text = datacountry[position].subregion

//        //get data dan menampilkan gambar
        Glide.with(holder.itemView.context)
            .load(datacountry[position].flags.png)
            .into(holder.itemView.img_country)
    }

    override fun getItemCount(): Int {
        return datacountry.size
    }

}
