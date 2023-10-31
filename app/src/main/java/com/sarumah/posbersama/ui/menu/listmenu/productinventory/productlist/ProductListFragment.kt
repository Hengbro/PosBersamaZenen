package com.sarumah.posbersama.ui.menu.listmenu.productinventory.productlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.inyongtisto.myhelper.extension.intentActivity
import com.sarumah.posbersama.databinding.FragmentEmptyBinding
import com.sarumah.posbersama.databinding.FragmentProductBinding
import com.sarumah.posbersama.ui.menu.listmenu.productinventory.ProductInventoryViewModel
import com.sarumah.posbersama.ui.menu.listmenu.productinventory.productlist.adapter.ProductListAdapter

class ProductListFragment : Fragment() {

    private var _binding: FragmentProductBinding? = null
    private lateinit var viewModel: ProductInventoryViewModel
    private val adapterProductOptions = ProductListAdapter()
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(requireActivity()).get(ProductInventoryViewModel::class.java)
        _binding = FragmentProductBinding.inflate(inflater, container, false)

        setupAdapter()
        setdataTopings()
        mainButton()
        return binding.root
    }

    private fun mainButton(){
        binding.apply {
            btnAddproduct.setOnClickListener {
                intentActivity(AddProductActivity::class.java)
            }
        }
    }

    private fun setupAdapter(){
        binding.apply {
            rvListproduct.adapter = adapterProductOptions
        }
    }

    private fun setdataTopings(){
        viewModel.listProducts.observe(requireActivity()){
            adapterProductOptions.addItems(it)
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}