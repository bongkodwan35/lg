package com.example.loginnnn

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.password
import kotlinx.android.synthetic.main.activity_main.username
import kotlinx.android.synthetic.main.activity_regispage.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }
    fun Login (v : View) {
        val api : LoginAPI = Retrofit.Builder()
            .baseUrl("http://10.0.2.2:3000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(LoginAPI ::class.java)

        val intent = Intent(this, pagetwo::class.java)
        startActivity(intent)

        api.loginUser(
            username.text.toString(),
            password.text.toString()).enqueue(object : Callback<User> {

            override fun onResponse(call: Call<User>, response: Response<User>) {
                if (response.isSuccessful()) {
                    Toast.makeText(applicationContext, "login successfull!", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(applicationContext, "Error", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                Toast.makeText(applicationContext, "Incorrect !", Toast.LENGTH_LONG).show()
            }

        })
    }
    fun Regis(v : View) {

        val intent = Intent(this, regispage::class.java)
        startActivity(intent)
    }
}
