package com.udb.ml190272sl190836desafio03dsm104

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.udb.ml190272sl190836desafio03dsm104.adapters.ListVerbsAdapter
import com.udb.ml190272sl190836desafio03dsm104.db.DbVerbs
import com.udb.ml190272sl190836desafio03dsm104.entidades.Verbs
//import com.udb.testjava.adaptadores.ListaContactosAdapter
//import com.udb.ml190272sl190836desafio03dsm104.db.DbVerbs
//import com.udb.testjava.entidades.Contactos
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    private lateinit var listVerbs: RecyclerView
    private lateinit var listArrayVerbs: ArrayList<Verbs>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listVerbs = findViewById(R.id.listVerbs)
        listVerbs.layoutManager = LinearLayoutManager(this)

        val dbVerbs = DbVerbs(this)

        listArrayVerbs = ArrayList()

       val adapter = ListVerbsAdapter(dbVerbs.showVerbs())
        listVerbs.adapter = adapter
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

