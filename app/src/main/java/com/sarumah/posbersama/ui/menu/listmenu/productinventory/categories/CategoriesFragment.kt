package com.sarumah.posbersama.ui.menu.listmenu.productinventory.categories

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.inyongtisto.myhelper.extension.intentActivity
import com.sarumah.posbersama.databinding.FragmentCategoriesBinding
import com.sarumah.posbersama.databinding.FragmentEmptyBinding
import com.sarumah.posbersama.ui.home.fragment.librarys.LibrarysViewModel
import com.sarumah.posbersama.ui.home.fragment.librarys.adapter.CategoryAdapter
import com.sarumah.posbersama.ui.menu.listmenu.productinventory.categories.adapter.CategoryMenuAdapter
import org.koin.android.ext.android.get

class CategoriesFragment : Fragment() {

    private var _binding: FragmentCategoriesBinding? = null
    private lateinit var viewModel : LibrarysViewModel
    private val adapterCategory = CategoryMenuAdapter()
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(requireActivity()).get(LibrarysViewModel::class.java)
        _binding = FragmentCategoriesBinding.inflate(inflater, container, false)

        setDataCategories()
        setdataAdapter()
        mainButton()

        return binding.root
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

    private fun setDataCategories(){
        viewModel.listCategories.observe(requireActivity()){
            adapterCategory.addItems(it)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}