package com.sarumah.posbersama.home

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.sarumah.posbersama.R
import com.sarumah.posbersama.databinding.ActivityHomedashboardBinding
import com.sarumah.posbersama.home.fragment.LibraryFragment
import com.sarumah.posbersama.home.fragment.TablesFragment


class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomedashboardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomedashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainButton()
        callFargment(LibraryFragment())
    }

    private fun mainButton() {
        binding.apply {
            btnLibrary.setOnClickListener {
                setActive(btnLibrary)
                callFargment(LibraryFragment())
            }
            btnFavorites.setOnClickListener {
                setActive(btnFavorites)
                callFargment(LibraryFragment())
            }

            btnKeypad.setOnClickListener {
                setActive(btnKeypad)
                callFargment(LibraryFragment())
            }

            btnTables.setOnClickListener {
                setActive(btnTables)
                callFargment(TablesFragment())
            }

            btnBills.setOnClickListener {
                setActive(btnBills)
                callFargment(LibraryFragment())
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
                    it.setTextColor(getColor(R.color.dark))
                }
            }
        }
    }
}