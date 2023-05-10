package com.udb.ml190271sl190836desafio02dsm104

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.udb.ml190271sl190836desafio02dsm104.db.DbVerbs

class InsertActivity : AppCompatActivity() {

    private lateinit var txtVerb: EditText
    private lateinit var text1: EditText
    private lateinit var text2: EditText
    private lateinit var text3: EditText
    private lateinit var text4: EditText
    private lateinit var text5: EditText
    private lateinit var text6: EditText
    private lateinit var text7: EditText
    private lateinit var text8: EditText
    private lateinit var text9: EditText
    private lateinit var btnSave: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insert)


        txtVerb = findViewById(R.id.et_verb)
        text1= findViewById(R.id.Ind_Yo)
        text2= findViewById(R.id.Ind_Tu)
        text3= findViewById(R.id.Ind_El)
        text4= findViewById(R.id.Ind_Nosotros)
        text5= findViewById(R.id.Ind_Vosotros)
        text6= findViewById(R.id.Ind_Ellos)
        text7= findViewById(R.id.Imp_Tu)
        text8= findViewById(R.id.Imp_Nosotros)
        text9= findViewById(R.id.Imp_ellos)
        btnSave = findViewById(R.id.btnSave)

        btnSave.setOnClickListener {
            val dbVerbs = DbVerbs(this@InsertActivity)
            val id = dbVerbs.InsertV(
                txtVerb.text.toString(),
                text1.text.toString(),
                text2.text.toString(),
                text3.text.toString(),
                text4.text.toString(),
                text5.text.toString(),
                text6.text.toString(),
                text7.text.toString(),
                text8.text.toString(),
                text9.text.toString(),
            )

            if (id > 0) {
                Toast.makeText(this@InsertActivity, "REGISTRO GUARDADO", Toast.LENGTH_LONG).show()
                limpiar()
            } else {
                Toast.makeText(this@InsertActivity, "ERROR AL GUARDAR REGISTRO", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun limpiar() {
        txtVerb.text.clear()
        text1.text.clear()
        text2.text.clear()
        text3.text.clear()
        text4.text.clear()
        text5.text.clear()
        text6.text.clear()
        text7.text.clear()
        text8.text.clear()
        text9.text.clear()
    }

}