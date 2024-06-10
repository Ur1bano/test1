package com.example.costam

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.costam.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        var extras: Bundle? = getIntent().getExtras()
        if(extras != null)
        {
            var historia = extras.getStringArray("dane")
            var historia_string = ""
            if(historia != null)
            {
                for(wpis in historia)
                {
                    historia_string += wpis + "\n"
                }
            }
            binding.historiatext.setText(historia_string)
        }
        binding.b4.setOnClickListener{
            finish()
        }


    }
}