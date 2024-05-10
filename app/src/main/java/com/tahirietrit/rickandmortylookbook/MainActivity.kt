package com.tahirietrit.rickandmortylookbook

import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import com.tahirietrit.rickandmortylookbook.data.model.Character
import com.tahirietrit.rickandmortylookbook.databinding.MenuFragmentBinding
import com.tahirietrit.rickandmortylookbook.ui.detail.CharacterFragmentDetail
import com.tahirietrit.rickandmortylookbook.ui.home.HomeFragmentDirections


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        findViewById<ImageButton>(R.id.menu_button)
            .setOnClickListener {
//            findNavController(R.id.nav_host_fragment).navigate(R.id.action_homeFragment_to_MenuDetail2)

                val navController = findNavController(R.id.nav_host_fragment)

                // Check the current destination and navigate accordingly
                when (navController.currentDestination?.id) {
                    R.id.homeFragment -> {
                        navController.navigate(R.id.action_homeFragment_to_MenuDetail2)
                    }
                    R.id.EpisdoeList -> {
                        navController.navigate(R.id.action_EpisdoeList_to_MenuDetail)
                    }
                    R.id.EpisodeDetail -> {
                        navController.navigate(R.id.action_EpisodeDetail_to_MenuDetail)
                    }
                    R.id.LocationList -> {
                        navController.navigate(R.id.action_LocationList_to_MenuDetail)
                    }
                    R.id.LocationDetails -> {
                        navController.navigate(R.id.action_LocationDetails_to_MenuDetail)
                    }
                    R.id.fragmentDetail -> {
                        navController.navigate(R.id.action_fragmentDetail_to_MenuDetail)
                    }

                }
        }


    }



}

