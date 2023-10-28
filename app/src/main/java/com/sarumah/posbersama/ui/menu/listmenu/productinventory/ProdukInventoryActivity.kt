package com.sarumah.posbersama.ui.menu.listmenu.productinventory

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.inyongtisto.myhelper.extension.intentActivity
import com.inyongtisto.myhelper.extension.popUpMenu
import com.inyongtisto.myhelper.extension.toGone
import com.inyongtisto.myhelper.extension.toVisible
import com.sarumah.posbersama.EmptyActivity
import com.sarumah.posbersama.EmptyFragment
import com.sarumah.posbersama.R
import com.sarumah.posbersama.databinding.ActivityHomedashboardBinding
import com.sarumah.posbersama.databinding.ActivityProductInventoryBinding
import com.sarumah.posbersama.ui.home.fragment.bills.BillsFragment
import com.sarumah.posbersama.ui.home.fragment.FavoriteFragment
import com.sarumah.posbersama.ui.home.fragment.KeypadFragment
import com.sarumah.posbersama.ui.home.fragment.librarys.LibraryFragment
import com.sarumah.posbersama.ui.home.fragment.TablesFragment
import com.sarumah.posbersama.ui.menu.CustomizeNavbarActivity
import com.sarumah.posbersama.ui.menu.MenuManageActivity
import com.sarumah.posbersama.ui.menu.listmenu.productinventory.categories.CategoriesFragment


class ProdukInventoryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProductInventoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductInventoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainButton()
        callFargment(EmptyFragment())
    }

    private fun mainButton() {
        binding.apply {
            btnProduct.setOnClickListener {
                setActive(btnProduct)
                callFargment(EmptyFragment())
            }
            btnVariant.setOnClickListener {
                setActive(btnVariant)
                callFargment(EmptyFragment())
            }

            btnModifiers.setOnClickListener {
                setActive(btnModifiers)
                callFargment(EmptyFragment())
            }

            btnCategory.setOnClickListener {
                setActive(btnCategory)
                callFargment(CategoriesFragment())
            }
        }
    }

    private fun callFargment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(
                R.id.mainFrame,
                fragment,
                fragment.tag
            ).commit()
    }

    private fun setActive(view: TextView) {
        binding.apply {
            val listViews = listOf<TextView>(btnProduct, btnVariant, btnModifiers, btnCategory)
            listViews.forEach {
                if (it == view) {
                    it.setBackgroundColor(getColor(R.color.colorPrimary))
                    it.setTextColor(getColor(R.color.white))
                } else {
                    it.setBackgroundColor(getColor(R.color.white))
                    it.setTextColor(getColor(R.color.gray3))
                }
            }
        }
    }
}