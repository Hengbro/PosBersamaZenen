package com.sarumah.posbersama.ui.menu.listmenu.productinventory.variantoptions.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sarumah.posbersama.core.data.source.modal.VariantOptions
import com.sarumah.posbersama.databinding.ItemVaritionoptionsBinding

@SuppressLint("NotifyDataSetChanged", "SetTextI18n")
class VariantOptionsAdapter : RecyclerView.Adapter<VariantOptionsAdapter.ViewHolder>() {

    private var data = ArrayList<VariantOptions>()
    inner class ViewHolder(private val itemBinding: ItemVaritionoptionsBinding): RecyclerView.ViewHolder(itemBinding.root){

            fun bind(item : VariantOptions, position: Int){

                itemBinding.apply {

                    tvName.text = item.name
                    txtType.text = item.type

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

        fun addItems(items : List<VariantOptions>){
            data.clear()
            data.addAll(items)
            notifyDataSetChanged()
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            return ViewHolder(ItemVaritionoptionsBinding.inflate(
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
