package com.sarumah.posbersama.ui.menu.listmenu.productinventory.modifiersoptions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.inyongtisto.myhelper.extension.intentActivity
import com.sarumah.posbersama.databinding.FragmentEmptyBinding
import com.sarumah.posbersama.databinding.FragmentModifiersBinding
import com.sarumah.posbersama.ui.menu.listmenu.productinventory.ProductInventoryViewModel
import com.sarumah.posbersama.ui.menu.listmenu.productinventory.modifiersoptions.adapter.TopingOptionsAdapter

class ModifiersOptionsFragment : Fragment() {

    private var _binding: FragmentModifiersBinding? = null
    private lateinit var viewModel: ProductInventoryViewModel
    private val adapterTopings = TopingOptionsAdapter()
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel= ViewModelProvider(requireActivity()).get(ProductInventoryViewModel::class.java)
        _binding = FragmentModifiersBinding.inflate(inflater, container, false)


        setupAdapter()
        setdataTopings()
        mainButton()
        return binding.root
    }

    private fun mainButton(){
        binding.apply {
            btnModifiers.setOnClickListener {
                intentActivity(AddModifiersActivity::class.java)
            }
        }
    }

    private fun setupAdapter(){
        binding.apply {
            rvCategories.adapter = adapterTopings
        }
    }

    private fun setdataTopings(){
        viewModel.listTopingOptions.observe(requireActivity()){
            adapterTopings.addItems(it)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}