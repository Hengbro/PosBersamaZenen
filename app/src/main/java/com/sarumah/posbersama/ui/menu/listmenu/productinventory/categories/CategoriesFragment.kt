package com.sarumah.posbersama.ui.menu.listmenu.productinventory.categories

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.inyongtisto.myhelper.extension.intentActivity
import com.inyongtisto.myhelper.extension.toastWarning
import com.sarumah.posbersama.databinding.FragmentCategoriesBinding
import com.sarumah.posbersama.ui.menu.listmenu.productinventory.categories.adapter.CategoryAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class CategoriesFragment : Fragment() {

    private val viewModel: CategoryViewModel by viewModel()
    private val adapter = CategoryAdapter(
        onClick = {
            intentActivity(AddCategoriesActivity::class.java, it)
        }, onDelete = {
            toastWarning("onDelete:" + it.name)
        }
    )

    private var _binding: FragmentCategoriesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentCategoriesBinding.inflate(inflater, container, false)

        mainButton()
        setupAdapter()
        getCategory()
        observe()

        return binding.root
    }

    private fun mainButton() {
        binding.apply {
            btnAddnewcategories.setOnClickListener {
                intentActivity(AddCategoriesActivity::class.java)
            }
        }
    }

    private fun setupAdapter() {
        binding.rvCategories.adapter = adapter
    }

    private fun observe() {
        viewModel.getLocal().observe(requireActivity()) {
            adapter.submitList(it)
        }
    }

    private fun getCategory() {
        viewModel.get().observe(requireActivity()) {}
    }
}
