package com.zahirar.latch6tpc5dependecyinjection.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.zahirar.latch6tpc5dependecyinjection.databinding.ItemMakeUpBinding
import com.zahirar.latch6tpc5dependecyinjection.model.GetMakeUpResponseItem

class MakeUpAdapter(var listMakeUp : List<GetMakeUpResponseItem>): RecyclerView.Adapter<MakeUpAdapter.ViewHolder>() {
    class ViewHolder(var binding: ItemMakeUpBinding): RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MakeUpAdapter.ViewHolder {
        var view = ItemMakeUpBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: MakeUpAdapter.ViewHolder, position: Int) {
        holder.binding.txtName.text = listMakeUp[position].name
        holder.binding.txtBrand.text = listMakeUp[position].brand
        holder.binding.txtCategory.text = listMakeUp[position].category
        holder.binding.txtPrice.text = listMakeUp[position].price
        holder.binding.txtImg.text = listMakeUp[position].imageLink
        Glide.with(holder.itemView).load(listMakeUp[position].imageLink).into(holder.binding.imgMakeUp)
    }

    override fun getItemCount(): Int {
        return listMakeUp.size
    }
}