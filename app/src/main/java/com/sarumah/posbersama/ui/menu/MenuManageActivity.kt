package com.sarumah.posbersama.ui.menu

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.inyongtisto.myhelper.extension.intentActivity
import com.sarumah.posbersama.EmptyActivity
import com.sarumah.posbersama.core.data.source.modal.Menu
import com.sarumah.posbersama.databinding.ActivityMainmenuBinding
import com.sarumah.posbersama.databinding.ActivityProductInventoryBinding
import com.sarumah.posbersama.ui.home.HomeActivity
import com.sarumah.posbersama.ui.home.fragment.librarys.adapter.ProductAdapter
import com.sarumah.posbersama.ui.menu.adapter.MenuAdapter
import com.sarumah.posbersama.ui.menu.listmenu.productinventory.ProdukInventoryActivity

class MenuManageActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainmenuBinding
    private lateinit var viewModel : MenusViewModel
    private val adapterMenu = MenuAdapter(
        onClick ={item, pos ->  
            getListMenu(item, pos)
        }
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MenusViewModel::class.java)
        binding = ActivityMainmenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainButton()
        setDataMenus()
        setupAdapter()
    }

    private fun mainButton(){
        binding.apply {
            btnImageclose.setOnClickListener {
                intentActivity(HomeActivity::class.java)
            }
        }
    }

    private fun getListMenu(item : Menu, pos : Int){
        when (item.id) {
            1 -> {
                intentActivity(EmptyActivity::class.java)
            }
            2 -> {
                intentActivity(EmptyActivity::class.java)
            }
            3 -> {
                intentActivity(EmptyActivity::class.java)
            }
            4 -> {
                intentActivity(EmptyActivity::class.java)
            }
            5 -> {
                intentActivity(EmptyActivity::class.java)
            }
            6 -> {
                intentActivity(ProdukInventoryActivity::class.java)
            }
            7 -> {
                intentActivity(EmptyActivity::class.java)
            }
            8 -> {
                intentActivity(EmptyActivity::class.java)
            }
            9 -> {
                intentActivity(EmptyActivity::class.java)
            }
        }
    }


    private fun setupAdapter(){
        binding.apply {
            rvMenus.adapter = adapterMenu
        }
    }

    private fun setDataMenus(){
        viewModel.listMenu.observe(this){
            adapterMenu.addItems(it)
        }
    }

}