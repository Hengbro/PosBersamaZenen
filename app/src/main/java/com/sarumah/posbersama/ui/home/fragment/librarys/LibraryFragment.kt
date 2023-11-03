package com.sarumah.posbersama.ui.home.fragment.librarys

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.sarumah.posbersama.databinding.FragmentLibraryBinding
import com.sarumah.posbersama.ui.home.fragment.librarys.adapter.CategoryAdapter
import com.sarumah.posbersama.ui.home.fragment.librarys.adapter.ProductAdapter

class LibraryFragment : Fragment() {

    private var _binding: FragmentLibraryBinding? = null
    private lateinit var viewModel: LibrarysViewModel


    private val  adapterCategory = CategoryAdapter()
    private val adapterProduct = ProductAdapter()
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(requireActivity()).get(LibrarysViewModel::class.java)

        _binding = FragmentLibraryBinding.inflate(inflater, container, false)

        setupAdapter()
        //setupDataCategories()
        setupDataProduct()

        return binding.root
    }

    private fun setupAdapter(){
        binding.apply {
            rvCategories.adapter = adapterCategory
            rvProduct.adapter = adapterProduct
        }
    }

    /*private fun setupDataCategories(){
        viewModel.listCategory.observe(requireActivity()) {
            adapterCategory.addItems(it)
        }
    }*/

    private fun setupDataProduct(){
        viewModel.listProducts.observe(requireActivity()){
            adapterProduct.addItems(it)
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}