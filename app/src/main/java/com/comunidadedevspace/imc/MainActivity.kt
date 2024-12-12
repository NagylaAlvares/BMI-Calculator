package com.comunidadedevspace.imc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // create a variable and associate with UI component <EditText>

        val edtWeight = findViewById<TextInputEditText>(R.id.edt_weight)
        val edtHeight = findViewById<TextInputEditText>(R.id.edt_height)

        val btnCalculate = findViewById<Button>(R.id.btn_calculate)



        btnCalculate.setOnClickListener{

            val weightStr = edtWeight.text.toString()
            val heightStr = edtHeight.text.toString()

            // validate if the field is not empty
            if (weightStr == "" || heightStr == ""){

                //show a message to user for fill in the fields
                Snackbar.make(edtWeight, "Fill out both fields", Snackbar.LENGTH_LONG).show()
            }else {
                val weight = edtWeight.text.toString().toFloat()
                val height = edtHeight.text.toString().toFloat()

                val result = weight / (height * height)

                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra(KEY_RESULT_BMI, result)
                startActivity(intent)

               // println("Your BMI is %.2f".format(result))


            }



        }



    }
}