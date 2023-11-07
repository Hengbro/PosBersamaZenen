package com.sarumah.posbersama.ui.menu.listmenu.productinventory.modifiersoptions.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sarumah.posbersama.core.source.model.Topings
import com.sarumah.posbersama.databinding.ItemModifiersoptionsBinding

@SuppressLint("NotifyDataSetChanged", "SetTextI18n")
class TopingOptionsAdapter : RecyclerView.Adapter<TopingOptionsAdapter.ViewHolder>() {

    private var data = ArrayList<Topings>()
    inner class ViewHolder(private val itemBinding: ItemModifiersoptionsBinding): RecyclerView.ViewHolder(itemBinding.root){

            fun bind(item : Topings, position: Int){

                itemBinding.apply {

                    tvName.text = item.name
                    tvType.text = item.type
                    tvQty.text = item.qty+" Product"

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

        fun addItems(items : List<Topings>){
            data.clear()
            data.addAll(items)
            notifyDataSetChanged()
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            return ViewHolder(ItemModifiersoptionsBinding.inflate(
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
