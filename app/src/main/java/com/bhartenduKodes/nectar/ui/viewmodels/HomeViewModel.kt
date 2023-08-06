package com.bhartenduKodes.nectar.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bhartenduKodes.nectar.data.dummydata.DummyData
import com.bhartenduKodes.nectar.data.model.Product
import com.bhartenduKodes.nectar.data.model.ProductCategory
import com.bhartenduKodes.nectar.data.model.SettingData
import com.bhartenduKodes.nectar.database.repo.RepositoryDb
import kotlinx.coroutines.launch

class HomeViewModel() : ViewModel() {

    val exclusiveOffer = MutableLiveData<List<Product>>()
    val bestSelling = MutableLiveData<List<Product>>()
    val groceries = MutableLiveData<List<ProductCategory>>()
    val products = MutableLiveData<List<ProductCategory>>()
    val settingMenu = MutableLiveData<List<SettingData>>()
    val freshFruits = MutableLiveData<List<Product>>()
    val beverages = MutableLiveData<List<Product>>()
    val meatFish = MutableLiveData<List<Product>>()
    val detailsFood = MutableLiveData<List<Product>>()



    fun exclusiveOffer() {
        try {
            viewModelScope.launch {
                val exclusiveData = DummyData.exclusiveOffer
                exclusiveOffer.postValue(exclusiveData)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun settingData() {
        try {
            viewModelScope.launch {
                val setting = DummyData.settingList
                settingMenu.postValue(setting)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun bestSelling() {
        try {
            viewModelScope.launch {
                val bestSold = DummyData.bestSelling
                bestSelling.postValue(bestSold)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun groceries() {
        try {
            viewModelScope.launch {
                val grocerie = DummyData.groceries
                groceries.postValue(grocerie)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun findProduct() {
        try {
            viewModelScope.launch {
                val allListedProduct = DummyData.findProducts
                products.postValue(allListedProduct)
            }
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        }
    }

    fun freshFruits() {
        try {
            viewModelScope.launch {
                val fruitsOrVegetable = DummyData.fruitsAndVegitables
                freshFruits.postValue(fruitsOrVegetable)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun beverage() {
        try {
            viewModelScope.launch {
                val listBeverages = DummyData.beverage
                beverages.postValue(listBeverages)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun meatAndFish() {
        try {
            viewModelScope.launch {
                val meats = DummyData.meatAndFish
                meatFish.postValue(meats)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

}