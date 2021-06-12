package it.unibo.android.ricettapp.view.ricettario

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.*
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import it.unibo.android.ricettapp.R
import it.unibo.android.ricettapp.model.Ricetta
import it.unibo.android.ricettapp.presenter.gestionericettario.RicettarioPresenter

private const val ARG_RICETTA_ID = "ricetta_id"
private const val RICETTA = "ricetta"

class AggiuntaRicettaActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {


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


    private lateinit var ricettarioPresenter: RicettarioPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_aggiunta_ricetta)

        ricettarioPresenter = ViewModelProvider(this).get(RicettarioPresenter::class.java)

        nome = findViewById<EditText>(R.id.nome_ricetta)
        descrizione = findViewById<EditText>(R.id.descrizione_ricetta)
        cameraButton = findViewById<ImageButton>(R.id.camera_button)
        numeroPersone = findViewById<EditText>(R.id.numero_persone)
        tempo = findViewById<EditText>(R.id.tempo)
        unitaTempoSpinner = findViewById<Spinner>(R.id.unità_tempo)
        listaIngredienti = findViewById<ListView>(R.id.lista_ingredienti)
        aggiungiIngredienteButton = findViewById<Button>(R.id.aggiungi_ingrediente)
        listaPassaggi = findViewById<ListView>(R.id.lista_passaggi)
        contenutoPassaggio = findViewById<EditText>(R.id.contenuto_passaggio)
        aggiungiPassaggioButton = findViewById<ImageButton>(R.id.aggiungi_passaggio)

        ArrayAdapter.createFromResource(
            this.applicationContext,
            R.array.unita_tempo,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            unitaTempoSpinner.adapter = adapter
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.activity_aggiunta_ricetta, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.salva_ricetta -> {
                var ricetta : Ricetta = Ricetta()
                ricetta.nome = nome.text.toString()
                ricetta.descrizione = descrizione.text.toString()
                ricetta.numeroDiPersone = numeroPersone.text.toString().toInt()
                ricetta.tempoDiEsecuzione = if(unitaTempoSpinner.selectedItem.toString().equals("h", true)) {
                    var temp = tempo.text.toString().toInt()
                    temp * 60
                } else {
                    tempo.text.toString().toInt()
                }
                ricettarioPresenter.aggiungiRicetta(ricetta)

                setResult(Activity.RESULT_OK)
                finish()
                true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    /*override fun onCreateView(name: String, context: Context, attrs: AttributeSet): View? {
        val inflater : LayoutInflater = layoutInflater
        val view = inflater.inflate(R.layout.activity_aggiunta_ricetta, null)

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
            this.applicationContext,
            R.array.unita_tempo,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            unitaTempoSpinner.adapter = adapter
        }

        return view
    }*/



    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        TODO("Not yet implemented")
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("Not yet implemented")
    }

    companion object {
        fun newIntent(packageContext: Context): Intent {
            return Intent(packageContext, AggiuntaRicettaActivity::class.java)
        }
    }

}
