package com.example.guess

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    val secretNumber= SecretNumber()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //setContentView(R.layout.linearlayout_main)

        Log.d("MainActivity","secret number:"+secretNumber.secret.toString())
    }

    fun check(view: View) {
        val n: Int = edit_number.text.toString().toInt()
        val diff_number = secretNumber.validate(n)
        Log.d("MainActivity", "number: " + n)
        var message = "Yes, you got it"
        if (diff_number < 0) {
            message = "Bigger"
        } else if (diff_number > 0) {
            message = "Smaller"
        }
//        Toast.makeText(this,message,Toast.LENGTH_LONG).show()
        AlertDialog.Builder(this)
            .setTitle("Message")
            .setMessage(message)
            .setPositiveButton("ok", null)
            .show()
    }
}
