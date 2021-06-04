package it.unibo.android.ricettapp.view.ricettario

import android.view.View
import androidx.recyclerview.widget.RecyclerView

class RicettarioFragment {

    private lateinit var recyclerView: RecyclerView

    private inner class RicettaHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener{

        override fun onClick(v: View?) {
            TODO("Not yet implemented")
        }

    }

    //private inner class RicettaAdapter(var ricette: List<Ricetta>) {}
}