package com.example.lifecycleapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.lifecycleapp.databinding.ActivityMainBinding
import com.example.lifecycleapp.ui.MainFragment
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)   // data-binding utilization
        setContentView(mainBinding.root)

        if(savedInstanceState == null){
            supportFragmentManager.beginTransaction()
                .replace(R.id.mainFragmentId, MainFragment.newInstance(), MainFragment.TAG)
                .commitNow()
        }
        lifecycleScope.launch {
            Log.i("MyTag-Main","Thread name is : ${Thread.currentThread().name}")
            delay(2000)
            mainBinding.progressBar.visibility = View.VISIBLE
            delay(4100)
            mainBinding.progressBar.visibility = View.GONE
        }

        /**
         *
         * The below three Coroutines (scopes) replace the deprecated scopes of
         *  1. lifecycleScope.launchWhenCreated
         *  2. lifecycleScope.launchWhenStarted
         *  3. lifecycleScope.launchWhenResumed
         */

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.CREATED){

            }

            repeatOnLifecycle(Lifecycle.State.STARTED){

            }

            repeatOnLifecycle(Lifecycle.State.RESUMED){

            }

        }


    }
}