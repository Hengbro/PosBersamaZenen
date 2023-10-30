package com.sarumah.posbersama.ui.menu.listmenu.productinventory

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sarumah.posbersama.core.data.source.local.Dummy
import com.sarumah.posbersama.core.data.source.modal.Categories
import com.sarumah.posbersama.core.data.source.modal.Products
import com.sarumah.posbersama.core.data.source.modal.Topings
import com.sarumah.posbersama.core.data.source.modal.VariantOptions

class ProductInventoryViewModel: ViewModel() {

    val listProducts : LiveData<List<Products>> = MutableLiveData<List<Products>>().apply {
        value = Dummy.listProduct
    }

    val listVariantOptions : LiveData<List<VariantOptions>> = MutableLiveData<List<VariantOptions>>().apply {
        value = Dummy.listVariantOptions
    }

    val listTopingOptions : LiveData<List<Topings>> = MutableLiveData<List<Topings>>().apply {
        value = Dummy.listTopingOptionns
    }
}
