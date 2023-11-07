package com.sarumah.posbersama.ui.category.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.inyongtisto.myhelper.extension.*
import com.sarumah.posbersama.core.source.local.entity.CategoryEntity
import com.sarumah.posbersama.databinding.ItemCategoriesBinding

class CategoryAdapter(
    var onClick: ((data: CategoryEntity) -> Unit?)? = null,
    var onDelete: ((data: CategoryEntity) -> Unit?)? = null,
) : ListAdapter<CategoryEntity, CategoryAdapter.ViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemCategoriesBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        return holder.bind(getItem(position))
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    fun removeAt(index: Int): List<CategoryEntity> {
        val list = ArrayList(currentList)
        list.removeAt(index)
        submitList(list)
        return list
    }

    inner class ViewHolder(private val itemBinding: ItemCategoriesBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(item: CategoryEntity) {
            with(itemBinding) {
                tvName.text = item.name
                lyMain.setOnClickListener {
                    onClick?.invoke(item)
                }

                tvName.setOnClickListener {
                    onDelete?.invoke(item)
                }
            }
        }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<CategoryEntity>() {
            override fun areItemsTheSame(
                oldItem: CategoryEntity,
                newItem: CategoryEntity
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: CategoryEntity,
                newItem: CategoryEntity
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}