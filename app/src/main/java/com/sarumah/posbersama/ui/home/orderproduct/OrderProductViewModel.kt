package com.sarumah.posbersama.ui.home.orderproduct

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sarumah.posbersama.core.data.source.local.Dummy
import com.sarumah.posbersama.core.data.source.modal.Texass
import com.sarumah.posbersama.core.data.source.modal.Topings
import com.sarumah.posbersama.core.data.source.modal.Variations

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
