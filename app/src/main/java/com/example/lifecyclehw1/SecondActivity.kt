package com.example.lifecyclehw1

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.lifecyclehw1.databinding.ActivityMainBinding
import com.example.lifecyclehw1.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val intent = getIntent()
        var weight = intent.getDoubleExtra("weight", 1.0)
        var height = intent.getDoubleExtra("height", 1.0) / 100
        var result = weight / (height * height)
        when (result){
            in 1.0..16.0 -> {
                binding.massIndexET.text = "ИМТ ${result.toInt()} Выраженный дефицит массы тела"
                binding.mainImageIMG.setImageResource(R.drawable.first_imt)
                binding.mainInfo.text = MassInfo().massInfoFirst
            }
            in 16.0..18.5 -> {
                binding.massIndexET.text = "ИМТ ${result.toInt()} Недостаточная масса тела"
                binding.mainImageIMG.setImageResource(R.drawable.second_imt)
                binding.mainInfo.text = MassInfo().massInfoSecond
            }
            in 18.5..25.0 -> {
                binding.massIndexET.text = "ИМТ ${result.toInt()} Норма"
                binding.mainImageIMG.setImageResource(R.drawable.fired_imt)
                binding.mainInfo.text = MassInfo().massInfoThree
            }
            in 25.0..30.0 -> {
                binding.massIndexET.text = "ИМТ ${result.toInt()} Избыточная масса тела"
                binding.mainImageIMG.setImageResource(R.drawable.four_imt)
                binding.mainInfo.text = MassInfo().massInfoFour
            }
            in 30.0..35.0 -> {
                binding.massIndexET.text = "ИМТ ${result.toInt()} Ожирение 1 степени"
                binding.mainImageIMG.setImageResource(R.drawable.fived_imt)
                binding.mainInfo.text = MassInfo().massInfoFive
            }
            in 35.0..40.0 -> {
                binding.massIndexET.text = "ИМТ ${result.toInt()} Ожирение 2 степени"
                binding.mainImageIMG.setImageResource(R.drawable.six_imt)
                binding.mainInfo.text = MassInfo().massInfoSix
            }
            in 40.0..100.0 -> {
                binding.massIndexET.text = "ИМТ ${result.toInt()} Ожирение 3 степени"
                binding.mainImageIMG.setImageResource(R.drawable.seven_imt)
                binding.mainInfo.text = MassInfo().massInfoSeven
            }
            else -> binding.massIndexET.text = "Вы умираете"

        }




    }
//
//    private val launchSomeActivity = registerForActivityResult(
//        ActivityResultContracts.StartActivityForResult()
//    ) { result ->
//        if(result.resultCode == RESULT_OK){
//            val data = result.data
//            val height = data!!.getDoubleExtra("height",0.0) / 100
//            val weight = data!!.getDoubleExtra("weight",0.0)
////            var result = weight / (height * height)
////            binding.massIndexET.text = "Ваш индекс массы тела $result кг/м2"
////
////            Toast.makeText(this,"$weight $height", Toast.LENGTH_LONG).show()
////        } else {
////            Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show()
////        }
//    }


}