package io.valueof.donotrefreshtab

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.navigation.NavController
import androidx.navigation.ui.setupActionBarWithNavController
import io.valueof.donotrefreshtab.databinding.ActivityMainBinding
import io.valueof.donotrefreshtab.extensions.setupWithNavController

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    private lateinit var binding: ActivityMainBinding

    private var currentNavController: LiveData<NavController>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            setUpBottomNavigationBar()
        }
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        setUpBottomNavigationBar()
    }

    private fun setUpBottomNavigationBar() {
        val navGraphIds = listOf(
            R.navigation.nav_tab_0,
            R.navigation.nav_tab_1,
            R.navigation.nav_tab_2
        )

        val controller = binding.bottomNavigationView.setupWithNavController(
            navGraphIds = navGraphIds,
            fragmentManager = supportFragmentManager,
            containerId = R.id.navHostContainer,
            intent = intent
        )

        controller.observe(this) { navController ->
            setupActionBarWithNavController(navController)
        }

        currentNavController = controller
    }

    override fun onSupportNavigateUp(): Boolean {
        return currentNavController?.value?.navigateUp() ?: false
    }
}