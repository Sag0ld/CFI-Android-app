package com.sagold.cfievent.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import com.sagold.cfievent.services.RequestService
import com.sagold.cfievent.services.StorageService
import okhttp3.Call
import com.sagold.cfievent.R
import okhttp3.Callback
import okhttp3.Response

import java.io.IOException

class SesameActivity : AppCompatActivity() {

    private lateinit var storage: StorageService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sesame)
        storage = StorageService(this)
    }

    fun sendDoorRequest() {
        Toast.makeText(this, "Will open soon.", Toast.LENGTH_SHORT).show()
        val requestService = RequestService.Instance()
        val doorUrl = "http://web.poptheshell.com:8888/door/request"
        val token = storage.getUserToken()

        val request = requestService.createPostRequest(doorUrl).newBuilder()
                                .addHeader("Authorization", "Bearer $token").build()
        requestService.sendRequest(request, object: Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.d("response", "fail :(")
            }

            override fun onResponse(call: Call, response: Response) {
                Log.d("response", "yeah!! :)")
            }
        })
    }
}
