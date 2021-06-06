package it.unibo.android.ricettapp.view.ingrediente

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import it.unibo.android.ricettapp.R

class IngredienteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val currentFragment = supportFragmentManager.findFragmentById(R.id.fragment_container_ingrediente)

        // if a fragment isn't already available
        /*if (currentFragment == null) {
            val fragment = CrimeListFragment.newInstance()
            supportFragmentManager
                .beginTransaction() // begins the transaction which will add the fragment (or more) to the activity
                .add(R.id.fragment_container, fragment) // adds the fragment container, which is in activity_main, to the CrimeFragment instance
                .commit()
        }*/
    }
}