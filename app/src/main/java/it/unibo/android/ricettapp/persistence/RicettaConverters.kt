package it.unibo.android.ricettapp.persistence

import androidx.room.TypeConverter
import it.unibo.android.ricettapp.model.IngredienteConQuantita
import it.unibo.android.ricettapp.model.Passaggio
import it.unibo.android.ricettapp.model.Tag
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.util.*

class RicettaConverters {


    @TypeConverter
    fun fromDate(date: Date?): Long? {
        return date?.time
    }

    @TypeConverter
    fun toDate(millisSinceEpoch: Long?): Date? {
        return millisSinceEpoch?.let {
            Date(it)
        }
    }

    @TypeConverter
    fun fromIngredienteConQuantita(ingredienti : Array<IngredienteConQuantita>?) : String? {
        return Json.encodeToString(ingredienti)
    }

    @TypeConverter
    fun toIngredienteConQuantita(string: String?) : Array<IngredienteConQuantita>? {
        return string?.let { Json.decodeFromString(it) }
    }

    @TypeConverter
    fun fromPassaggio(passaggi : Array<Passaggio>?) : String? {
        return Json.encodeToString(passaggi)
    }

    @TypeConverter
    fun toPassaggio(string: String?) : Array<Passaggio>? {
        return string?.let { Json.decodeFromString(it) }
    }

    @TypeConverter
    fun fromTag(tags : Array<Tag>?) : String? {
        return Json.encodeToString(tags)
    }

    @TypeConverter
    fun toTag(string: String?) : Array<Tag>? {
        return string?.let { Json.decodeFromString(it) }
    }
}