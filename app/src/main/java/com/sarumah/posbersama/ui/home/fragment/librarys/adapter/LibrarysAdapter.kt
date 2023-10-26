package com.sarumah.posbersama.ui.home.fragment.librarys.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.inyongtisto.myhelper.extension.getInitial
import com.sarumah.posbersama.core.data.source.modal.Categories
import com.sarumah.posbersama.databinding.ItemCategoriesBinding

@SuppressLint("NotifyDataSetChanged", "SetTextI18n")
class LibrarysAdapter : RecyclerView.Adapter<LibrarysAdapter.ViewHolder>() {

    private var data = ArrayList<Categories>()
    inner class ViewHolder(private val itemBinding: ItemCategoriesBinding): RecyclerView.ViewHolder(itemBinding.root){

            fun bind(item : Categories, position: Int){

                itemBinding.apply {

                    tvName.text = item.name
                    txtQty.text = item.qty+"Product"
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

        fun addItems(items : List<Categories>){
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
