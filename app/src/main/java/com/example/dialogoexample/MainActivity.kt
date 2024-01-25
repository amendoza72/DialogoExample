package com.example.dialogoexample

import android.app.DatePickerDialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.DatePicker
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import java.util.Calendar

class MainActivity : AppCompatActivity() {

    var calendario = Calendar.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onButtonToast(view: View) {
        Toast.makeText(this, R.string.mensaje_toast, Toast.LENGTH_LONG).show()
    }

    fun onAlertDialogButton(view:View){
        var builder: AlertDialog.Builder = AlertDialog.Builder(this)

        builder.setNegativeButton("No"){view, p1 ->
            var mensaje = "Bóton negativo pulsado"
            Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show()
        }

        builder.setMessage(R.string.mensaje_alert)
        builder.setTitle(R.string.titulo_alert)

        builder.setPositiveButton("Si"){view, p1 ->
            var mensaje = "Bóton positivo pulsado"
            Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show()
        }

        val neutralListener = object:DialogInterface.OnClickListener{
            override fun onClick(p0: DialogInterface?, p1: Int) {
                var mensaje = "Bóton neutro pulsado"
                Toast.makeText(applicationContext, mensaje, Toast.LENGTH_LONG).show()
            }

        }

        builder.setNeutralButton("Puede", neutralListener)

        builder.show()

        /*var alertDialog = builder.create()
        alertDialog.show()*/
    }


    fun onDatePickerDialogButton(view: View){

        val datePickerListener= object:DatePickerDialog.OnDateSetListener{
            override fun onDateSet(p0: DatePicker?, year: Int, month: Int, day: Int) {

                calendario.set(year, month, day)

                val mensaje: String= calendario.get(Calendar.DAY_OF_MONTH).toString() + "/" + calendario.get(Calendar.MONTH).toString() + "/" + calendario.get(Calendar.YEAR).toString()
                Toast.makeText(applicationContext, mensaje, Toast.LENGTH_LONG).show()
            }

        }



        var fechaDialog = DatePickerDialog(this, datePickerListener,
            calendario.get(Calendar.YEAR), calendario.get(Calendar.MONTH), calendario.get(Calendar.DAY_OF_MONTH))

        fechaDialog.show()
    }
}