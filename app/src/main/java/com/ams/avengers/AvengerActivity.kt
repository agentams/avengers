package com.ams.avengers

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class AvengerActivity : AppCompatActivity() {
    var titlein:String?="avenger"

    lateinit var message:EditText
    lateinit var btnsend:Button
    lateinit var sharedpreferences:SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedpreferences=getSharedPreferences(getString(R.string.prefrences_file),Context.MODE_PRIVATE)
        setContentView(R.layout.avenger_activity)
        /*if (intent != null) {
            titlein = intent.getStringExtra("name")
        }*/
        titlein=sharedpreferences.getString("title","The Avenger")
        title = titlein


        //------------------------------------------------------------------------------------------------------------------------------------
        message = findViewById(R.id.mess)
        btnsend=findViewById(R.id.sendbtn)

        btnsend.setOnClickListener {
            Toast.makeText(this@AvengerActivity,"message sent",Toast.LENGTH_LONG).show()
            var m=message.text.toString()
            val intent = Intent(this@AvengerActivity, MessageActvity::class.java)
            intent.putExtra("nam",m)
            startActivity(intent)

        }
    }

}