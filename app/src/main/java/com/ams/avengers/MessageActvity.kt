package com.ams.avengers

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.message_actvity.*

var tile:String?="empty"
class MessageActvity : AppCompatActivity() {
    lateinit var outbtn: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var sharedpreferences =
            getSharedPreferences(getString(R.string.prefrences_file), Context.MODE_PRIVATE)
        setContentView(R.layout.message_actvity)
        if (intent != null) {
            tile = intent.getStringExtra("nam")

        }
        tex.text = tile
        outbtn = findViewById(R.id.outbtn)
        outbtn.setOnClickListener {
            Toast.makeText(this@MessageActvity, "logged out", Toast.LENGTH_LONG).show()
            val intent = Intent(this@MessageActvity, login::class.java)
            startActivity(intent)
            sharedpreferences.edit().clear().apply()
        }
    }
}