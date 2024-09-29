package com.example.app_settings

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.app_settings.R

class CompraActivity : AppCompatActivity() {
    //atributos
    private lateinit var imgFotoC: ImageView
    private lateinit var tvClienteC: TextView
    private lateinit var tvGeneroC: TextView
    private lateinit var tvPeliculaC: TextView
    private lateinit var tvAdultosC: TextView
    private lateinit var tvNinosC: TextView
    private lateinit var tvMontoAdultosC: TextView
    private lateinit var tvMontoNinosC: TextView
    private lateinit var tvTotalPagarC: TextView
    private lateinit var btnVolverC: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.compra_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        imgFotoC = findViewById(R.id.imgFotoC)
        tvClienteC = findViewById(R.id.tvClienteC)
        tvGeneroC = findViewById(R.id.tvGeneroC)
        tvPeliculaC = findViewById(R.id.tvPeliculaC)
        tvAdultosC = findViewById(R.id.tvAdultosC)
        tvNinosC = findViewById(R.id.tvNinosC)
        tvMontoAdultosC = findViewById(R.id.tvMontoAdultosC)
        tvMontoNinosC = findViewById(R.id.tvMontoNinosC)
        tvTotalPagarC = findViewById(R.id.tvTotalPagarC)
        btnVolverC = findViewById(R.id.btnVolverC)


        VerDatos()

    }

    fun VerDatos() {
        var info = intent.extras!!

        //posiciongenero
        var pGenero = info.getInt("posgenero")
        //
        var pPelicula = info.getInt("posPelicula")
        var ID:Int
        ID=this.resources.getIdentifier("p"+pGenero+pPelicula,"drawable",packageName)
        imgFotoC.setImageResource(ID)
        tvClienteC.setText("cliente:" + info.getString("datoscliente"))
        tvGeneroC.setText("cliente:" + info.getString("nombregenero"))
        tvPeliculaC.setText("pelicula: " + info.getString("nombrepelicula"))
        tvNinosC.setText("Asientos niños:  " + info.getInt("asientosNinos"))
        tvAdultosC.setText("Asientos adultos:  " + info.getInt("asientosAdultos"))

var pre :Double =0.0;var costoadulto=0.0; var costoNinos =0.0;var total =0.0
        if(pGenero==0 && pPelicula ==0)
            pre =30.5

        if(pGenero==0 && pPelicula ==1)
            pre =28.3

        if(pGenero==0 && pPelicula ==2)
            pre =25.5


        if(pGenero==1 && pPelicula ==0)
            pre =58.9

        if(pGenero==1 && pPelicula ==1)
            pre =57.0

        if(pGenero==1 && pPelicula ==2)
            pre =60.0

        if(pGenero==1 && pPelicula ==3)
            pre =65.5

        if(pGenero==1 && pPelicula ==4)
            pre =57.8

        costoadulto=pre*info.getInt("asientosAdultos")
        costoNinos=(pre-10)*info.getInt("asientosNinos")
        total =costoadulto + costoNinos

        tvMontoAdultosC.setText("Monto adultos: $ " +costoadulto)
        tvMontoNinosC.setText("Monto Niños: $ " +costoNinos)
        tvTotalPagarC.setText("Total a pagar: $ " +total)
    }

}




