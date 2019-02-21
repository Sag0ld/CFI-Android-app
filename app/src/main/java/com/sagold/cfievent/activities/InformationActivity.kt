package com.sagold.cfievent.activities

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import com.sagold.cfievent.R
import com.sagold.cfievent.services.RequestService
import com.sagold.cfievent.services.StorageService
import com.squareup.okhttp.Callback
import com.squareup.okhttp.Request
import com.squareup.okhttp.Response
import kotlinx.android.synthetic.main.content_information_activity.*
import java.io.IOException


class InformationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_information)

        val action: String? = intent?.action
        val data: Uri? = intent?.data
        val storage = StorageService(this)

        if (!action.isNullOrEmpty())
            Toast.makeText(this, "Redirected by the webView", Toast.LENGTH_SHORT).show()
            val accessToken = data?.getQueryParameter("access_token")
            accessToken?.let { token ->
                storage.setUserToken(token)
            }


        sesameButton.setOnClickListener {
            val intent = Intent(this, SesameActivity::class.java)
            startActivity(intent)
        }
    }

}