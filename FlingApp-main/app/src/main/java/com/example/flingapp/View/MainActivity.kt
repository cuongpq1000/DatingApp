package com.example.flingapp.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.flingapp.R

class MainActivity : AppCompatActivity() {
    companion object {
        const val URL = "https://webhook.site/"
        const val ROUTE ="68f0d390-aa4c-45f3-8272-a3202c0551fb" //TODO: this is likely to expire. Try your own URL.

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}