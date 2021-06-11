package it.unibo.android.ricettapp.persistence

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.Room
import it.unibo.android.ricettapp.model.Ricetta
import java.util.concurrent.Executors

private const val DATABASE_NAME = "ricettapp-database"

class Repository private constructor(context: Context) {

    private val database : AppDatabase = Room.databaseBuilder(
        context.applicationContext,
        AppDatabase::class.java,
        DATABASE_NAME
    ).build()

    private val ricettaDao = database.ricettaDao()
    private val executor = Executors.newSingleThreadExecutor()


    fun getRicette(): LiveData<List<Ricetta>> = ricettaDao.all

    fun getRicetta(id: Long): LiveData<Ricetta?> = ricettaDao.getRicetta(id)

    fun inserisciRicetta(ricetta: Ricetta) {
        executor.execute {
            ricettaDao.insertAll(ricetta)
        }
    }

    fun aggiornaRicetta(ricetta: Ricetta) {
        executor.execute {
            ricettaDao.update(ricetta)
        }
    }

    fun eliminaRicetta(ricetta: Ricetta) {
        executor.execute {
            ricettaDao.delete(ricetta)
        }
    }

    companion object {
        private var INSTANCE: Repository? = null

        fun initialize(context: Context) {
            if (INSTANCE == null) {
                INSTANCE = Repository(context)
            }
        }

        fun get(): Repository {
            return INSTANCE ?:
            throw IllegalStateException("Il repository deve essere inizializzato")
        }

    }

}