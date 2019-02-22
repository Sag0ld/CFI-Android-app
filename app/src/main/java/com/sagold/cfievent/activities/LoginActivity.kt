package com.sagold.cfievent.activities

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.sagold.cfievent.R
import com.sagold.cfievent.services.StorageService
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        btn_bsign_in_with_slack.setOnClickListener { redirectToSlackSignIn() }
        btn_join_slack.setOnClickListener { redirectToSlack() }
        val storage = StorageService(this)
        if (!storage.getUserToken().isNullOrEmpty()) {
            val intent = Intent(this, InformationActivity::class.java)
            startActivity(intent)
        }
    }

    private fun redirectToSlack() {
        val host = "slack.cfiul.ca"

        val uri = "http://$host/"
        val webPage: Uri = Uri.parse(uri)

        val intent = Intent(Intent.ACTION_VIEW, webPage)
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }

    private fun redirectToSlackSignIn() {
        val host = "cfi-ul.slack.com"
        val scope = arrayOf("identity.basic", "identity.avatar", "identity.email")
        val clientID = "86349330102.552696997859"
        val redirectURI = "http://web.poptheshell.com:8888/auth"

        val uri = "https://$host/oauth/authorize?" +
                "scope=${scope.joinToString()}&" +
                "client_id=$clientID&" +
                "redirect_uri=$redirectURI"
        val webPage: Uri = Uri.parse(uri)

        val intent = Intent(Intent.ACTION_VIEW, webPage)
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }
}