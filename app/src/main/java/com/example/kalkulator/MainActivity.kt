package com.example.kalkulator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kalkulator.databinding.ActivityMainBinding
import java.lang.Double.parseDouble
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var fvalue: Double = 0.0
    private var svalue: Double = 0.0
    private var rvalue: Double = 0.0
    private lateinit var op: String
    private val format = DecimalFormat("0.#")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        button()

    }

    private fun operation() {
        when (op) {
            "+" -> getPlus()
            "-" -> getMinus()
            "x" -> getTimes()
            "/" -> getSlash()
        }
    }

    private fun button() {

        binding.BtnClean.setOnClickListener() {
            binding.input.setText("")
            binding.ope.setText("")
        }

        binding.BtnDel.setOnClickListener {
            binding.input.setText("")
            binding.ope.setText("")
        }

        binding.BtnOne.setOnClickListener() {
            binding.input.setText(binding.input.text.toString().trim() + "1")
        }

        binding.BtnTwo.setOnClickListener() {
            binding.input.setText(binding.input.text.toString().trim() + "2")
        }

        binding.BtnThree.setOnClickListener() {
            binding.input.setText(binding.input.text.toString().trim() + "3")
        }

        binding.BtnFour.setOnClickListener() {
            binding.input.setText(binding.input.text.toString().trim() + "4")
        }

        binding.BtnFive.setOnClickListener() {
            binding.input.setText(binding.input.text.toString().trim() + "5")
        }

        binding.BtnSix.setOnClickListener() {
            binding.input.setText(binding.input.text.toString().trim() + "6")
        }

        binding.BtnSeven.setOnClickListener() {
            binding.input.setText(binding.input.text.toString().trim() + "7")
        }

        binding.BtnEight.setOnClickListener() {
            binding.input.setText(binding.input.text.toString().trim() + "8")
        }

        binding.BtnNine.setOnClickListener {
            binding.input.setText(binding.input.text.toString().trim() + "9")
        }

        binding.BtnZero.setOnClickListener {
            binding.input.setText(binding.input.text.toString().trim() + "0")
        }

        binding.BtnPoint.setOnClickListener {
            binding.input.setText(binding.input.text.toString().trim() + ".")
        }

        binding.BtnPlus.setOnClickListener {
            try {
                fvalue = parseDouble(binding.input.text as String)
                op = "+"
                binding.input.setText("")
            } catch (e: java.lang.Exception) {
                binding.input.setText("")
                binding.ope.setText("")
            }

        }

        binding.BtnMinus.setOnClickListener {
            try {
                fvalue = parseDouble(binding.input.text as String)
                op = "-"
                binding.input.setText("")
            } catch (e: Exception) {
                binding.input.setText(binding.input.text.toString().trim() + "-")
            }

        }

        binding.BtnTime.setOnClickListener {
            try {
                fvalue = parseDouble(binding.input.text as String)
                op = "x"
                binding.input.setText("")
            } catch (e: java.lang.Exception) {
                binding.input.setText("")
                binding.ope.setText("")
            }

        }

        binding.BtnSlash.setOnClickListener {
            try {
                fvalue = parseDouble(binding.input.text as String)
                op = "/"
                binding.input.setText("")
            } catch (e: Exception) {
                binding.input.setText("")
                binding.ope.setText("")
            }
        }

        binding.BtnEqual.setOnClickListener {
            try {
                svalue = parseDouble(binding.input.text as String)
                operation()
            } catch(e: Exception) {
                binding.input.setText("")
                binding.ope.setText("")
            }
        }
    }

    private fun getPlus() {
        rvalue = fvalue + svalue
        binding.ope.setText(format.format(fvalue).toString() + op + format.format(svalue).toString())
        return binding.input.setText(format.format(rvalue).toString())
    }

    private fun getMinus() {
        rvalue = fvalue - svalue
        binding.ope.setText(format.format(fvalue).toString() + op + format.format(svalue).toString())
        return binding.input.setText(format.format(rvalue).toString())
    }

    private fun getTimes() {
        rvalue = fvalue * svalue
        binding.ope.setText(format.format(fvalue).toString() + op + format.format(svalue).toString())
        return binding.input.setText(format.format(rvalue).toString())
    }

    private fun getSlash() {
        rvalue = fvalue / svalue
        binding.ope.setText(format.format(fvalue).toString() + op + format.format(svalue).toString())
        return binding.input.setText(format.format(rvalue).toString())
    }

}