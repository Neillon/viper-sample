package com.neillon.viper_sample.router

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.neillon.viper_sample.R
import com.neillon.viper_sample.contracts.router.RouterContract
import com.neillon.viper_sample.view.ListNotesFragmentDirections

class NotesAppRouter(
    activity: FragmentActivity
) : RouterContract {

    private val navController: NavController by lazy {
        activity.findNavController(R.id.navHostFragment)
    }

    init {
        val appBarConfiguration = AppBarConfiguration(navController.graph)
        if (activity is AppCompatActivity) {
            NavigationUI.setupActionBarWithNavController(
                activity,
                navController,
                appBarConfiguration
            )
        }
    }

    override fun navigateToSaveFragment() {
        val action = ListNotesFragmentDirections.actionListNotesFragmentToSaveNoteFragment()
        navController.navigate(action)
    }

    override fun navigateBack() {
        navController.navigateUp()
    }

}