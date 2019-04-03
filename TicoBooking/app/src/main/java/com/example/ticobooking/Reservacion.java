package com.example.ticobooking;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class Reservacion extends AppCompatActivity {

    private EditText edtFechaE, edtFechaS, edtComentarios;
    private Spinner sCantidad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservacion);

        edtFechaE = (EditText)findViewById(R.id.edtFechaEntrada);
        edtFechaS = (EditText)findViewById(R.id.edtFechaSalida);
        edtComentarios = (EditText)findViewById(R.id.edtComentarios);

        sCantidad = (Spinner)findViewById(R.id.sCantidadHuespedes);
        String []options={"1","2","3","4","5"};
        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, options);
        sCantidad.setAdapter(adapter);
    }
}
