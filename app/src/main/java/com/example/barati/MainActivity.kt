package com.example.barati

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.core.text.isDigitsOnly
import java.time.Year

class MainActivity : AppCompatActivity() {
    private lateinit var cardNumber: EditText
    private lateinit var month : EditText
    private lateinit var cvc : EditText
    private lateinit var button:Button
    private lateinit var year: EditText
    private lateinit var checkBox: CheckBox
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val actionBar : ActionBar? = supportActionBar
        actionBar?.hide()

        cardNumber = findViewById(R.id.cardNumber)
        month = findViewById(R.id.month)
        year = findViewById(R.id.year)
        cvc = findViewById(R.id.cvc)
        button = findViewById(R.id.button)
        checkBox = findViewById(R.id.checkBox)

        button.setOnClickListener{
            if (cardNumber.length() != 16 || !cardNumber.text.toString().isDigitsOnly()){
                cardNumber.error = "შეიყვანეთ სწორი მონაცემი"
                return@setOnClickListener
            }
            else if(cvc.length() !=3 || !cvc.text.toString().isDigitsOnly()){
                cvc.error = "შეიყვანეთ სწორი მონაცემი"
                return@setOnClickListener
            }
            else if (month.text.toString().isEmpty() || !month.text.toString().isDigitsOnly()){
                month.error = "ველი ცარიელია"
                return@setOnClickListener
            }
            else if (month.text.toString().toInt() > 12 || month.text.toString().toInt() < 1 ){
                month.error = "შეიყვანეთ სწორი მონაცემი"
                return@setOnClickListener
            }
            else if (year.text.toString().isEmpty() || !year.text.toString().isDigitsOnly()){
                year.error = "ველი ცარიელია"
                return@setOnClickListener

            }
            else if(year.text.toString().toInt() > 100 || year.text.toString().toInt() < 23 ){
                year.error = "შეოყვანეთ სწორი მონაცემი"
                return@setOnClickListener
            }
            else if (!(checkBox.isChecked)){
                checkBox.error = "გთხოვთ მონიშნოთ ველი"
                return@setOnClickListener
            }
            Toast.makeText(this,"თქვენ წარმატებით გადაიხადეთ",Toast.LENGTH_LONG).show()

        }


    }

}