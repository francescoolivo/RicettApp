package it.unibo.android.ricettapp.view.ricettario

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import it.unibo.android.ricettapp.R
import it.unibo.android.ricettapp.model.Ricetta
import it.unibo.android.ricettapp.presenter.gestionericettario.IRicettario
import it.unibo.android.ricettapp.presenter.gestionericettario.RicettarioPresenter
import java.util.*

private const val ARG_RICETTA_ID = "ricetta_id"

class RicettaFragment : Fragment() {

    private lateinit var ricetta: Ricetta

    private lateinit var foto : ImageView
    private lateinit var nome : TextView
    private lateinit var descrizione : TextView

    private val ricettarioPresenter : IRicettario = RicettarioPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ricetta = Ricetta()
        val id: Long = arguments?.getLong(ARG_RICETTA_ID) as Long
        ricettarioPresenter.caricaRicetta(id)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_ricetta, container, false)

        nome = view.findViewById(R.id.nome_ricetta) as TextView
        descrizione = view.findViewById(R.id.descrizione_ricetta) as TextView
        foto = view.findViewById(R.id.immagine_ricetta) as ImageView

        nome.text = ricetta.nome
        descrizione.text = ricetta.descrizione

        return view
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