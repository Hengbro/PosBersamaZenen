package com.sarumah.posbersama.ui.home.fragment.bills

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.inyongtisto.myhelper.extension.toGone
import com.inyongtisto.myhelper.extension.toVisible
import com.sarumah.posbersama.R
import com.sarumah.posbersama.databinding.FragmentBillsBinding
import com.sarumah.posbersama.databinding.FragmentFavoritesBinding
import com.sarumah.posbersama.databinding.FragmentTablesBinding
import com.sarumah.posbersama.ui.home.fragment.FavoriteFragment
import com.sarumah.posbersama.ui.home.fragment.bills.fragmentbills.CloseBillsFragment
import com.sarumah.posbersama.ui.home.fragment.bills.fragmentbills.OpenBillsFragment
import com.sarumah.posbersama.ui.home.fragment.librarys.LibraryFragment

class BillsFragment : Fragment() {

    private var _binding: FragmentBillsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBillsBinding.inflate(inflater, container, false)


        callFargment(OpenBillsFragment())
        mainButton()

        return binding.root
    }

    private fun mainButton() {
        binding.apply {
            btnOpenbills.setOnClickListener {
                setActive(btnOpenbills)
                callFargment(OpenBillsFragment())
            }
            btnClosebills.setOnClickListener {
                setActive(btnClosebills)
                callFargment(CloseBillsFragment())
            }
        }
    }
    private fun callFargment(fragment: Fragment) {
        childFragmentManager
            .beginTransaction()
            .replace(
                R.id.mainFrame,
                fragment,
                fragment.tag
            ).commit()
    }

    @SuppressLint("ResourceAsColor")
    private fun setActive(view: TextView) {
        binding.apply {
            val listViews = listOf<TextView>(btnOpenbills, btnClosebills)
            listViews.forEach {
                if (it == view) {
                    it.setBackgroundColor(R.color.white)
                    it.setTextColor(R.color.colorPrimary)
                } else {
                    it.setBackgroundColor(R.color.gray5)
                    it.setTextColor(R.color.gray5)
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}