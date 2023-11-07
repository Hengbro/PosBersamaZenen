package com.sarumah.posbersama

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.inyongtisto.myhelper.extension.intentActivity
import com.inyongtisto.myhelper.extension.popUpMenu
import com.inyongtisto.myhelper.extension.toRupiah
import com.sarumah.posbersama.core.source.model.Products
import com.sarumah.posbersama.databinding.ItemProductBinding
import com.sarumah.posbersama.ui.menu.CustomizeNavbarActivity

@SuppressLint("NotifyDataSetChanged", "SetTextI18n")
class EmpetyAdapter : RecyclerView.Adapter<EmpetyAdapter.ViewHolder>() {

    private var data = ArrayList<Products>()
    inner class ViewHolder(private val itemBinding: ItemProductBinding): RecyclerView.ViewHolder(itemBinding.root){

            fun bind(item : Products, position: Int){

                itemBinding.apply {

                    tvName.text = item.name
                    txtPrice.text = item.price.toRupiah()
                    imgProduct.setImageResource(item.imageDummy)

                    val context = root.context
                    imgMenuproduct.setOnClickListener{
                        val listMenu = listOf("Edit product", "Add to favorites")
                        context.popUpMenu(imgMenuproduct, listMenu) {
                            when (it) {
                                "Edit product" -> context.intentActivity(EmptyActivity::class.java)
                                "Add to favorites" -> context.intentActivity(CustomizeNavbarActivity::class.java)
                            }
                        }
                    }
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
            return ViewHolder(ItemProductBinding.inflate(
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
