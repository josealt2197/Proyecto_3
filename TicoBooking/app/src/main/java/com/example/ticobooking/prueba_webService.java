package com.example.ticobooking;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class prueba_webService extends AppCompatActivity implements Response.ErrorListener, Response.Listener<String> {
    EditText numero;
    TextView nombreHos, tipo, cantidad, provincia, precio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prueba_web_service);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        numero = (EditText) findViewById(R.id.numero);

        nombreHos = (TextView) findViewById(R.id.nombreHos);
        tipo = (TextView) findViewById(R.id.tipo);
        cantidad = (TextView) findViewById(R.id.cantidad);
        provincia = (TextView) findViewById(R.id.provincia);
        precio = (TextView) findViewById(R.id.precio);

    }

    public void enviaNumero(View view){
        EnvioMensaje enviaMensaje = new EnvioMensaje(numero.getText().toString());
        Request request = enviaMensaje.getRequest(this,this, this.getApplicationContext());
        AppController.getInstance().addToRequestQueue(request);
        //Toast notification=Toast.makeText(this, "La clave no puede estar vacía." + numero.getText(), Toast.LENGTH_LONG);
        //notification.show();
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Log.e("ErrorResponse", error.getMessage());
    }

    @Override
    public void onResponse(String response) {
        GsonBuilder builder = new GsonBuilder();
        builder.setExclusionStrategies(new DefaultExclusionStrategy());

        Gson gson = builder.create();
        Mensaje modelo = gson.fromJson(response, Mensaje.class);

        nombreHos.setText("HOTEL: " + modelo.getNombreHos());
        tipo.setText("TIPO: " + modelo.getTipo());
        cantidad.setText("CANTIDAD: " + modelo.getCantidad());
        provincia.setText("PROVINCIA: " + modelo.getProvincia());
        precio.setText("PRECIO: " + modelo.getPrecio());
    }
}
