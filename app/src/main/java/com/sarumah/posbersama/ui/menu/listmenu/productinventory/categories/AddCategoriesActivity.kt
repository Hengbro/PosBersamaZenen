package com.sarumah.posbersama.ui.menu.listmenu.productinventory.categories

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.sarumah.posbersama.databinding.ActivityAddnewcategoriesBinding
import com.sarumah.posbersama.ui.home.fragment.librarys.LibrarysViewModel
import com.sarumah.posbersama.ui.menu.listmenu.productinventory.categories.adapter.CategoryMenuAdapter

class AddCategoriesActivity : AppCompatActivity() {

    private lateinit var viewModel : LibrarysViewModel
    private val adapterCategory = CategoryMenuAdapter()

    private lateinit var binding: ActivityAddnewcategoriesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(LibrarysViewModel::class.java)
        binding = ActivityAddnewcategoriesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setdataAdapter()
        setDataCategories()
    }

    private fun setdataAdapter(){
        binding.apply {
            rvCategories.adapter = adapterCategory
        }
    }

    private fun setDataCategories(){
        viewModel.listCategories.observe(this){
            adapterCategory.addItems(it)
        }
    }
}