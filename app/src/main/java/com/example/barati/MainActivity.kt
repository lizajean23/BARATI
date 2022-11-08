package com.example.barati

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.ActionBar
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
            if (cardNumber.length() != 16){
                cardNumber.error = "შეიყვანეთ სწორი მონაცემი"
                return@setOnClickListener
            }
            if(cvc.length() !=3 ){
                cvc.error = "შეიყვანეთ სწორი მონაცემი"
                return@setOnClickListener
            }
            if (month.text.toString().toInt() > 12 || month.text.toString().toInt() < 1){
                month.error = "შეიყვანეთ სწორი მონაცემი"
                return@setOnClickListener
            }
            if(year.text.toString().toInt() > 100 || year.text.toString().toInt() < 23){
                year.error = "შეოყვანეთ სწორი მონაცემი"
                return@setOnClickListener
            }
            if (!(checkBox.isChecked)){
                checkBox.error = "გთხოვთ მონიშნოთ ველი"
                return@setOnClickListener
            }
            Toast.makeText(this,"თქვენ წარმატებით გადაიხადეთ",Toast.LENGTH_LONG).show()

        }


    }

}