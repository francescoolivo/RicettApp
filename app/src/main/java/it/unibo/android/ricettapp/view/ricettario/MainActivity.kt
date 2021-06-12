package it.unibo.android.ricettapp.view.ricettario

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import it.unibo.android.ricettapp.R
import it.unibo.android.ricettapp.model.Ricetta
import it.unibo.android.ricettapp.presenter.gestionericettario.RicettarioPresenter

private const val RICETTA = "ricetta"

class MainActivity : AppCompatActivity(), RicettarioFragment.Callbacks {

    private val ricettarioPresenter: RicettarioPresenter by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val currentFragment = supportFragmentManager.findFragmentById(R.id.fragment_container_ricetta)

        // if a fragment isn't already available
        if (currentFragment == null) {
            val fragment = RicettarioFragment.newInstance()
            supportFragmentManager
                .beginTransaction() // begins the transaction which will add the fragment (or more) to the activity
                .add(R.id.fragment_container_ricetta, fragment) // adds the fragment container, which is in activity_main, to the CrimeFragment instance
                .commit()
        }
    }

    override fun scegliRicetta(id: Long) {
        val fragment = RicettaFragment.newInstance(id)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container_ricetta, fragment)
            .addToBackStack(null)
            .commit()
    }



}