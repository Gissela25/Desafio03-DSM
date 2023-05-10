package com.udb.ml190271sl190836desafio02dsm104.db

import android.content.ContentValues
import android.content.Context

class DbVerbs(context: Context?) {

    private val dbHelper: DbHelper = DbHelper(context)

    fun InsertV(
        Verbo: String,
        Ind_Yo: String,
        Ind_Tu: String,
        Ind_El_Ella_Usted: String,
        Ind_Nosotros: String,
        Ind_Vosostros: String,
        Ind_Ellos: String,
        Imp_Tu: String,
        Imp_Nosotros: String,
        Imp_Ellos_Ellas_Ustedes: String
    ): Long {
        var id: Long = 0

        try {
            val db = dbHelper.writableDatabase

            val values = ContentValues()
            values.put("Verbo",Verbo)
            values.put("Ind_Yo", Ind_Yo)
            values.put("Ind_Tu", Ind_Tu)
            values.put("Ind_El_Ella_Usted", Ind_El_Ella_Usted)
            values.put("Ind_Nosotros", Ind_Nosotros)
            values.put("Ind_Vosotros", Ind_Vosostros)
            values.put("Ind_Ellos", Ind_Ellos)
            values.put("Ind_Tu", Ind_Tu)
            values.put("Imp_Tu", Imp_Tu)
            values.put("Imp_Nosotros", Imp_Nosotros)
            values.put("Imp_Ellos_Ellas_Ustedes", Imp_Ellos_Ellas_Ustedes)

            id = db.insert(DbHelper.TABLE_VERBOS, null, values)
        } catch (ex: Exception) {
            ex.toString()
        }

        return id
    }

}