package com.example.kalkulatornapiwkw

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.view.View
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.SeekBar
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var kwota: EditText
    lateinit var procent: EditText
    lateinit var textResult: TextView
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val seekBar = findViewById<SeekBar>(R.id.seekBar)
        val textViewProgress = findViewById<TextView>(R.id.textViewProgress)

        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                textViewProgress.text = progress.toString()
            }
            override fun onStartTrackingTouch(seekBar: SeekBar) {
            }
            override fun onStopTrackingTouch(seekBar: SeekBar) {
            }
        })

        val spinner: Spinner = findViewById(R.id.jakosc_obsługi)
// Create an ArrayAdapter using the string array and a default spinner layout.
        ArrayAdapter.createFromResource(
            this,
            R.array.jakosc_obslugi_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears.
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner.
            spinner.adapter = adapter
        }

        val spinner2: Spinner = findViewById(R.id.jakosc_posiłku)
// Create an ArrayAdapter using the string array and a default spinner layout.
        ArrayAdapter.createFromResource(
            this,
            R.array.jakosc_posiłku_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears.
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner.
            spinner2.adapter = adapter
        }

    }


    fun ObliczNapiwek(view: View) {
        kwota = findViewById(R.id.editNum1)
        val seekBar = findViewById<SeekBar>(R.id.seekBar)
        val progress = seekBar.progress
        val progressDouble = progress.toDouble()

        //procent = findViewById(R.id.editNum2)
        textResult = findViewById(R.id.textResult)
        val num1 = kwota.text.toString().toDouble()
        //val num2 = procent.text.toString().toDouble()
        val result = num1 * progressDouble * 0.01
        val Result = String.format("%.2f", result)
        textResult.text = Result}
}