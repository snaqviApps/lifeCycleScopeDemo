package com.example.lifecycleapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.lifecycle.lifecycleScope
import com.anushka.lifecycledemo.ui.main.MainFragment
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        progressBar = findViewById(R.id.progressBar)
        if(savedInstanceState == null){
            supportFragmentManager.beginTransaction()
                .replace(R.id.mainFragmentId, MainFragment.newInstance(), MainFragment.TAG)
                .commitNow()
        }

        lifecycleScope.launch {
            delay(3200)
            progressBar.visibility = View.VISIBLE
            delay(3200)
            progressBar.visibility = View.GONE
        }
    }
}