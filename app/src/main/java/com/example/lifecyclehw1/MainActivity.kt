package com.example.lifecyclehw1

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.lifecyclehw1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.mainButtonBTN.setOnClickListener{
            if ( binding.heightET.text.isNotEmpty() && binding.massET.text.isNotEmpty()){
                val intent = Intent(this,SecondActivity::class.java)

                var height = binding.heightET.text.toString().toDouble()
                var weight = binding.massET.text.toString().toDouble()
                intent.putExtra("height", height)
                intent.putExtra("weight", weight)
                startActivity(intent)
            } else {
                Toast.makeText(
                    this,
                    "Заполните поля",
                    Toast.LENGTH_LONG
                ).show()
            }
        }

    }
}