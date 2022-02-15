package com.example.myapplication.presentation.ui.pilot

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.domaine.models.Pilot

class PilotViewModel : ViewModel(){
    private val _pilot = MutableLiveData<Pilot>()

    val pilot : LiveData<Pilot> get() = _pilot

    init {
        _pilot.value = Pilot("Bee Zoon", 69)
    }
}