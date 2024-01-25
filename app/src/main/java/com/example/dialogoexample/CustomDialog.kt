package com.example.dialogoexample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.DialogFragment

class CustomDialog: DialogFragment() {

    var mainActivity:MainActivity? = null;

    lateinit var editTextUsuario: EditText;
    lateinit var editTextPassword: EditText;
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //return super.onCreateView(inflater, container, savedInstanceState)

        var viewDialog = inflater.inflate(R.layout.custom_dialog_layout, container);

        editTextUsuario = viewDialog.findViewById(R.id.editTextNombre);
        editTextPassword = viewDialog.findViewById(R.id.editTextPassword);

        var botonCancelar = viewDialog.findViewById<Button>(R.id.buttonCancelar);
        botonCancelar.setOnClickListener { view -> cancelar() };

        var botonAceptar = viewDialog.findViewById<Button>(R.id.buttonAceptar);
        botonAceptar.setOnClickListener { view -> aceptar() };

        return  viewDialog;
    }

    fun cancelar(){
        dismiss();
    }

    fun aceptar(){
        var usuario = editTextUsuario.text.toString();
        var password = editTextPassword.text.toString();

        if (mainActivity!=null){
            mainActivity!!.actualizarUsuarioPassword(usuario, password);
        }
        dismiss();
    }
}