package ghar.learn.lifecycleapp.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.lifecycleapp.R
import com.example.lifecycleapp.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    private lateinit var binding : FragmentMainBinding
    private lateinit var viewModel: MainViewModel

    companion object {
        val TAG: String = "MainFragment"
        fun newInstance() = MainFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {
        binding = FragmentMainBinding.inflate(layoutInflater)
        binding.tvFragment.text = getString(R.string.text_value_populating_dynamically)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        binding.fragProgressBar.visibility = View.VISIBLE
        viewModel.users.observe(viewLifecycleOwner) {users ->
            users?.let {
                binding.fragProgressBar.visibility = View.INVISIBLE
                binding.tvFragment.text = "$it"
                Log.i("MyTag", "users: $it")
            }
        }

        return binding.root
    }

}