package com.sarumah.posbersama.ui.menu.listmenu.productinventory.productlist

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.inyongtisto.myhelper.extension.intentActivity
import com.sarumah.posbersama.core.data.room.AppDatabase
import com.sarumah.posbersama.core.data.source.modal.CategoryJava
import com.sarumah.posbersama.core.data.source.modal.ProductJava
import com.sarumah.posbersama.databinding.FragmentProductBinding
import com.sarumah.posbersama.ui.menu.listmenu.productinventory.ProductInventoryViewModel
import com.sarumah.posbersama.ui.menu.listmenu.productinventory.categories.adapter.CategoryMenuAdapter
import com.sarumah.posbersama.ui.menu.listmenu.productinventory.productlist.adapter.ProductAdapter

class ProductListFragment : Fragment() {

    private var _binding: FragmentProductBinding? = null
    private var list = mutableListOf<ProductJava>()
    private lateinit var adapterProduct: ProductAdapter
    private lateinit var database: AppDatabase
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentProductBinding.inflate(inflater, container, false)

        database = AppDatabase.getDatabase(requireContext().applicationContext)
        adapterProduct = ProductAdapter(list)

        setupAdapter()
        mainButton()
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        setDataProduct()
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
            rvListproduct.adapter = adapterProduct
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun setDataProduct(){
        list.clear()
        list.addAll(database.productDao().getAllProduct())
        adapterProduct.notifyDataSetChanged()
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}