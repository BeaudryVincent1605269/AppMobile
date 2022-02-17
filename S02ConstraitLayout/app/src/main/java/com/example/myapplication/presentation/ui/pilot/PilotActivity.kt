package com.example.myapplication.presentation.ui.pilot

import android.animation.ValueAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.LinearInterpolator
import androidx.activity.viewModels
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.animation.doOnEnd
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityPilotBinding
import com.example.myapplication.domaine.models.Pilot
import com.google.android.material.snackbar.Snackbar

import kotlin.random.Random


class PilotActivity : AppCompatActivity() {

    //Permet d'accéder aux composants graphiques (Button, Textview etc) de l'interface
    private lateinit var binding : ActivityPilotBinding

    private val viewModel: PilotViewModel by viewModels()


    //private val _pilot = Pilot("Bee Zoon", 10)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Transformer et charge le xml en mémoire dans le binding
        binding = ActivityPilotBinding.inflate(layoutInflater)
        //Créer l'interface à partir du binding
        setContentView(binding.root)


        viewModel.pilot.observe(this){
            binding.txvPilotName.text = it.name
            binding.txvLevel.text = getString(R.string.level, it.level)
            binding.txvLife.text = it.life.toString()
            binding.txvShield.text = it.shield.toString()
            binding.txvEnergy.text = it.energy.toString()
            binding.txvCube.text = it.cube.toString()
        }
       // refreshUI()

        binding.btnStart.setOnClickListener{
            if(viewModel.fly(binding.sldRevolution.value.toInt(), binding.swtTraining.isChecked)){
                Snackbar.make(binding.root, getString(R.string.low_ressources), Snackbar.LENGTH_INDEFINITE)
                    .setAction(getString(R.string.msgContinue)) {
                        viewModel.recharge()
                   }
                   .show()
            }
        }
    }
}
//            if(_pilot.canFly()) {
//                binding.btnStart.isEnabled = false
//                _pilot.fly(binding.sldRevolution.value.toInt(), binding.swtTraining.isChecked)
//
//                val layoutParams = binding.imvRocket.layoutParams as ConstraintLayout.LayoutParams
//                val startAngle = layoutParams.circleAngle
//                val endAngle = startAngle - 360
//                val animation = ValueAnimator.ofFloat(startAngle, endAngle)
//
//                animation.repeatCount = binding.sldRevolution.value.toInt() - 1
//                animation.duration = Random.nextLong(1500, 5000)
//                animation.interpolator = LinearInterpolator()
//
//                animation.addUpdateListener {
//                    val animatedValue = it.animatedValue as Float
//                    val layoutParamsAnimation = binding.imvRocket.layoutParams as ConstraintLayout.LayoutParams
//                    layoutParamsAnimation.circleAngle = animatedValue
//                    binding.imvRocket.layoutParams = layoutParamsAnimation
//                    binding.imvRocket.rotation = (animatedValue - 90) //*3
//                }
//
//                animation.doOnEnd {
//                    binding.btnStart.isEnabled = true
//                    refreshUI()
//                }
//
//                animation.start()
//
//
//
//
//
//            } else {
//                Snackbar.make(binding.root, getString(R.string.low_ressources), Snackbar.LENGTH_INDEFINITE)
//                    .setAction(getString(R.string.msgContinue)) {
//                        _pilot.recharge()
//                        refreshUI()
//                    }
//                    .show()
//            }


//    private fun refreshUI() {
//        binding.txvPilotName.text = _pilot.name
//        binding.txvLevel.text = getString(R.string.level, _pilot.level)
//        binding.txvLife.text = _pilot.life.toString()
//        binding.txvShield.text = _pilot.shield.toString()
//        binding.txvEnergy.text = _pilot.energy.toString()
//        binding.txvCube.text = _pilot.cube.toString()
//    }
