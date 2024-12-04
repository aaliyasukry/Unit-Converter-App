package lk.nibm.ku.hdse233f.unitconverterapp

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.math.roundToLong

class MainActivity : AppCompatActivity() {
    private lateinit var spnType: Spinner
    private lateinit var txtInput: EditText
    private lateinit var btnConvert: Button
    private lateinit var lblOutput: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        spnType = findViewById(R.id.spnType)
        val types = arrayOf(
            "Distance (Km to m)",
            "Distance (m to Km)",
            "Temperature (F to C)",
            "Temperature (C to F)",
            "Weight (g to Kg)",
            "Weight (Kg to g)",
        )
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, types)
        spnType.adapter = adapter

        txtInput = findViewById(R.id.txtInput)
        lblOutput = findViewById(R.id.lblOutput)
        btnConvert = findViewById(R.id.btnConvert)
        btnConvert.setOnClickListener({
            val selected = spnType.selectedItem.toString()
            val input = txtInput.text.toString()

            if (input.isEmpty()){
                lblOutput.setText("Please Enter a Value")
            } else {
                val value = input.toDouble()
                var result: Double

                when (selected) {
                    "Distance (Km to m)" -> {
                        result = value * 1000
                        val roundedResult = String.format("%.2f", result)
                        lblOutput.setText("Result: ${roundedResult} meters")
                    }
                    "Distance (m to Km)" -> {
                        result = value / 1000
                        val roundedResult = String.format("%.2f", result)
                        lblOutput.setText("Result: ${roundedResult}Kilometers")
                    }
                    "Temperature (F to C)" -> {
                        result = (value - 32) * 5 / 9
                        val roundedResult = String.format("%.2f", result)
                        lblOutput.setText("Result: ${roundedResult} C")
                    }
                    "Temperature (C to F)" -> {
                        result = (value * 9 / 5) + 32
                        val roundedResult = String.format("%.2f", result)
                        lblOutput.setText("Result: ${roundedResult} F")
                    }
                    "Weight (g to Kg)" -> {
                        result = value / 1000
                        val roundedResult = String.format("%.2f", result)
                        lblOutput.setText("Result: ${roundedResult}Kilograms")
                    }
                    "Weight (Kg to g)" -> {
                        result = value * 1000
                        val roundedResult = String.format("%.2f", result)
                        lblOutput.setText("Result: ${roundedResult}grams")
                    }
                }
            }
        })

    }
}