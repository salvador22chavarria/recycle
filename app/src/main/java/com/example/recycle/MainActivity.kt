package com.example.recycle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList
//se declaran las variables privadas para despues llamarlas en la ejecucion
class MainActivity : AppCompatActivity() {
    private var recyclerView:RecyclerView?=null
    private var recyclerViewAdapter:three_r?=null
    private var besto_frientos= mutableListOf<data>()
    //se asignan los datos a las variables, se crea la vista del layout, se asigna el recycle view
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        besto_frientos=ArrayList()
        recyclerView=findViewById(R.id.vista_reciclaje)as RecyclerView
        recyclerViewAdapter= three_r(besto_frientos)
        val layoutManager:RecyclerView.LayoutManager=LinearLayoutManager(this)
        recyclerView!!.layoutManager=layoutManager
        recyclerViewAdapter!!.setOnItemClickListener(object:ClickListener<data>{
            override fun onItemClick(data: data) {
                Toast.makeText(this@MainActivity,data.nombre,Toast.LENGTH_SHORT).show()
            }
        })
        recyclerView!!.adapter=recyclerViewAdapter
        r_amiguis()
        //se conecta el activity con el nombre de los integrantes
        next.setOnClickListener {
            val intent= Intent(this,creador::class.java)
            startActivity(intent)
            }
    }
    //se asignan los parametros de la lista de amigos y se agregan a dicha lista por ultimo el recycleviewadapter notifica el cambio de los datos
    private fun r_amiguis(){
        var amigui=data("Gabriel",R.drawable.gabo,"gran amigo,leal,siempre me ayuda y me hace barra en mis aventuras")
    besto_frientos.add(amigui)
        amigui=data("Jaime",R.drawable.jaime,"pana de aventura, siempre me hace barra hasta la madrugada")
        besto_frientos.add(amigui)
        amigui=data("Adiel",R.drawable.adiel,"amigo,socio,amigo de aventuras de la u y compañero del gym")
        besto_frientos.add(amigui)
        amigui=data("Melvito",R.drawable.melvito,"amigo amable y compañero de tareas de mate y del gym")
        besto_frientos.add(amigui)
        amigui=data("Melvin perez",R.drawable.mango,"alias mango, este men es manco pero es un gran pana amable y su forma de ser es bien comica")
        besto_frientos.add(amigui)
        recyclerViewAdapter?.notifyDataSetChanged()
    }



}