package com.lordkajoc.recyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.lordkajoc.recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragmentListLinear = FragmentListLinearLayout()
        setCurrentFragment(fragmentListLinear)
    }

    private fun setCurrentFragment(fragment: Fragment): FragmentTransaction =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fr_container, fragment)
            commit()
        }
}
