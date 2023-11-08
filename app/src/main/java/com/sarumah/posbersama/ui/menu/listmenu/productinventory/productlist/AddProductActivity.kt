package com.sarumah.posbersama.ui.menu.listmenu.productinventory.productlist

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.inyongtisto.myhelper.extension.isEmpty
import com.sarumah.posbersama.core.room.AppDatabaseOld
import com.sarumah.posbersama.core.source.model.CategoryJava
import com.sarumah.posbersama.databinding.ActivityAddnewproductBinding
import com.sarumah.posbersama.ui.menu.listmenu.productinventory.categories.adapter.CategoryMenuAdapter

class AddProductActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddnewproductBinding
    private var list = mutableListOf<CategoryJava>()
    private lateinit var adapterCategory: CategoryMenuAdapter
    private lateinit var database: AppDatabaseOld

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddnewproductBinding.inflate(layoutInflater)
        setContentView(binding.root)

        database = AppDatabaseOld.getDatabase(this.applicationContext)
        adapterCategory = CategoryMenuAdapter(list)

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
            if (txtName.isEmpty())return false
        }
        return true
    }


    private fun addCategory(){
        val myDb: AppDatabaseOld = AppDatabaseOld.getDatabase(this)
        val data = CategoryJava()
        data.name = binding.tvName.text.toString()

//        CompositeDisposable().add(Observable.fromCallable { myDb.categoryDao().insert(data) }
//            .subscribeOn(Schedulers.computation())
//            .subscribe {
//                Log.d("respons", "data inserted")
//            })
    }

}