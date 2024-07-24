package com.zwt.charsboard.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class WalkthroughViewModel : ViewModel() {


    private val _title1 = MutableLiveData<String>().apply {
        value = "Unlock!"
    }
    private val _title2 = MutableLiveData<String>().apply {
        value = "T.I.M.E stories"
    }
    private val _title3 = MutableLiveData<String>().apply {
        value = "Lost in space"
    }
    private val _title4 = MutableLiveData<String>().apply {
        value = "Nightmare Laboratory"
    }
    private val _title5 = MutableLiveData<String>().apply {
        value = "Escape Room the game"
    }
    private val _title6 = MutableLiveData<String>().apply {
        value = "Undo"
    }
    private val _title7 = MutableLiveData<String>().apply {
        value = "Black stories"
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
        value = "Rebuild the space with cards"
    }
    private val _intro4 = MutableLiveData<String>().apply {
        value = "Secret Scp files"
    }
    private val _intro5 = MutableLiveData<String>().apply {
        value = "You have 60 minutes to escape"
    }
    private val _intro6 = MutableLiveData<String>().apply {
        value = "Reset your destiny"
    }
    private val _intro7 = MutableLiveData<String>().apply {
        value = "Answer yes or no"
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
}