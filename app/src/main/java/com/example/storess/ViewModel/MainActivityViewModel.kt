package com.example.storess.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.storess.Model.ProductsModel
import com.example.storess.Repository.MainRepo

class MainActivityViewModel: ViewModel() {

    private val mainRepo: MainRepo

    val getProductsList: LiveData<MutableList<ProductsModel>>
        get() = mainRepo.getProductsModelLiveData

    init {
        mainRepo = MainRepo()
    }
}