package com.sarumah.posbersama.ui.home.fragment.librarys.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.inyongtisto.myhelper.extension.getInitial
import com.sarumah.posbersama.core.data.source.modal.CategoryJava
import com.sarumah.posbersama.databinding.ItemCategoriesBinding

@SuppressLint("NotifyDataSetChanged", "SetTextI18n")
class CategoryAdapter : RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    private var data = ArrayList<CategoryJava>()
    inner class ViewHolder(private val itemBinding: ItemCategoriesBinding): RecyclerView.ViewHolder(itemBinding.root){

            fun bind(item : CategoryJava, position: Int){

                itemBinding.apply {

                    tvName.text = item.name
                    //txtQty.text = item.qty
                    txtIntial.text = item.name.getInitial()

                    /*layout.setOnClickListener{
                        onClick.invoke(item)
                    }*/
                }
            }
        }

        fun removeAt(index: Int) {
            data.removeAt(index)
            notifyItemRemoved(index)
        }

        fun addItems(items : List<CategoryJava>){
            data.clear()
            data.addAll(items)
            notifyDataSetChanged()
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            return ViewHolder(ItemCategoriesBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false))
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.bind(data[position], position)
        }

        override fun getItemCount(): Int {
            return data.size
        }

    }
