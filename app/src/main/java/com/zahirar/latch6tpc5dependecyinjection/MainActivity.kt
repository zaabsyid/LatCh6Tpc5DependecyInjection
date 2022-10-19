package com.zahirar.latch6tpc5dependecyinjection

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.zahirar.latch6tpc5dependecyinjection.databinding.ActivityMainBinding
import com.zahirar.latch6tpc5dependecyinjection.view.MakeUpAdapter
import com.zahirar.latch6tpc5dependecyinjection.viewmodel.ViewModelMakeUp
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var makeUpAdapter : MakeUpAdapter
    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getDataMakeUp()
    }

    fun getDataMakeUp() {
        val viewmodel = ViewModelProvider(this).get(ViewModelMakeUp::class.java)

        viewmodel.getLDMakeUp().observe(this, Observer {
            makeUpAdapter = MakeUpAdapter(it)
            if (it != null){
                binding.rvListMakeUp.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
                binding.rvListMakeUp.adapter = MakeUpAdapter(it)
            }
        })
        viewmodel.callApiMakeUp()
    }
}