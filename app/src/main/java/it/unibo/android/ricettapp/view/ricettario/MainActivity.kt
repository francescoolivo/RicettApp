package it.unibo.android.ricettapp.view.ricettario

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import it.unibo.android.ricettapp.R

class MainActivity : AppCompatActivity() {
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
}