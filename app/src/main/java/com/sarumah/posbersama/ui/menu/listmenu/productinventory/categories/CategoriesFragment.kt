package com.sarumah.posbersama.ui.menu.listmenu.productinventory.categories

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.inyongtisto.myhelper.extension.intentActivity
import com.sarumah.posbersama.core.room.AppDatabaseOld
import com.sarumah.posbersama.core.source.model.CategoryJava
import com.sarumah.posbersama.databinding.FragmentCategoriesBinding
import com.sarumah.posbersama.ui.menu.listmenu.productinventory.categories.adapter.CategoryMenuAdapter

class CategoriesFragment : Fragment() {

    private var _binding: FragmentCategoriesBinding? = null
    private var list = mutableListOf<CategoryJava>()
    private lateinit var adapterCategory: CategoryMenuAdapter
    private lateinit var database: AppDatabaseOld
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentCategoriesBinding.inflate(inflater, container, false)

        database = AppDatabaseOld.getDatabase(requireContext().applicationContext)
        adapterCategory = CategoryMenuAdapter(list)

        mainButton()
        setdataAdapter()


        return binding.root
    }

    override fun onResume() {
        super.onResume()
        setDataCategories()
    }

    private fun mainButton(){
        binding.apply {
            btnAddnewcategories.setOnClickListener{
                intentActivity(AddCategoriesActivity::class.java)
            }
        }
    }

    private fun setdataAdapter(){
        binding.apply {
            rvCategories.adapter = adapterCategory
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun setDataCategories(){
        list.clear()
        list.addAll(database.categoryDao().getAllCategories())
        adapterCategory.notifyDataSetChanged()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
