package com.zwt.charsboard.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zwt.charsboard.data.local.TopEntity
import com.zwt.charsboard.repository.DefaultTopRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class TopViewModel @Inject constructor(
    private val topRepository: DefaultTopRepository,
) : ViewModel() {

    //    private val _text = MutableLiveData<String>().apply {
//        value = "This is home Fragment"
//    }

    private var topItems: MutableLiveData<List<TopEntity>> = MutableLiveData()

    fun insertAll(title: String, intro: String,company:String) = viewModelScope.launch(){
        topRepository.insert(title, intro,company)
    }
    suspend fun getAll(): LiveData<List<TopEntity>> {
        topItems.postValue(topRepository.getAll())
        return topItems
    }

    private val _title1 = MutableLiveData<String>().apply {
        value = "Unlock!"
    }

    private val _title2 = MutableLiveData<String>().apply {
        value = "T.I.M.E stories"
    }
    private val _title3 = MutableLiveData<String>().apply {
        value = "Chronicles of Crime"
    }
    private val _title4 = MutableLiveData<String>().apply {
        value = "Escape game"
    }
    private val _title5 = MutableLiveData<String>().apply {
        value = "Escape Room the game"
    }
    private val _title7 = MutableLiveData<String>().apply {
        value = "Singularity"
    }
    private val _title6 = MutableLiveData<String>().apply {
        value = "ArkHam Horror"
    }

    private val _intro1 = MutableLiveData<String>().apply {
        value =
            "Calculation is the direction"
    }

    private val _intro2 = MutableLiveData<String>().apply {
        value =
            "Save dangers on different timelines"
    }
    private val _intro3 = MutableLiveData<String>().apply {
        value = "The world is Nonlinear"
    }
    private val _intro4 = MutableLiveData<String>().apply {
        value = "Rebuild the space with cards"
    }
    private val _intro5 = MutableLiveData<String>().apply {
        value = "You have 60 minutes to escape"
    }
    private val _intro7 = MutableLiveData<String>().apply {
        value = "Stop the crime before it started"
    }
    private val _intro6 = MutableLiveData<String>().apply {
        value = "Open world of Cthulhu"
    }

    private val _company1 = MutableLiveData<String>().apply {
        value =
            "JD éditions"
    }

    private val _company2 = MutableLiveData<String>().apply {
        value =
            "Space Cowboys"
    }
    private val _company3 = MutableLiveData<String>().apply {
        value = "Lucky Duck Games"
    }
    private val _company4 = MutableLiveData<String>().apply {
        value = "Heroes Game"
    }
    private val _company5 = MutableLiveData<String>().apply {
        value = "Broadway Toys"
    }
    private val _company7 = MutableLiveData<String>().apply {
        value = "K games"
    }
    private val _company6 = MutableLiveData<String>().apply {
        value = "Fantasy Flight Games"
    }

    val intro1: LiveData<String> = _intro1
    val intro2: LiveData<String> = _intro2
    val intro3: LiveData<String> = _intro3
    val intro4: LiveData<String> = _intro4
    val intro5: LiveData<String> = _intro5
    val intro6: LiveData<String> = _intro6
    val intro7: LiveData<String> = _intro7

    val title1: LiveData<String> = _title1
    val title2: LiveData<String> = _title2
    val title3: LiveData<String> = _title3
    val title4: LiveData<String> = _title4
    val title5: LiveData<String> = _title5
    val title6: LiveData<String> = _title6
    val title7: LiveData<String> = _title7


    val company1: LiveData<String> = _company1
    val company2: LiveData<String> = _company2
    val company3: LiveData<String> = _company3
    val company4: LiveData<String> = _company4
    val company5: LiveData<String> = _company5
    val company6: LiveData<String> = _company6
    val company7: LiveData<String> = _company7

}