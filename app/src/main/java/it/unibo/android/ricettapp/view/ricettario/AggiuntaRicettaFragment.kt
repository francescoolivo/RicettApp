package it.unibo.android.ricettapp.view.ricettario

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.*
import androidx.fragment.app.Fragment
import it.unibo.android.ricettapp.R
import it.unibo.android.ricettapp.model.Ricetta
import it.unibo.android.ricettapp.presenter.gestionericettario.IRicettario
import it.unibo.android.ricettapp.presenter.gestionericettario.RicettarioPresenter

private const val ARG_RICETTA_ID = "ricetta_id"

class AggiuntaRicettaFragment : Fragment(), AdapterView.OnItemSelectedListener {

    private lateinit var ricetta: Ricetta

    private lateinit var nome : EditText
    private lateinit var descrizione : EditText
    private lateinit var cameraButton: ImageButton
    private lateinit var numeroPersone: EditText
    private lateinit var tempo: EditText
    private lateinit var unitaTempoSpinner : Spinner
    private lateinit var listaIngredienti : ListView
    private lateinit var aggiungiIngredienteButton: Button
    private lateinit var listaPassaggi : ListView
    private lateinit var contenutoPassaggio : EditText
    private lateinit var aggiungiPassaggioButton: ImageButton


    private val ricettarioPresenter : IRicettario = RicettarioPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.fragment_aggiunta_ricetta, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.salva_ricetta -> {
                callbacks?.creaRicetta()
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
        val view = inflater.inflate(R.layout.fragment_aggiunta_ricetta, container, false)

        nome = view.findViewById(R.id.nome_ricetta) as EditText
        descrizione = view.findViewById(R.id.descrizione_ricetta) as EditText
        cameraButton = view.findViewById(R.id.camera_button) as ImageButton
        numeroPersone = view.findViewById(R.id.numero_persone) as EditText
        tempo = view.findViewById(R.id.tempo) as EditText
        unitaTempoSpinner = view.findViewById(R.id.unità_tempo) as Spinner
        listaIngredienti = view.findViewById(R.id.lista_ingredienti) as ListView
        aggiungiIngredienteButton = view.findViewById(R.id.aggiungi_ingrediente) as Button
        listaPassaggi = view.findViewById(R.id.lista_passaggi) as ListView
        contenutoPassaggio = view.findViewById(R.id.contenuto_passaggio) as EditText
        aggiungiPassaggioButton = view.findViewById(R.id.aggiungi_passaggio) as ImageButton

        ArrayAdapter.createFromResource(
            this.requireContext(),
            R.array.unita_tempo,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            unitaTempoSpinner.adapter = adapter
        }

        return view
    }

    companion object {

        fun newInstance(): AggiuntaRicettaFragment {
            return AggiuntaRicettaFragment().apply {}
        }
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        TODO("Not yet implemented")
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("Not yet implemented")
    }

}