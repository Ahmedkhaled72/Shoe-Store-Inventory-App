package com.udacity.shoestore.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import timber.log.Timber

class ShoeViewModel: ViewModel()
{
    //listto show
    private lateinit var  listOfShoe: MutableList<Shoe>
    //internal value
    private val _shoeList = MutableLiveData<MutableList<Shoe>>()
    //external value that updated in UI livedata
    var shoeList: LiveData<MutableList<Shoe>> = _shoeList


    init {

        Timber.i("ShoeViewModel Are Created")
        listOfShoe = mutableListOf(Shoe(name = "scet", size = 8.0, company = "adidas", description = "isgood"))
        _shoeList.value = listOfShoe.toMutableList()
        //shoeList.value = showlistv.toMutableList()
        //show.name = "Ahmed"
        //show.description = "Khaled"
       //show.company = "Deony"
       //show.size = 4.6
    }

     //todo()



    override fun onCleared() {
        super.onCleared()
        Timber.i("ShoeViewModel Are Destroyed")
    }

    fun addShoeToList(shoe: Shoe)
    {
        //added shoe listto main list and pass it to livedata
         listOfShoe.add(shoe)
        _shoeList.value = listOfShoe.toMutableList()
        //another that deffernt betwen add and plus
        // _shoeList.value = listOfShoe.plus(shoe).toMutableList()
        //can use it in observal now in show
    }
}