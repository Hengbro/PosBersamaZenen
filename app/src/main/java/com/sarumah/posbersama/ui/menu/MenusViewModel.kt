package com.sarumah.posbersama.ui.menu

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sarumah.posbersama.core.data.source.local.Dummy
import com.sarumah.posbersama.core.data.source.modal.Categories
import com.sarumah.posbersama.core.data.source.modal.Menu
import com.sarumah.posbersama.core.data.source.modal.Products

class MenusViewModel: ViewModel() {

    val listMenu : LiveData<List<Menu>> = MutableLiveData<List<Menu>>().apply {
        value = Dummy.listMenu
    }
}
