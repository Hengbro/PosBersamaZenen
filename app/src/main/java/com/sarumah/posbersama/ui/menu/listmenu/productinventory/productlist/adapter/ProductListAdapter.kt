package com.sarumah.posbersama.ui.menu.listmenu.productinventory.productlist.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sarumah.posbersama.core.data.source.modal.Products
import com.sarumah.posbersama.databinding.ItemProductoptionsBinding

@SuppressLint("NotifyDataSetChanged", "SetTextI18n")
class ProductListAdapter : RecyclerView.Adapter<ProductListAdapter.ViewHolder>() {

    private var data = ArrayList<Products>()
    inner class ViewHolder(private val itemBinding: ItemProductoptionsBinding): RecyclerView.ViewHolder(itemBinding.root){

            fun bind(item : Products, position: Int){

                itemBinding.apply {

                    tvName.text = item.name
                    imgProduct.setImageResource(item.imageDummy)

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

        fun addItems(items : List<Products>){
            data.clear()
            data.addAll(items)
            notifyDataSetChanged()
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            return ViewHolder(ItemProductoptionsBinding.inflate(
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
