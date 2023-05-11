package com.udb.ml190272sl190836desafio03dsm104

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var btnCrear: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnCrear = findViewById(R.id.Crear)

        btnCrear.setOnClickListener {
            val dbHelper = DbHelper(this@MainActivity)
            val db = dbHelper.writableDatabase
            if (db != null) {
                Toast.makeText(this@MainActivity, "BASE DE DATOS CREADA", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this@MainActivity, "ERROR AL CREAR BASE DE DATOS", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_s, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menuNuevo -> {
                goToInsert()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    private fun goToInsert() {
        val intent = Intent(this, InsertActivity::class.java)
        startActivity(intent)
    }

}
