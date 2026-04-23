package com.example.midtermexam

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.midtermexam.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.esLiMain) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val adapter = ViewPagerAdapter(this)
        binding.esLiViewPager.adapter = adapter

        TabLayoutMediator(binding.esLiTabLayout, binding.esLiViewPager) { tab, position ->
            tab.text = when (position) {
                0 -> getString(R.string.es_li_tab_input)
                1 -> getString(R.string.es_li_tab_analytics)
                2 -> getString(R.string.es_li_tab_profile)
                else -> null
            }
        }.attach()
    }
}
