package com.sarumah.posbersama.ui.menu.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sarumah.posbersama.core.source.model.Menu
import com.sarumah.posbersama.databinding.ItemMenumanageBinding

@SuppressLint("NotifyDataSetChanged", "SetTextI18n")
class MenuAdapter (
    val onClick : (item : Menu, pos: Int) -> Unit
): RecyclerView.Adapter<MenuAdapter.ViewHolder>() {

    private var data = ArrayList<Menu>()
    inner class ViewHolder(private val itemBinding: ItemMenumanageBinding): RecyclerView.ViewHolder(itemBinding.root){

            fun bind(item : Menu, position: Int){

                itemBinding.apply {

                    txtMenu.text = item.name
                    btnImage.setImageResource(item.image)

                    layout.setOnClickListener {
                        onClick.invoke(item, adapterPosition)
                    }
                }
            }
        }

        fun removeAt(index: Int) {
            data.removeAt(index)
            notifyItemRemoved(index)
        }

        fun addItems(items : List<Menu>){
            data.clear()
            data.addAll(items)
            notifyDataSetChanged()
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            return ViewHolder(ItemMenumanageBinding.inflate(
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
