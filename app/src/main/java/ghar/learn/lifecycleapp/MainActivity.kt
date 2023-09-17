package ghar.learn.lifecycleapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lifecycleapp.R
import com.example.lifecycleapp.databinding.ActivityMainBinding
import ghar.learn.lifecycleapp.ui.MainFragment

class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
        if(savedInstanceState == null){
            supportFragmentManager.beginTransaction()
                .replace(R.id.mainFragmentId, MainFragment.newInstance(), MainFragment.TAG)
                .commitNow()
        }
    }
}