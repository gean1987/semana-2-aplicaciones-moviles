package com.example.app_settings

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.RadioButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity(),AdapterView.OnItemClickListener {
    //atributos
    private lateinit var txtCliente:TextInputEditText
    private lateinit var   rbtnDramatica:RadioButton
    private lateinit var  rbtnInfantiles:RadioButton
    private lateinit var  spnPelicula:AutoCompleteTextView
    private lateinit var  txtNinos:TextInputEditText
    private lateinit var  txtAdultos :TextInputEditText
    private lateinit var  btnCompra :Button



var postPelicula =-1
var posGenero =-1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //referenciar
        txtCliente =findViewById(R.id.txtCliente)
        rbtnDramatica =findViewById(R.id.rbtnDramatica)
        rbtnInfantiles=findViewById(R.id.rbtnInfantiles)
        spnPelicula=findViewById(R.id.spnPelicula)
        txtNinos=findViewById(R.id.txtNiños)
        txtAdultos=findViewById(R.id.txtAdultos)
        btnCompra=findViewById(R.id.btnCompra)
        //asignar evento onclick

        rbtnDramatica.setOnClickListener( {dramatica()})
        rbtnInfantiles.setOnClickListener( {infantiles()})
        btnCompra.setOnClickListener( {compra()})

        spnPelicula.setOnItemClickListener(this)
    }


    fun dramatica(){
    var peliculas= arrayListOf("Lo imposible","12 años de esclavitud","Historias cruzadas")
        //this es la clase en la que esta en este caso es esta por eso ponemos this
        var adaptador=ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,peliculas)
  spnPelicula.setAdapter(adaptador)
    }
    fun infantiles(){
        var peliculas= arrayListOf("Alvin y las ardillas","Bolt","Cars","Encantada")

        var adaptador=ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,peliculas)
        spnPelicula.setAdapter(adaptador)
    }
    fun compra(){

var cliente: String;var genero: String="";var pelicula: String;
        var canNinos:Int; var canAdultos: Int; var posGenero:Int=-1

cliente =txtCliente.text.toString()
        if(rbtnDramatica.isChecked)
        {
            genero="dramatico"
            posGenero=0
        }
        if(rbtnInfantiles.isChecked)
        {
            genero="infantiles"
            posGenero=1

        }
        pelicula =spnPelicula.text.toString()
        canNinos =txtNinos.text.toString().toInt()
        canAdultos =txtAdultos.text.toString().toInt()
//compraActibity es la segunda pestaña
        var pantalla2 = Intent(this,CompraActivity::class.java)
pantalla2.putExtra("datoscliente",cliente)
pantalla2.putExtra("nombregenero",genero)
pantalla2.putExtra("nombrepelicula",pelicula)
pantalla2.putExtra("asientosNinos",canNinos)
pantalla2.putExtra("asientosAdultos",canAdultos)
pantalla2.putExtra("posgenero",posGenero)
pantalla2.putExtra("posPelicula",postPelicula)

startActivity(pantalla2)

    }

    override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
postPelicula=p2
    }

}