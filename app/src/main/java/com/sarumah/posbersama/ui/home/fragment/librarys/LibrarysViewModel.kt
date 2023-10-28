package com.sarumah.posbersama.ui.home.fragment.librarys

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sarumah.posbersama.core.data.source.local.Dummy
import com.sarumah.posbersama.core.data.source.modal.Categories
import com.sarumah.posbersama.core.data.source.modal.Products

class LibrarysViewModel: ViewModel() {

    val listCategories : LiveData<List<Categories>> = MutableLiveData<List<Categories>>().apply {
        value = Dummy.listCategories
    }

    val listProducts : LiveData<List<Products>> = MutableLiveData<List<Products>>().apply {
        value = Dummy.listProduct
    }
}
