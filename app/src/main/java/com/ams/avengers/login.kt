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

class login() : AppCompatActivity()/*, View.OnClickListener*/ {
    lateinit var umNo:EditText
    lateinit var btnLogin:Button
    lateinit var upass:EditText
    lateinit var uforgotpw:TextView
    lateinit var uresgister:TextView
   /* override fun onClick(v: View?) {
        Toast.makeText(this@login,"we clicked on log in",Toast.LENGTH_LONG).show()
    }*/
    lateinit var sharedprefrence:SharedPreferences
    val valuno="0123456789"
    val valupass=arrayOf("tony","steve","bruce","ak@123")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedprefrence=getSharedPreferences(getString(R.string.prefrences_file),Context.MODE_PRIVATE)
        val login=sharedprefrence.getBoolean("isloggedin",false)
        setContentView(R.layout.login)
        if(login)
        {
            val intent = Intent(this@login, AvengerActivity::class.java)
            startActivity(intent)
            finish()
        }

        title = "LOG IN"
        umNo = findViewById(R.id.t1)
        btnLogin = findViewById(R.id.b1)
        upass = findViewById(R.id.t2)
        uforgotpw = findViewById(R.id.fpss)
        uresgister = findViewById(R.id.uregis)
        btnLogin.setOnClickListener {
            val mno = umNo.text.toString()
            val upwd = upass.text.toString()
            var nameofuser = "avenger"
            val intent = Intent(this@login, AvengerActivity::class.java)

            if (mno == valuno) {
               /* if (upwd == valupass[0]) {
                    nameofuser = "tony"
                    Toast.makeText(
                        this@login,
                        "login sucessfull",
                        Toast.LENGTH_LONG
                    ).show()
                    intent.putExtra("name", nameofuser)
                    startActivity(intent)
                } else if (upwd == valupass[1]) {
                    nameofuser = "steve"
                    Toast.makeText(
                        this@login,
                        "login sucessfull",
                        Toast.LENGTH_LONG
                    ).show()
                    intent.putExtra("name", nameofuser)
                    startActivity(intent)
                } else if (upwd == valupass[2]) {
                    nameofuser = "bruce"
                    Toast.makeText(
                        this@login,
                        "login sucessfull",
                        Toast.LENGTH_LONG
                    ).show()
                    intent.putExtra("name", nameofuser)
                    startActivity(intent)
                } else if (upwd == valupass[3]) {
                    nameofuser = "Avenger"
                    Toast.makeText(
                        this@login,
                        "login sucessfull",
                        Toast.LENGTH_LONG
                    ).show()
                    intent.putExtra("name", nameofuser)
                    startActivity(intent)
               }*/
                when {
                   upwd == valupass[0]->{
                       nameofuser = "tony"
                       saveprefrence(nameofuser)
                       // intent.putExtra("name", nameofuser)
                    startActivity(intent)
                       Toast.makeText(
                           this@login,
                           "login sucessfull",
                           Toast.LENGTH_LONG
                       ).show()

                   }
                    upwd == valupass[1]->{
                        nameofuser = "steve"
                        saveprefrence(nameofuser)
                       // intent.putExtra("name", nameofuser)
                        startActivity(intent)
                        Toast.makeText(
                            this@login,
                            "login sucessfull",
                            Toast.LENGTH_LONG
                        ).show()

                    }
                    upwd == valupass[2]->{
                        nameofuser = "bruce"
                        saveprefrence(nameofuser)
                        //intent.putExtra("name", nameofuser)
                        startActivity(intent)
                        Toast.makeText(
                            this@login,
                            "login sucessfull",
                            Toast.LENGTH_LONG
                        ).show()

                    }
                    upwd == valupass[3]->{
                        nameofuser = "Avenger"
                        saveprefrence(nameofuser)
                      //  intent.putExtra("name", nameofuser)
                        startActivity(intent)
                        Toast.makeText(
                            this@login,
                            "login sucessfull",
                            Toast.LENGTH_LONG
                        ).show()

                    }
                    else-> {
                        Toast.makeText(
                            this@login,
                            "invalid info",
                            Toast.LENGTH_LONG
                        ).show()
                }
            }
            }
            else{
                Toast.makeText(
                    this@login,
                    "invalid info",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }
      override fun  onPause(){
          super.onPause()
          finish()
      }
    fun saveprefrence(title:String){
        sharedprefrence.edit().putBoolean("isloggedin",true).apply()
        sharedprefrence.edit().putString("title",title).apply()
    }



}