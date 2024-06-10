package com.example.costam

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.costam.databinding.ActivityMainBinding
import kotlin.math.pow


class MainActivity : AppCompatActivity(), View.OnClickListener
{
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.b1.setOnClickListener(this)

        binding.b2.setOnClickListener{
            var historia_string = ""
            for (wpis in historia)
            {
                historia_string += wpis + "\n"
            }
            Toast.makeText(applicationContext, historia_string, Toast.LENGTH_SHORT).show()
        }
        binding.b3.setOnClickListener{
            var intent = Intent(getBaseContext(), MainActivity2::class.java)
            intent.putExtra("dane", historia.toTypedArray())
            startActivity(intent)
        }

    }
    var masa: Float = 0.0f
    var wielkosc: Float = 0.0f
    var bmi: Float= 0.0f
    var plec: String= ""
    var historia = mutableListOf<String>()


    override fun onClick(v: View?)
    {
        if(binding.waga.text.isEmpty() || binding.wzrost.text.isEmpty() || (!binding.radioButtonMezczyzna.isChecked()) && (!binding.radioButtonKobieta.isChecked()))
        {
            Toast.makeText(applicationContext, "Wprowadź wszystkie dane", Toast.LENGTH_SHORT).show()
        }
        else
        {
            masa = binding.waga.text.toString().toFloat()
            wielkosc = binding.wzrost.text.toString().toFloat()/100
            var a: Float = 0.0f
            if(binding.radioButtonMezczyzna.isChecked())
            {
                a=1.1f
                plec = "meżczyzna"
            }
            else
            {
                a=0.85f
                plec = "kobieta"
            }
            bmi = (masa/wielkosc.pow(2))*a
            Toast.makeText(applicationContext, "BMI:"+bmi.toString(), Toast.LENGTH_LONG).show()
            historia.add("BMI: "+bmi.toString() + " Waga: " + masa.toString() + " Wzrost: " + wielkosc.toString() + " Płeć: " + plec)
        }
    }


}