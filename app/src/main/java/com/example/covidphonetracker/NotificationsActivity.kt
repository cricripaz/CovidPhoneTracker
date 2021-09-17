package com.example.covidphonetracker

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth


class NotificationsActivity : AppCompatActivity() {

    private lateinit var toogle: ActionBarDrawerToggle
    lateinit var recyclerViewNotificaciones: RecyclerView
    private lateinit var alertDialogMenu: AlertDialog
    private lateinit var alertDialog: AlertDialog


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notifications)
        recyclerViewNotificaciones = findViewById(R.id.recyclerViewNotificaciones)
        getNotificationsData()
    }
    //para que el boton funcione
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toogle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    inner class notificacionesRecyclerViewAdapter(val context: Context, private val list: List<Notificacion>): RecyclerView.Adapter<OptionsViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OptionsViewHolder {
            val layoutInflater = LayoutInflater.from(context)
            val itemListView = layoutInflater.inflate(R.layout.layout_notificacion, parent, false)
            return OptionsViewHolder(itemListView)
        }

        override fun onBindViewHolder(holder: OptionsViewHolder, position: Int) {
            holder.bind(list[position])

            holder.itemView.setOnClickListener {
                Toast.makeText(this@NotificationsActivity, "nombre: ${list[position].fecha} número: ${list[position].texto} ", Toast.LENGTH_LONG).show()
            }
        }
        override fun getItemCount() = list.size
    }

    class OptionsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        // variables en pantalla
        val fecha: TextView = itemView.findViewById(R.id.fechaNotificacion)
        val backgroundItem: ImageView = itemView.findViewById(R.id.backgroundItem)
        val texto: TextView = itemView.findViewById(R.id.textoNotificacion)
        fun bind(notif: Notificacion) {
            fecha.text=notif.fecha
            texto.text=notif.texto
        }
    }

    fun getNotificationsData(){
        var listNotifications = mutableListOf<Notificacion>()

        val notificacion0 = Notificacion(
            "15/09/2021",
            "Posiblemente tengas covid, un número que estuvo cerca a ti en los últimos 5 días dió positivo, ve a hacerte una prueba lo más rápido posible."
        )
        listNotifications.add(notificacion0)

        val adapter = notificacionesRecyclerViewAdapter(this@NotificationsActivity, listNotifications)
        val layoutManager = LinearLayoutManager(this@NotificationsActivity)
        recyclerViewNotificaciones.adapter = adapter
        recyclerViewNotificaciones.layoutManager = layoutManager
        if(!listNotifications.isEmpty()){
            val mensajeSinNotificaciones = findViewById<TextView>(R.id.mensajeSinNotificaciones)
            mensajeSinNotificaciones.visibility = View.GONE
        }
    }
}