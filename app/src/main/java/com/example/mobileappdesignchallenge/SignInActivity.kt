package com.example.mobileappdesignchallenge


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_sign_in.*

class SignInActivity : AppCompatActivity() {

    private lateinit var buttonAnimation : Animation
    private lateinit var textFieldAnimation : Animation


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)


        //start the sign in button animation
        buttonAnimation = AnimationUtils.loadAnimation(this,R.anim.from_bottom)
        signInButtonSignInScreen.startAnimation(buttonAnimation)

        //start text field animation
        textFieldAnimation = AnimationUtils.loadAnimation(this,R.anim.from_top)
        signInTextView.startAnimation(textFieldAnimation)
        userNameEditTextSignInPage.startAnimation(textFieldAnimation)
        passwordEditTextSignInPage.startAnimation(textFieldAnimation)

        signInButtonSignInScreen.setOnClickListener {
            val intent = Intent(this@SignInActivity,NavigationActivity::class.java)
            startActivity(intent)
        }
    }


}
