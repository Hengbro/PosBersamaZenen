package com.sarumah.posbersama.ui.home.orderproduct.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.inyongtisto.myhelper.extension.intentActivity
import com.inyongtisto.myhelper.extension.popUpMenu
import com.inyongtisto.myhelper.extension.toRupiah
import com.sarumah.posbersama.core.data.source.modal.Products
import com.sarumah.posbersama.core.data.source.modal.Topings
import com.sarumah.posbersama.core.data.source.modal.Variations
import com.sarumah.posbersama.databinding.ItemProductBinding
import com.sarumah.posbersama.databinding.ItemTopingsBinding
import com.sarumah.posbersama.databinding.ItemVaritionBinding
import com.sarumah.posbersama.ui.menu.CustomizeNavbarActivity

@SuppressLint("NotifyDataSetChanged", "SetTextI18n")
class VariationsAdapter : RecyclerView.Adapter<VariationsAdapter.ViewHolder>() {

    private var data = ArrayList<Variations>()
    inner class ViewHolder(private val itemBinding: ItemVaritionBinding): RecyclerView.ViewHolder(itemBinding.root){

            fun bind(item : Variations, position: Int){

                itemBinding.apply {

                    tvName.text = item.name
                    txtPrice.text = item.price.toRupiah()

                }
            }
        }

        fun removeAt(index: Int) {
            data.removeAt(index)
            notifyItemRemoved(index)
        }

        fun addItems(items : List<Variations>){
            data.clear()
            data.addAll(items)
            notifyDataSetChanged()
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            return ViewHolder(ItemVaritionBinding.inflate(
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
