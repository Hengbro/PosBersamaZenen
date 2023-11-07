package com.sarumah.posbersama.ui.home.orderproduct.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sarumah.posbersama.core.source.model.Texass
import com.sarumah.posbersama.databinding.ItemTaxesBinding

@SuppressLint("NotifyDataSetChanged", "SetTextI18n")
class TexassAdapter : RecyclerView.Adapter<TexassAdapter.ViewHolder>() {

    private var data = ArrayList<Texass>()
    inner class ViewHolder(private val itemBinding: ItemTaxesBinding): RecyclerView.ViewHolder(itemBinding.root){

            fun bind(item : Texass, position: Int){

                itemBinding.apply {

                    tvName.text = item.name
                    txtPersen.text = item.persen.toString()+"%"

                }
            }
        }

        fun removeAt(index: Int) {
            data.removeAt(index)
            notifyItemRemoved(index)
        }

        fun addItems(items : List<Texass>){
            data.clear()
            data.addAll(items)
            notifyDataSetChanged()
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            return ViewHolder(ItemTaxesBinding.inflate(
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
