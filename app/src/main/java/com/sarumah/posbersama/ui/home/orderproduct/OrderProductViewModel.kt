package com.sarumah.posbersama.ui.home.orderproduct

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sarumah.posbersama.core.source.local.Dummy
import com.sarumah.posbersama.core.source.model.Texass
import com.sarumah.posbersama.core.source.model.Topings
import com.sarumah.posbersama.core.source.model.Variations

class OrderProductViewModel: ViewModel() {

    val listVariations : LiveData<List<Variations>> = MutableLiveData<List<Variations>>().apply {
        value = Dummy.listVariations
    }

    val listTopings : LiveData<List<Topings>> = MutableLiveData<List<Topings>>().apply {
        value = Dummy.listTopings
    }

    val listTexass : LiveData<List<Texass>> = MutableLiveData<List<Texass>>().apply {
        value = Dummy.listTaxes
    }
}
