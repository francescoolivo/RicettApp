package it.unibo.android.ricettapp.view.ricettario

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.LiveData
import it.unibo.android.ricettapp.R
import it.unibo.android.ricettapp.model.Ricetta
import it.unibo.android.ricettapp.presenter.gestionericettario.RicettarioPresenter

private const val ARG_RICETTA_ID = "ricetta_id"

class RicettaFragment : Fragment() {

    private lateinit var ricetta: LiveData<Ricetta>

    //private lateinit var foto : ImageView
    private lateinit var nome : TextView
    private lateinit var descrizione : TextView
    private lateinit var persone : TextView
    private lateinit var tempoDiEsecuzione : TextView

    private val ricettarioPresenter: RicettarioPresenter by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val id: Long = arguments?.getLong(ARG_RICETTA_ID) as Long
        Log.d("RICETTA_FRAGMENT", "id: $id")
        ricetta = ricettarioPresenter.scegliRicetta(id)
        Log.d("RICETTA_FRAGMENT", "ricetta: $ricetta")
    }

     override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_ricetta, container, false)

        nome = view.findViewById(R.id.nome_ricetta) as TextView
        descrizione = view.findViewById(R.id.descrizione_ricetta) as TextView
        persone = view.findViewById(R.id.numero_persone_ricetta) as TextView
        tempoDiEsecuzione = view.findViewById(R.id.tempo) as TextView
        //foto = view.findViewById(R.id.immagine_ricetta) as ImageView

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ricetta.observe(
            viewLifecycleOwner,
            { ricetta ->
                ricetta?.let {
                    updateUI(ricetta)
                }
            })
    }

    private fun updateUI(ricetta: Ricetta) {
        nome = view?.findViewById(R.id.nome_ricetta) as TextView
        descrizione = requireView().findViewById(R.id.descrizione_ricetta) as TextView
        persone = requireView().findViewById(R.id.numero_persone_ricetta) as TextView
        tempoDiEsecuzione = requireView().findViewById(R.id.tempo) as TextView
        //foto = view.findViewById(R.id.immagine_ricetta) as ImageView

        nome.text = ricetta.nome
        descrizione.text = ricetta.descrizione
        val personeString = ricetta.numeroDiPersone.toString() + " persone"
        persone.text = personeString

        val tempoString : String = if (ricetta.tempoDiEsecuzione > 60) {
            (ricetta.tempoDiEsecuzione / 60).toString() + " h " + (ricetta.tempoDiEsecuzione % 60).toString() + " m"
        } else {
            (ricetta.tempoDiEsecuzione).toString() + " m"
        }

        tempoDiEsecuzione.text = tempoString
    }

    companion object {

        fun newInstance(id : Long): RicettaFragment {
            val args = Bundle().apply {
                putLong(ARG_RICETTA_ID, id)
            }
            return RicettaFragment().apply {
                arguments = args
            }
        }
    }
}


