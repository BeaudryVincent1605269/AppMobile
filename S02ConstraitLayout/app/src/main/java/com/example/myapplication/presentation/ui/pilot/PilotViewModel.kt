package com.example.myapplication.presentation.ui.pilot

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.core.notify
import com.example.myapplication.domaine.models.Pilot

class PilotViewModel : ViewModel(){
    private val _pilot = MutableLiveData<Pilot>()

    val pilot : LiveData<Pilot> get() = _pilot

    init {
        _pilot.value = Pilot("Bee Zoon", 69)
    }

    fun fly(revolution:Int, isTraining:Boolean) :Boolean {

        val pilotValue = _pilot.value!!

        return if(pilotValue.canFly()) {

            pilotValue!!.fly(revolution, isTraining)
            //_pilot.value = pilotValue
            //_pilot.postValue(_pilot.value)
            _pilot.notify()
            true
        } else {
            false
        }

    }

    fun recharge() {
        _pilot.value!!.recharge()
        //_pilot.postValue(_pilot.value)

        //_pilot.value = _pilot.value
        _pilot.notify()

    }

}