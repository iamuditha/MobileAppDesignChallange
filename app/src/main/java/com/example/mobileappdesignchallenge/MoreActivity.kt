package com.example.mobileappdesignchallenge

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.app.ActivityCompat
import kotlinx.android.synthetic.main.activity_more.*

class MoreActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_more)


        //email text
        email.setOnClickListener {
            emailAction()
        }

        //phone number
        telephoneNumber.setOnClickListener {
            if (isPermissionGranted())
                {callAction()}
        }

        // view location button
        viewLocationButton.setOnClickListener {
            mapAction()
        }
    }

    // navigate to the location
    private fun mapAction() {

        val mapIntent = Intent().apply {
            action = Intent.ACTION_VIEW
            data = Uri.parse("geo:30.395414, -97.753739")
            `package` = "com.google.android.apps.maps"
        }
        startActivity(mapIntent)
    }

    //send the email
    private fun emailAction() {
        val subject = " Inquiry for the Photo Schoppe"
        val recipient = arrayOf("hello@IronOne.com ")
        val emailIntent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_EMAIL, recipient)
            putExtra(Intent.EXTRA_SUBJECT, subject)
            type = "text/plain"
        }
        startActivity(emailIntent)    }


    //make the phone call
    private fun callAction() {

        val phoneNumber = telephoneNumber.text.toString()
        val callIntent = Intent().apply {
            action = Intent.ACTION_CALL
            data = Uri.parse("tel:$phoneNumber")
        }
        startActivity(callIntent)
    }

    // check for the run time permission
    private fun isPermissionGranted() : Boolean{

            return if (Build.VERSION.SDK_INT >= 23) {
                if (checkSelfPermission(android.Manifest.permission.CALL_PHONE)==PackageManager.PERMISSION_GRANTED){
                    Log.v("call", "Permission is granted")
                    true
                } else{
                    Log.v("call","permission is revoked")
                    ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CALL_PHONE),1)
                    false
                }
            } else{
                Log.v("call","permission is revoked")
                true
            }
        }

        override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults)

            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(applicationContext, "Permission granted", Toast.LENGTH_SHORT).show()
                callAction()
            }
            else {
                Toast.makeText(applicationContext, "Permission denied", Toast.LENGTH_SHORT).show()
            }
            return
        }




}

