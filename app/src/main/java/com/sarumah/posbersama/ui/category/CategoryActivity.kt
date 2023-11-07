package com.sarumah.posbersama.ui.category

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.inyongtisto.myhelper.extension.intentActivity
import com.inyongtisto.myhelper.extension.toastError
import com.inyongtisto.myhelper.extension.toastInfo
import com.inyongtisto.myhelper.extension.toastSimple
import com.inyongtisto.myhelper.extension.toastSuccess
import com.inyongtisto.myhelper.extension.toastWarning
import com.sarumah.posbersama.core.source.remote.network.State
import com.sarumah.posbersama.databinding.ActivityCategoryBinding
import com.sarumah.posbersama.databinding.ActivityEmptyBinding
import com.sarumah.posbersama.ui.category.adapter.CategoryAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class CategoryActivity : AppCompatActivity() {

    private val viewModel: CategoryViewModel by viewModel()
    private val adapter = CategoryAdapter(
        onClick = {
            intentActivity(CreateCategoriesActivity::class.java, it)
        }, onDelete = {
            toastWarning("onDelete:" + it.name)
        }
    )
    private lateinit var binding: ActivityCategoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainButton()
        setupAdapter()
        getCategory()
        observe()
    }

    private fun mainButton() {
        binding.apply {
            btnAdd.setOnClickListener {
                intentActivity(CreateCategoriesActivity::class.java)
            }
        }
    }

    private fun setupAdapter() {
        binding.rvData.adapter = adapter
    }

    private fun observe() {
        viewModel.getLocal().observe(this) {
            adapter.submitList(it)
        }
    }

    private fun getCategory() {
        viewModel.get().observe(this) {}
    }
}