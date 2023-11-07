package com.sarumah.posbersama.ui.home.orderproduct.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.inyongtisto.myhelper.extension.toRupiah
import com.sarumah.posbersama.core.source.model.Topings
import com.sarumah.posbersama.databinding.ItemTopingsBinding

@SuppressLint("NotifyDataSetChanged", "SetTextI18n")
class TopingsAdapter : RecyclerView.Adapter<TopingsAdapter.ViewHolder>() {

    private var data = ArrayList<Topings>()
    inner class ViewHolder(private val itemBinding: ItemTopingsBinding): RecyclerView.ViewHolder(itemBinding.root){

            fun bind(item : Topings, position: Int){

                itemBinding.apply {

                    tvName.text = item.name
                    txtPrice.text = "+ "+item.price.toRupiah()

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
            return ViewHolder(ItemTopingsBinding.inflate(
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
