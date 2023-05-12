package com.udb.ml190272sl190836desafio03dsm104.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.udb.ml190272sl190836desafio03dsm104.R
import com.udb.ml190272sl190836desafio03dsm104.ShowActivity
import com.udb.ml190272sl190836desafio03dsm104.entidades.Verbs

//import com.udb.testjava.R
//import com.udb.testjava.entidades.Contactos

class ListVerbsAdapter(private val listaVerbs: ArrayList<Verbs>) :
    RecyclerView.Adapter<ListVerbsAdapter.ContactoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_verb, parent, false)
        return ContactoViewHolder(view)
    }

    override fun onBindViewHolder(holder: ContactoViewHolder, position: Int) {
        val verb = listaVerbs[position]
        holder.viewVerbo.text = verb.Verbo
 /*       holder.viewInd_Yo.text = verb.Ind_Yo
        holder.viewInd_Tu.text = verb.Ind_Tu
        holder.viewInd_El_Ella_Usted.text = verb.Ind_El_Ella_Usted
        holder.viewInd_Nosotros.text = verb.Ind_Nosotros
        holder.viewInd_Vosotros.text = verb.Ind_Vosotros
        holder.viewInd_Ellos.text = verb.Ind_Ellos
        holder.viewImp_Tu.text = verb.Imp_Tu
        holder.viewImp_Nosotros.text = verb.Imp_Nosotros
        holder.viewImp_Ellos_Ellas_Ustedes.text = verb.Imp_Ellos_Ellas_Ustedes*/
    }

    override fun getItemCount(): Int {
        return listaVerbs.size
    }

    inner class ContactoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val viewVerbo: TextView = itemView.findViewById(R.id.viewVerbo)
       /* val viewInd_Yo: TextView = itemView.findViewById(R.id.viewInd_Yo)
        val viewInd_Tu: TextView = itemView.findViewById(R.id.viewInd_Tu)
        val viewInd_El_Ella_Usted: TextView = itemView.findViewById(R.id.viewInd_El_Ella_Usted)
        val viewInd_Nosotros: TextView = itemView.findViewById(R.id.viewInd_Nosotros)
        val viewInd_Vosotros: TextView = itemView.findViewById(R.id.viewInd_Vosotros)
        val viewInd_Ellos: TextView = itemView.findViewById(R.id.viewInd_Ellos)
        val viewImp_Tu: TextView = itemView.findViewById(R.id.viewImp_Tu)
        val viewImp_Nosotros: TextView = itemView.findViewById(R.id.viewImp_Nosotros)
        val viewImp_Ellos_Ellas_Ustedes: TextView = itemView.findViewById(R.id.viewImp_Ellos_Ellas_Ustedes)*/

        init {
            itemView.setOnClickListener {
                val context: Context = itemView.context
                val intent = Intent(context, ShowActivity::class.java)
                intent.putExtra("ID", listaVerbs[adapterPosition].id)
                context.startActivity(intent)
            }
        }


    }
}