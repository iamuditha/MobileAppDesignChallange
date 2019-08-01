package com.example.mobileappdesignchallenge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {

    private lateinit var buttonAnimation: Animation
    private lateinit var  textFieldAnimation: Animation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        //start the sign in button animation
        buttonAnimation = AnimationUtils.loadAnimation(this,R.anim.from_bottom)
        signUpButtonSignUpScreen.startAnimation(buttonAnimation)


        //start text field animation
        textFieldAnimation = AnimationUtils.loadAnimation(this,R.anim.from_top)
        signUpTextView.startAnimation(textFieldAnimation)
        userNameEditTextSignUpPage.startAnimation(textFieldAnimation)
        passwordEditTextSignUpPage.startAnimation(textFieldAnimation)
        emailEditTextSignUpPage.startAnimation(textFieldAnimation)


    }


}
