package com.example.mobileappdesignchallenge

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_navigation.*

class NavigationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)

        more.setOnClickListener {
            val intent = Intent(this@NavigationActivity,MoreActivity::class.java)
            startActivity(intent)
        }


    }
}
