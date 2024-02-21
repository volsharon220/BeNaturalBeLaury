package com.example.benaturalbylaury

import android.app.Notification.Action
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.benaturalbylaury.databinding.ActivityHomeBinding
import com.google.android.material.navigation.NavigationView

class Home : AppCompatActivity(),   NavigationView.OnNavigationItemSelectedListener {

    private lateinit var fragmentManager:FragmentManager
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)


        setSupportActionBar(binding.toolbar)
        val toggle = ActionBarDrawerToggle(this, binding.drawerLayout, binding.toolbar, R.string.nav_open, R.string.nav_close)
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()


        binding.navigationDrawer.setNavigationItemSelectedListener(this)

        binding.bottomNavigation.background=null
        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when(item.itemId){
               R.id.bottom_home -> openFragment(HomeFragment())
                R.id.bottom_search -> openFragment(SearchFragment())
                R.id.bottom_calendar -> openFragment(CalendarFragment())

            }
            true
        }
        fragmentManager = supportFragmentManager
        openFragment(HomeFragment())


    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.commandes -> openFragment(CommandeFragment())
            R.id.soins -> openFragment(SoinsFragment())
            R.id.parametre -> openFragment(ParametreFragment())
            R.id.rendez_vous -> openFragment(Rendez_vousFragment())
            R.id.rechercher -> openFragment(SearchFragment())
            R.id.profil -> openFragment(ProfilFragment())

        }
        binding.drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onBackPressed() {
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    private fun openFragment(fragment: Fragment){
        val fragmentTransaction: FragmentTransaction= fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container, fragment)
        fragmentTransaction.commit()

    }
}