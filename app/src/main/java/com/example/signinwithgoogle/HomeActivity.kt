package com.example.signinwithgoogle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView
import com.google.firebase.auth.FirebaseAuth

class HomeActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    lateinit var textView: AppCompatTextView
    lateinit var signout: AppCompatButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        textView = findViewById(R.id.detail_textview)
        signout = findViewById(R.id.signOutButton)

        auth = FirebaseAuth.getInstance()

        val email = intent.getStringExtra("email")
        val displayName = intent.getStringExtra("name")

        textView.text = email + "\n" + displayName

        signout.setOnClickListener {
            auth.signOut()
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}