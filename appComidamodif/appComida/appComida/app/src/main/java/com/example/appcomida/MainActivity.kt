package com.example.appcomida

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class MainActivity : AppCompatActivity() {
    //Atributos
    private lateinit var spnProd:Spinner
    private lateinit var  edtCan:EditText
    private lateinit var tvPrecio:TextView
    private lateinit var tvTotal:TextView
    private lateinit var chkDeli:CheckBox
    private lateinit var tvDesc:TextView
    private lateinit var tvTotalPagar:TextView
    private lateinit var btnCalcular:Button


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
        spnProd=findViewById(R.id.spnProducto)
        edtCan=findViewById(R.id.edtCantidad)
        tvPrecio=findViewById(R.id.tvPrecio)
        tvTotal=findViewById(R.id.tvTotal)
        chkDeli=findViewById(R.id.chkDelivery)
        tvDesc=findViewById(R.id.tvDescuento)
        tvTotalPagar=findViewById(R.id.tvTotalPagar)
        btnCalcular=findViewById(R.id.btnCalcular)




        //Asignar
        btnCalcular.setOnClickListener { calcular()}


    }

    //Crear funcion calcular
    fun calcular(){
        //variables
        var  posProd:Int; var can:Int; var dely:Int=0; var des:Int=0 //int prod;
        var pre:Double;  var pagar:Double
        var total:Double

        //obtener la posicion del elemento seleccionado en el Spiner
        posProd=spnProd.selectedItemPosition
        when(posProd){
            0-> pre=0.0
            1-> pre=65.5
            2-> pre=34.5
            3-> pre=18.5
            4-> pre=17.5
            else-> pre=21.5
        }
        can=edtCan.text.toString().toInt()

        total=pre*can
        if (chkDeli.isChecked)
            dely=10
        if(total>60)
            des=5

        pagar=(total+dely)-des
        //salida
        tvPrecio.setText("S/. "+pre)
        tvTotal.setText("S/. "+total)
        tvDesc.setText("S/" +des)
        tvTotalPagar.setText("S/"  +pagar)
    }

}