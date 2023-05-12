package com.udb.ml190272sl190836desafio03dsm104

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.udb.ml190272sl190836desafio03dsm104.db.DbVerbs
import com.udb.ml190272sl190836desafio03dsm104.entidades.Verbs

class EditActivity : AppCompatActivity() {

    private lateinit var et_verb: EditText
    private lateinit var Ind_Yo: EditText
    private lateinit var Ind_Tu: EditText
    private lateinit var Ind_El_Ella_Usted: EditText
    private lateinit var Ind_Nosotros: EditText
    private lateinit var Ind_Vosotros: EditText
    private lateinit var Ind_Ellos: EditText
    private lateinit var Imp_Tu: EditText
    private lateinit var Imp_Nosotros: EditText
    private lateinit var Imp_Ellos_Ellas_Ustedes: EditText
    private lateinit var btnSave: Button

    private lateinit var verb: Verbs
    private var id = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)

        et_verb = findViewById(R.id.et_verb)
        Ind_Yo = findViewById(R.id.Ind_Yo)
        Ind_Tu = findViewById(R.id.Ind_Tu)
        Ind_El_Ella_Usted = findViewById(R.id.Ind_El)
        Ind_Nosotros = findViewById(R.id.Ind_Nosotros)
        Ind_Vosotros = findViewById(R.id.Ind_Vosotros)
        Ind_Ellos = findViewById(R.id.Ind_Ellos)
        Imp_Tu = findViewById(R.id.Imp_Tu)
        Imp_Nosotros = findViewById(R.id.Imp_Nosotros)
        Imp_Ellos_Ellas_Ustedes = findViewById(R.id.Imp_ellos)
        btnSave = findViewById(R.id.btnSave)

        if (savedInstanceState == null) {
            val extras = intent.extras
            if (extras == null) {
                id = 0
            } else {
                id = extras.getInt("ID")
            }
        } else {
            id = savedInstanceState.getSerializable("ID") as Int
        }

        val dbVerbs = DbVerbs(this)
        verb = dbVerbs.showVerb(id)!!

        if (verb != null) {
            et_verb.setText(verb.Verbo)
            Ind_Yo.setText(verb.Ind_Yo)
            Ind_Tu.setText(verb.Ind_Tu)
            Ind_El_Ella_Usted.setText(verb.Ind_El_Ella_Usted)
            Ind_Nosotros.setText(verb.Ind_Nosotros)
            Ind_Vosotros.setText(verb.Ind_Vosotros)
            Ind_Ellos.setText(verb.Ind_Ellos)
            Imp_Tu.setText(verb.Imp_Tu)
            Imp_Nosotros.setText(verb.Imp_Nosotros)
            Imp_Ellos_Ellas_Ustedes.setText(verb.Imp_Ellos_Ellas_Ustedes)
           /* btnSave.visibility = View.INVISIBLE
            et_verb.inputType = InputType.TYPE_NULL
            Ind_Yo.inputType = InputType.TYPE_NULL
            Ind_Tu.inputType = InputType.TYPE_NULL
            Ind_El_Ella_Usted.inputType = InputType.TYPE_NULL
            Ind_Nosotros.inputType = InputType.TYPE_NULL
            Ind_Vosotros.inputType = InputType.TYPE_NULL
            Ind_Ellos.inputType = InputType.TYPE_NULL
            Imp_Tu.inputType = InputType.TYPE_NULL
            Imp_Nosotros.inputType = InputType.TYPE_NULL
            Imp_Ellos_Ellas_Ustedes.inputType = InputType.TYPE_NULL*/
        }

        btnSave.setOnClickListener {
            if (!et_verb.text.toString().isEmpty() && !Ind_Yo.text.toString().isEmpty() && !Ind_Tu.text.toString().isEmpty()) {
                val correcto = dbVerbs.editVerb(id, et_verb.text.toString(), Ind_Yo.text.toString(), Ind_Tu.text.toString(), Ind_El_Ella_Usted.text.toString(), Ind_Nosotros.text.toString(), Ind_Vosotros.text.toString(), Ind_Ellos.text.toString(), Imp_Tu.text.toString(), Imp_Nosotros.text.toString(), Imp_Ellos_Ellas_Ustedes.text.toString())

                if (correcto) {
                    Toast.makeText(this@EditActivity, "Registro Modificado", Toast.LENGTH_LONG).show()
                    goToShow()
                } else {
                    Toast.makeText(this@EditActivity, "Error al modificar registro", Toast.LENGTH_LONG).show()
                }
            } else {
                Toast.makeText(this@EditActivity, "Debe llenar los campos obligatorios", Toast.LENGTH_LONG).show()
            }
        }

    }
    private fun goToShow() {
        val intent = Intent(this, ShowActivity::class.java)
        intent.putExtra("ID", id)
        startActivity(intent)
    }

}