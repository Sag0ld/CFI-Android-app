package com.sagold.cfievent.services

import android.content.Context
import android.content.SharedPreferences
import com.sagold.cfievent.R

class StorageService(val context: Context) {

    var sharedPreferences: SharedPreferences = context.getSharedPreferences(
            context.getString(R.string.slack_storage_name), Context.MODE_PRIVATE)


    fun getUserToken(): String? {
       return sharedPreferences.getString(context.getString(R.string.slack_token_association_key), null)
    }

    fun setUserToken(token: String) {
        sharedPreferences.edit()
                .putString(context.getString(R.string.slack_token_association_key), token)
                .apply()
    }
}