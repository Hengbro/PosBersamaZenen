package com.sarumah.posbersama.ui.category

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.inyongtisto.myhelper.extension.extra
import com.inyongtisto.myhelper.extension.getString
import com.inyongtisto.myhelper.extension.isEmpty
import com.inyongtisto.myhelper.extension.pushActivity
import com.inyongtisto.myhelper.extension.showConfirmDialog
import com.inyongtisto.myhelper.extension.toVisible
import com.inyongtisto.myhelper.extension.toastError
import com.inyongtisto.myhelper.extension.toastSuccess
import com.sarumah.posbersama.core.source.local.entity.CategoryEntity
import com.sarumah.posbersama.core.source.remote.network.State
import com.sarumah.posbersama.core.source.remote.request.CategoryRequest
import com.sarumah.posbersama.core.source.remote.request.LoginRequest
import com.sarumah.posbersama.databinding.ActivityAddnewcategoriesBinding
import com.sarumah.posbersama.ui.home.HomeActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class CreateCategoriesActivity : AppCompatActivity() {

    private val category by extra<CategoryEntity>("extra")
    private val viewModel: CategoryViewModel by viewModel()
    private lateinit var binding: ActivityAddnewcategoriesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAddnewcategoriesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initUi()
        mainButton()
    }

    private fun initUi() {
        category?.let {
            binding.txtNamecategory.setText(it.name)
            binding.btnDelete.toVisible()
        }
    }

    private fun mainButton() {
        binding.apply {
            btnSave.setOnClickListener {
                if (validate()) {
                    if (category != null) {
                        update()
                    } else {
                        create()
                    }
                }
            }

            btnClose.setOnClickListener {
                onBackPressedDispatcher.onBackPressed()
            }

            btnDelete.setOnClickListener {
                showConfirmDialog(
                    title = "Hapus",
                    subtitle = "Apakah anda yakin ingin menghapus category ini?",
                    actionText = "Hapus"
                ) {
                    delete()
                }
            }
        }
    }

    private fun validate(): Boolean {
        binding.apply {
            if (txtNamecategory.isEmpty()) return false
        }
        return true
    }


    private fun create() {
        val request = CategoryRequest(
            name = binding.txtNamecategory.getString()
        )
        viewModel.create(request).observe(this) {
            when (it.state) {
                State.SUCCESS -> {
                    toastSuccess("Berhasil menambahkan category")
                    finish()
                }

                State.ERROR -> {
                    toastError(it.message)
                }

                State.LOADING -> {

                }
            }
        }
    }

    private fun update() {
        val request = CategoryRequest(
            id = category?.id,
            name = binding.txtNamecategory.getString()
        )
        viewModel.update(request).observe(this) {
            when (it.state) {
                State.SUCCESS -> {
                    toastSuccess("Berhasil merubah category")
                    finish()
                }

                State.ERROR -> {
                    toastError(it.message)
                }

                State.LOADING -> {

                }
            }
        }
    }

    private fun delete() {
        viewModel.delete(category ?: CategoryEntity()).observe(this) {
            when (it.state) {
                State.SUCCESS -> {
                    toastSuccess("Berhasil menghapus category")
                    finish()
                }

                State.ERROR -> {
                    toastError(it.message)
                }

                State.LOADING -> {

                }
            }
        }
    }
}

