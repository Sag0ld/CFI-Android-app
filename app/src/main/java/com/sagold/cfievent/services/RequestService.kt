package com.sagold.cfievent.services

import com.squareup.okhttp.Callback
import com.squareup.okhttp.OkHttpClient
import com.squareup.okhttp.Request
import com.squareup.okhttp.RequestBody


class RequestService {

    private var httpClient: OkHttpClient = OkHttpClient()

    companion object {
        private var instance: RequestService? = null
        fun Instance(): RequestService {
            if (instance != null) {
                return instance as RequestService
            }
            return RequestService()
        }
    }

    fun createPostRequest(url: String): Request {
        val request= Request.Builder()
                .url(url)
                .post(RequestBody.create(null, ""))
        return request.build()
    }

    fun sendRequest(request: Request, requestResponseListener: Callback) {
        httpClient.newCall(request).enqueue(requestResponseListener)
    }
}