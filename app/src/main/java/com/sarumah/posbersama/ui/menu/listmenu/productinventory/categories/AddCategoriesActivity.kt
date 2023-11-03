package com.sarumah.posbersama.ui.menu.listmenu.productinventory.categories

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.inyongtisto.myhelper.extension.isEmpty
import com.sarumah.posbersama.core.data.room.AppDatabase
import com.sarumah.posbersama.core.data.source.modal.CategoryJava
import com.sarumah.posbersama.databinding.ActivityAddnewcategoriesBinding
import com.sarumah.posbersama.ui.menu.listmenu.productinventory.categories.adapter.CategoryMenuAdapter
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class AddCategoriesActivity : AppCompatActivity() {


    private lateinit var binding: ActivityAddnewcategoriesBinding
    private var list = mutableListOf<CategoryJava>()
    private lateinit var adapterCategory: CategoryMenuAdapter
    private lateinit var database: AppDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAddnewcategoriesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        database = AppDatabase.getDatabase(this.applicationContext)
        adapterCategory = CategoryMenuAdapter(list)

        mainButton()
        setdataAdapter()

    }

    override fun onResume() {
        super.onResume()
        setDataCategories()
    }

    private fun mainButton(){
        binding.apply {
            btnSave.setOnClickListener {
                if(validate()){
                    addCategory()
                    finish()
                }
            }
            btnClose.setOnClickListener {
                onBackPressedDispatcher.onBackPressed()
            }
        }
    }

    private fun validate(): Boolean{
        binding.apply {
            if (txtNamecategory.isEmpty())return false
        }
        return true
    }


    private fun addCategory(){
        val myDb: AppDatabase = AppDatabase.getDatabase(this@AddCategoriesActivity)
        val data = CategoryJava()
        data.name = binding.txtNamecategory.text.toString()

        CompositeDisposable().add(Observable.fromCallable { myDb.categoryDao().insert(data) }
            .subscribeOn(Schedulers.computation())
            .subscribe {
                Log.d("respons", "data inserted")
            })
    }

    private fun setdataAdapter(){
        binding.apply {
            rvCategories.adapter = adapterCategory
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun setDataCategories(){
        list.clear()
        list.addAll(database.categoryDao().getAllCategories())
        adapterCategory.notifyDataSetChanged()
    }
}

