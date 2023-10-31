package com.sarumah.posbersama.ui.menu.listmenu.productinventory.variantoptions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.inyongtisto.myhelper.extension.intentActivity
import com.sarumah.posbersama.databinding.FragmentEmptyBinding
import com.sarumah.posbersama.databinding.FragmentModifiersBinding
import com.sarumah.posbersama.databinding.FragmentVariantBinding
import com.sarumah.posbersama.ui.menu.listmenu.productinventory.ProductInventoryViewModel
import com.sarumah.posbersama.ui.menu.listmenu.productinventory.modifiersoptions.adapter.TopingOptionsAdapter
import com.sarumah.posbersama.ui.menu.listmenu.productinventory.variantoptions.adapter.VariantOptionsAdapter

class VariantOptionsFragment : Fragment() {

    private var _binding: FragmentVariantBinding? = null
    private lateinit var viewModel: ProductInventoryViewModel
    private val adapterVariant = VariantOptionsAdapter()
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel= ViewModelProvider(requireActivity()).get(ProductInventoryViewModel::class.java)
        _binding = FragmentVariantBinding.inflate(inflater, container, false)


        setupAdapter()
        setdataTopings()
        mainButton()
        return binding.root
    }

    private fun mainButton(){
        binding.apply {
            btnAddnewvariant.setOnClickListener {
                intentActivity(AddVariationActivity::class.java)
            }
        }
    }

    private fun setupAdapter(){
        binding.apply {
            rvCategories.adapter = adapterVariant
        }
    }

    private fun setdataTopings(){
        viewModel.listVariantOptions.observe(requireActivity()){
            adapterVariant.addItems(it)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}