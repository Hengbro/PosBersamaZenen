package com.sarumah.posbersama.ui.menu.listmenu.productinventory

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sarumah.posbersama.core.source.local.Dummy
import com.sarumah.posbersama.core.source.model.Products
import com.sarumah.posbersama.core.source.model.Topings
import com.sarumah.posbersama.core.source.model.VariantOptions

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
