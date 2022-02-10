package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityPilotBinding
import com.example.myapplication.domaine.models.Pilot

class PilotActivity : AppCompatActivity() {

    //Permet d'accéder aux composants graphiques (Button, Textview etc) de l'interface
    private lateinit var binding : ActivityPilotBinding

    private val _pilot = Pilot("Bee Zoon", 10)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Transformer et charge le xml en mémoire dans le binding
        binding = ActivityPilotBinding.inflate(layoutInflater)
        //Créer l'interface à partir du binding
        setContentView(binding.root)

        refreshUI()

        binding.btnStart.setOnClickListener{
            if(_pilot.canFly()) {
                _pilot.fly(binding.sldRevolution.value.toInt(), binding.swtTraining.isChecked)

                refreshUI()



            } else {
                //TODO: Snackbar
            }
        }


    }

    private fun refreshUI() {
        binding.txvPilotName.text = _pilot.name
        binding.txvLevel.text = _pilot.level.toString()
        binding.txvLife.text = _pilot.life.toString()
        binding.txvShield.text = _pilot.shield.toString()
        binding.txvEnergy.text = _pilot.energy.toString()
        binding.txvCube.text = _pilot.cube.toString()
    }
}