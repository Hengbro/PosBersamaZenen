package com.sarumah.posbersama.ui.home

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.inyongtisto.myhelper.extension.intentActivity
import com.inyongtisto.myhelper.extension.popUpMenu
import com.inyongtisto.myhelper.extension.pushActivity
import com.inyongtisto.myhelper.extension.toGone
import com.inyongtisto.myhelper.extension.toVisible
import com.sarumah.posbersama.EmptyActivity
import com.sarumah.posbersama.R
import com.sarumah.posbersama.databinding.ActivityHomedashboardBinding
import com.sarumah.posbersama.ui.auth.LoginActivity
import com.sarumah.posbersama.ui.home.fragment.bills.BillsFragment
import com.sarumah.posbersama.ui.home.fragment.FavoriteFragment
import com.sarumah.posbersama.ui.home.fragment.KeypadFragment
import com.sarumah.posbersama.ui.home.fragment.librarys.LibraryFragment
import com.sarumah.posbersama.ui.home.fragment.TablesFragment
import com.sarumah.posbersama.ui.menu.CustomizeNavbarActivity
import com.sarumah.posbersama.ui.menu.MenuManageActivity


class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomedashboardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomedashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainButton()
        callFargment(LibraryFragment())

        pushActivity(LoginActivity::class.java)
    }

    private fun mainButton() {
        binding.apply {
            btnLibrary.setOnClickListener {
                setActive(btnLibrary)
                binding.lyNoproduct.toVisible()
                binding.rlDragdrop.toGone()
                callFargment(LibraryFragment())
            }
            btnFavorites.setOnClickListener {
                setActive(btnFavorites)
                binding.lyNoproduct.toGone()
                binding.rlDragdrop.toVisible()
                callFargment(FavoriteFragment())
            }

            btnKeypad.setOnClickListener {
                setActive(btnKeypad)
                binding.lyNoproduct.toVisible()
                binding.rlDragdrop.toGone()
                callFargment(KeypadFragment())
            }

            btnTables.setOnClickListener {
                setActive(btnTables)
                binding.lyNoproduct.toVisible()
                binding.rlDragdrop.toGone()
                callFargment(TablesFragment())
            }

            btnBills.setOnClickListener {
                setActive(btnBills)
                binding.lyNoproduct.toVisible()
                binding.rlDragdrop.toGone()
                callFargment(BillsFragment())
            }

            btnImagemenu.setOnClickListener {
                intentActivity(MenuManageActivity::class.java)
            }
            val context = root.context

            btnImagelistmenu.setOnClickListener {
                val listMenu = listOf("Add new product", "Customize navbar")
                context.popUpMenu(btnImagelistmenu, listMenu) {
                    when (it) {
                        "Add new product" -> intentActivity(EmptyActivity::class.java)
                        "Customize navbar" -> intentActivity(CustomizeNavbarActivity::class.java)
                    }
                }
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
            val listViews = listOf<TextView>(btnLibrary, btnFavorites, btnKeypad, btnTables, btnBills)
            listViews.forEach {
                if (it == view) {
                    it.setTextColor(getColor(R.color.colorPrimary))
                } else {
                    it.setTextColor(getColor(R.color.gray3))
                }
            }
        }
    }

    private fun setupAdapter(){
        binding.apply {

        }
    }
}