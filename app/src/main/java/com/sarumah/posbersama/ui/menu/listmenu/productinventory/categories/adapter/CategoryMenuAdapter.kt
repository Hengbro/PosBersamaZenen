package com.sarumah.posbersama.ui.menu.listmenu.productinventory.categories.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sarumah.posbersama.R
import com.sarumah.posbersama.core.source.model.CategoryJava

class CategoryMenuAdapter (var list: List<CategoryJava>) :
    RecyclerView.Adapter<CategoryMenuAdapter.ViewHolder>() {

    class ViewHolder (view: View) : RecyclerView.ViewHolder(view){
        var name: TextView

        init {
            name = view.findViewById(R.id.tv_name)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_addcategories, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = list[position].name
    }
}