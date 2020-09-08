package com.example.gamemath

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        try {
            this.supportActionBar!!.hide()
        } catch (e: NullPointerException) {
        }

        val result = intent.getStringExtra("result")
        tvResult.text = result

    }
}