package com.example.calculator

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

import kotlin.math.*


class MainActivity : AppCompatActivity() {

    lateinit var outputTextView: TextView
    var isError: Boolean = false
    var firstNumber: Double = Double.NaN
    var lastOperation: Operations? = null
    var dotFlag: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        outputTextView = findViewById(R.id.result_panel)
        outputTextView.text = "0"
    }


    fun doSin(view: View) {
        if (!isError) {
            firstNumber = outputTextView.text.toString().toDouble()
            lastOperation = Operations.SIN
            this.unaryCalculation(view)
        }
    }

    fun doCos(view: View) {
        if (!isError) {
            firstNumber = outputTextView.text.toString().toDouble()
            lastOperation = Operations.COS
            this.unaryCalculation(view)
        }
    }

    fun doTan(view: View) {
        if (!isError) {
            firstNumber = outputTextView.text.toString().toDouble()
            lastOperation = Operations.TAN
            this.unaryCalculation(view)
        }
    }


    fun doCot(view: View) {
        if (!isError) {
            firstNumber = outputTextView.text.toString().toDouble()
            lastOperation = Operations.COT
            this.unaryCalculation(view)
        }
    }

    fun doLn(view: View) {
        if (!isError) {
            firstNumber = outputTextView.text.toString().toDouble()
            lastOperation = Operations.LN
            this.unaryCalculation(view)
        }
    }

    fun doExp(view: View) {
        if (!isError) {
            firstNumber = outputTextView.text.toString().toDouble()
            lastOperation = Operations.EXP
            this.unaryCalculation(view)
        }
    }

    fun doSqrt(view: View) {
        if (!isError) {
            firstNumber = outputTextView.text.toString().toDouble()
            lastOperation = Operations.SQRT
            this.unaryCalculation(view)
        }
    }

    fun doSquare(view: View) {
        if (!isError) {
            firstNumber = outputTextView.text.toString().toDouble()
            lastOperation = Operations.POW2
            this.unaryCalculation(view)
        }
    }

    fun addDigit(view: View) {
        if (isError) {
            outputTextView.text = (view as Button).text
            isError = false
        } else {
            val temp = outputTextView.text.toString();
            if (temp == "0") {
                outputTextView.text = (view as Button).text
            } else {

                outputTextView.append((view as Button).text)


            }
        }
    }

    fun addPoint(view: View) {
        if (!isError && !dotFlag) {
            outputTextView.append(".")
            dotFlag = true
        }
    }

    fun addPlus(view: View) {
        if (!isError) {
            lastOperation = Operations.PLUS
            firstNumber = outputTextView.text.toString().toDouble()
            outputTextView.text = "0"
        }

    }

    fun addMinus(view: View) {
        if (!isError) {
            lastOperation = Operations.MINUS
            firstNumber = outputTextView.text.toString().toDouble()
            outputTextView.text = "0"
        }

    }

    fun addMultiply(view: View) {
        if (!isError) {
            lastOperation = Operations.MULTIPLY
            firstNumber = outputTextView.text.toString().toDouble()
            outputTextView.text = "0"
        }

    }

    fun addDivide(view: View) {
        if (!isError) {
            lastOperation = Operations.DIVIDE
            firstNumber = outputTextView.text.toString().toDouble()
            outputTextView.text = "0"
        }

    }


    fun clear(view: View) {
        this.outputTextView.text = "0"
        isError = false
        dotFlag = false
    }

    fun unaryCalculation(view: View) {
        if (!this.isError) {
            var result: Double = 0.0
            when (lastOperation) {
                Operations.SIN -> result = sin(firstNumber)
                Operations.COS -> result= cos(firstNumber)
                Operations.TAN -> result= tan(firstNumber)
                Operations.COT -> result= (1 / tan(firstNumber))
                Operations.LN -> result = ln(firstNumber)
                Operations.SQRT -> result = sqrt(firstNumber)
                Operations.POW2 -> result = firstNumber.pow(2.0)
                Operations.EXP -> result = exp(firstNumber)
                null -> {
                    outputTextView.text = "Error"
                    isError = true
                }
            }
            if (result.isNaN() || result.isInfinite()) {
                outputTextView.text = "Error"
                isError = true
            } else {
                outputTextView.text = result.toString()
            }
            firstNumber = Double.NaN
            dotFlag = true
        }
    }

    fun binaryCalculation(view: View) {
        if (!isError && !firstNumber.isNaN() && lastOperation != null) {
            val secondNumber: Double = outputTextView.text.toString().toDouble()
            var result: Double = 0.0
            when (lastOperation) {
                Operations.PLUS -> result = (firstNumber + secondNumber)
                Operations.MINUS -> result = (firstNumber - secondNumber)
                Operations.MULTIPLY -> result = (firstNumber * secondNumber)
                Operations.DIVIDE -> result = (firstNumber / secondNumber)
                null -> {
                    outputTextView.text = "Error"
                    isError = true
                }
            }
            if (result.isNaN() || result.isInfinite()) {
                outputTextView.text = "Error"
                isError = true
            } else {
                outputTextView.text = result.toString()
            }
            firstNumber = Double.NaN
            dotFlag = true
        }
    }


}