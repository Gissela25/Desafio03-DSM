package com.udb.ml190272sl190836desafio03dsm104

import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.SearchView
import android.widget.Toast
import com.udb.ml190272sl190836desafio03dsm104.adapters.ListVerbsAdapter
import com.udb.ml190272sl190836desafio03dsm104.db.DbVerbs
import com.udb.ml190272sl190836desafio03dsm104.entidades.Verbs

import java.util.ArrayList

class MainActivity : AppCompatActivity(), SearchView.OnQueryTextListener {

    private lateinit var txtBuscar: SearchView
    private lateinit var listVerbs: RecyclerView
    private lateinit var listArrayVerbs: ArrayList<Verbs>
    private lateinit var adapter: ListVerbsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Video 3
        txtBuscar = findViewById(R.id.txtSearch)
        listVerbs = findViewById(R.id.listVerbs)
        listVerbs.layoutManager = LinearLayoutManager(this)
        val dbVerbs = DbVerbs(this)

        listArrayVerbs = ArrayList()

        adapter = ListVerbsAdapter(dbVerbs.showVerbs())
        listVerbs.adapter = adapter

        txtBuscar.setOnQueryTextListener(this)

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_s, menu)
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

    override fun onQueryTextSubmit(query: String): Boolean {
        return false
    }

    override fun onQueryTextChange(s: String): Boolean {
        adapter.filtrado(s)
        return false
    }
}

