package it.unibo.android.ricettapp.view.ricettario

import android.content.Context
import android.os.Bundle
import android.view.*
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import it.unibo.android.ricettapp.R
import it.unibo.android.ricettapp.model.Ricetta
import it.unibo.android.ricettapp.presenter.gestionericettario.IRicettario
import it.unibo.android.ricettapp.presenter.gestionericettario.RicettarioPresenter
import java.text.DateFormat
import java.util.*

class RicettarioFragment : Fragment() {

    interface Callbacks {
        fun scegliRicetta(id: UUID)
    }

    private var callbacks: Callbacks? = null
    private lateinit var ricettaRecyclerView: RecyclerView
    private var adapter: RicettaAdapter? = RicettaAdapter(emptyList())
    private val ricettarioPresenter : IRicettario = RicettarioPresenter()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        callbacks = context as Callbacks?
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.fragment_list_ricetta, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.nuova_ricetta -> {
                val ricetta = Ricetta()
                ricettarioPresenter.aggiungiRicetta(ricetta)
                callbacks?.scegliRicetta(ricetta.id)
                true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_list_ricetta, container, false)

        ricettaRecyclerView = view.findViewById(R.id.recycler_view_ricetta) as RecyclerView
        ricettaRecyclerView.layoutManager = LinearLayoutManager(context)
        ricettaRecyclerView.adapter = adapter

        return view
    }

    override fun onDetach() {
        super.onDetach()
        callbacks = null
    }

    companion object {
        fun newInstance(): RicettarioFragment {
            return RicettarioFragment()
        }
    }

    private inner class RicettaHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener{

        private lateinit var ricetta : Ricetta

        private val nomeTextView : TextView = itemView.findViewById(R.id.nome_ricetta)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            TODO("Not yet implemented")
        }

        fun bind(ricetta: Ricetta) {
            this.ricetta = ricetta
            nomeTextView.text = this.ricetta.nome

        }

    }


    private inner class RicettaAdapter(var ricette: List<Ricetta>) : RecyclerView.Adapter<RicettaHolder>() {

            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RicettaHolder {
                /*
                val view = if(viewType == NORMAL_CRIME) {
                    layoutInflater.inflate(R.layout.list_item_crime, parent, false)
                } else layoutInflater.inflate(R.layout.list_item_serious_crime, parent, false)
                */
                val view = layoutInflater.inflate(R.layout.list_item_ricetta, parent, false)
                return RicettaHolder(view)
            }

            override fun onBindViewHolder(holder: RicettaHolder, position: Int) {
                val ricetta = ricette[position]
                holder.bind(ricetta)
            }

            override fun getItemCount() = ricette.size
    }
}