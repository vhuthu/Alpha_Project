package com.example.storess.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.storess.Model.ProductsModel
import com.example.storess.R

class ProductAdapter(var context: Context , var productsModelList: MutableList<ProductsModel>):
    RecyclerView.Adapter<ProductAdapter.MyViewModel>(){
    inner class MyViewModel(itemView : View) : RecyclerView.ViewHolder(itemView) {

        var imgMovie:ImageView
        var txtMovieName:TextView
        var txtTeam:TextView
    init {

        imgMovie = itemView.findViewById(R.id.img)
        txtMovieName = itemView.findViewById(R.id.textMovieName)
        txtTeam = itemView.findViewById(R.id.textTeam)
    }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewModel {
       return MyViewModel(LayoutInflater.from(context).inflate(R.layout.layout_list, parent, false))
    }

    override fun getItemCount(): Int {
        return productsModelList.size
    }

    override fun onBindViewHolder(holder: MyViewModel, position: Int) {


        val product = productsModelList[position]


        Glide.with(context)
            .load(product.imageurl)
            .into(holder.imgMovie)

        holder.txtMovieName.text = productsModelList[position].name
        holder.txtTeam.text = productsModelList[position].team
    }


}