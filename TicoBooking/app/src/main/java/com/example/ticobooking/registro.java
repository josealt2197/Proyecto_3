package com.example.ticobooking;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class registro extends AppCompatActivity {

    private EditText edtCedula, edtNombre, edtApellidos, edtTelefono, edtCorreo, edtFechaNacimiento, edtPass, edtRePass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        edtCedula = (EditText)findViewById(R.id.edtCedula);
        edtNombre = (EditText)findViewById(R.id.edtNombre);
        edtApellidos = (EditText)findViewById(R.id.edtApellidos);
        edtTelefono = (EditText)findViewById(R.id.edtTelefono);
        edtCorreo = (EditText)findViewById(R.id.edtCorreo);
        edtFechaNacimiento = (EditText)findViewById(R.id.edtFechaNacimiento);
        edtPass = (EditText)findViewById(R.id.edtPass);
        edtRePass = (EditText)findViewById(R.id.edtRePass);
    }

    public void registrousuario(View view) {

    }
}
