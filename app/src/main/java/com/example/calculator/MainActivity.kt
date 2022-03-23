package com.example.assignment05

import android.icu.text.DecimalFormat
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var sign = ""
    var num1 = ""
    var num2 = true
    var check = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn0.setOnClickListener {
            if (num2)equal.text = formatDecimal("${equal.text}0")
            else {
                equal.text = "0"
                num2 = true
            }
        }
        btn1.setOnClickListener {
            if (num2)equal.text = formatDecimal("${equal.text}1")
            else {
                equal.text = "1"
                num2 = true
            }
        }
        btn2.setOnClickListener{
            if (num2)equal.text = formatDecimal("${equal.text}2")
            else {
                equal.text = "2"
                num2 = true
            }
        }
        btn3.setOnClickListener {
            if (num2)equal.text = formatDecimal("${equal.text}3")
            else {
                equal.text = "3"
                num2 = true
            }
        }
        btn4.setOnClickListener {
            if (num2)equal.text = formatDecimal("${equal.text}4")
            else {
                equal.text = "4"
                num2 = true
            }
        }
        btn5.setOnClickListener {
            if (num2)equal.text = formatDecimal("${equal.text}5")
            else {
                equal.text = "5"
                num2 = true
            }
        }
        btn6.setOnClickListener {
            if (num2)equal.text = formatDecimal("${equal.text}6")
            else {
                equal.text = "6"
                num2 = true
            }
        }
        btn7.setOnClickListener {
            if (num2)equal.text = formatDecimal("${equal.text}7")
            else {
                equal.text = "7"
                num2 = true
            }
        }
        btn8.setOnClickListener {
            if (num2)equal.text = formatDecimal("${equal.text}8")else {
                equal.text = "8"
                num2 = true
            }
        }
        btn9.setOnClickListener {
            if (num2)equal.text = formatDecimal("${equal.text}9")
            else {
                equal.text = "9"
                num2 = true
            }
        }

        btnc.setOnClickListener {
            equal.text = "0"
            num1 = ""
            sign = ""
            check = false
            num2 = true
        }

        btndel.setOnClickListener {
            equal.text = equal.text.toString().dropLast(1).ifEmpty { "0" }
        }

        btnplus.setOnClickListener {
            sign = "+"
            if (sign !== "" && num1 == ""){
                num1 = equal.text.toString()
            }
            if (check) {
                compute()
                num1 = equal.text.toString()
            }
            check = true
            num2 = false
        }
        btnminus.setOnClickListener {
            sign = "-"
            if (sign !== "" && num1 == ""){
                num1 = equal.text.toString()
            }
            if (check) {
                compute()
                num1 = equal.text.toString()
            }
            check = true
            num2 = false

        }
        btnmulti.setOnClickListener {
            sign = "*"
            if (sign !== "" && num1 == ""){
                num1 = equal.text.toString()
            }
            if (check) {
                compute()
                num1 = equal.text.toString()
            }
            check = true
            num2 = false
        }
        btndivide.setOnClickListener {
            sign = "/"
            if (sign !== "" && num1 == ""){
                num1 = equal.text.toString()
            }
            if (check) {
                compute()
                num1 = equal.text.toString()
            }
            check = true
            num2 = false
        }
        btnmod.setOnClickListener {
            sign = "%"
            if (sign !== "" && num1 == ""){
                num1 = equal.text.toString()
            }
            if (check) {
                compute()
                num1 = equal.text.toString()
            }
            check = true
        }

        btnas.setOnClickListener {
            compute()
            sign = ""
            num1 = ""
            check = false
            num2 = false
        }

        btndot.setOnClickListener {
            if (!equal.text.toString().contains(".")&& equal.text.toString().isNotEmpty()){
                equal.text = "${equal.text}."
            }
        }

    }
    fun compute(){
        var num2 = equal.text.toString()
        if (sign != "" && num2 != ""){
            if (sign == "+"){equal.text = formatDecimal((num1.toDouble() + num2.toDouble()).toString())}
            else if (sign == "-"){equal.text = formatDecimal((num1.toDouble() - num2.toDouble()).toString())}
            else if (sign == "*"){equal.text = formatDecimal((num1.toDouble() * num2.toDouble()).toString())}
            else if (sign == "/"){
                if (num2 == "0" || num2 == ""){
                    equal.text = "ERROR"
                    return@compute
                }
                equal.text = formatDecimal((num1.toDouble() / num2.toDouble()).toString())
            }
            else if (sign == "%"){
                if (num2 == "0" || num2 == ""){
                    equal.text = "ERROR"
                    return@compute
                }
                equal.text = formatDecimal((num1.toDouble() % num2.toDouble()).toString())
            }

        }
    }
}



private fun formatDecimal(num: String): String {
    val format = DecimalFormat("0.#######");
    return format.format(num.ifEmpty { "0" }.toDouble())
}