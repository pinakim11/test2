package com.example.pinak.test2

import android.app.Activity
import android.app.Fragment
import android.app.FragmentManager
import android.os.Bundle
import android.support.v4.app.FragmentActivity

import android.view.View

class MainActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onChangeButton(view: View){


        if(view == findViewById(R.id.search)) {
            // Create a new Fragment to be placed in the activity layout
            // Instantiate a new fragment.
            val newFragment =  FirstFragment()
            val args = Bundle()

            val transaction = supportFragmentManager.beginTransaction()
            transaction.addToBackStack(null);
            transaction.replace(R.id.fragment_container,newFragment)

            transaction.commit()
        }
        if(view == findViewById(R.id.back)){
        val secondFragment =  SecondFragment()
        val args = Bundle()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.addToBackStack(null);
        transaction.replace(R.id.fragment_container,secondFragment)

        transaction.commit()}

    }
}
