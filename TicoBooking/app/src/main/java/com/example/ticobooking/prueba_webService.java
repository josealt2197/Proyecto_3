package com.example.ticobooking;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.sql.SQLOutput;

public class prueba_webService extends AppCompatActivity /*implements Response.ErrorListener, Response.Listener<String> */{
    EditText numero;
    TextView nombreHos, tipo, cantidad, provincia, precio;
    Button envia;
    String mensaje;
    String id;

    SoapPrimitive resultString;

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

        envia = (Button) findViewById(R.id.envia);

        envia.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                id = numero.getText().toString();

                SegundoPlano tarea = new SegundoPlano();
                tarea.execute();
            }
        });

    }


    private class SegundoPlano extends AsyncTask<Void, Void, Void>{

        @Override
        protected void onPreExecute(){

        }

        @Override
        protected Void doInBackground(Void... params) {
            enviaNumero();
            return null;
        }

        @Override
        protected void onPostExecute(Void result){
            nombreHos.setText("RESPONSE: " + resultString + ", MENSAJE: " + mensaje);
        }

    }

    public void enviaNumero(){
//        String SOAP_ACTION = "http://localhost:65400/WebService_Hotel/SearchHotel";
//        String METHOD_NAME = "SearchHotel";
//        String NAMESPACE = "http://localhost:65400/WebService_Hotel";
//        String URL = "http://192.168.100.17:8091/WebService_Hotel.asmx";

        String SOAP_ACTION = "http://192.168.100.17:8091/WebService_Hotel/SearchHotel";
        String METHOD_NAME = "SearchHotel";
        String NAMESPACE = "http://192.168.100.17:8091/WebService_Hotel";
        String URL = "http://192.168.100.17:8091/WebService_Hotel.asmx";

        try{
            SoapObject Request = new SoapObject(NAMESPACE, METHOD_NAME);

            Request.addProperty("id", id);

            SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER12);
            soapEnvelope.dotNet = true;
            soapEnvelope.setOutputSoapObject(Request);

            HttpTransportSE transport = new HttpTransportSE(URL);
            transport.call(SOAP_ACTION, soapEnvelope);
            resultString = (SoapPrimitive) soapEnvelope.getResponse();

            mensaje = "OK";

        }catch (Exception ex){
            mensaje = "ERROR: " + ex.getMessage();
        }
    }

    /*public void enviaNumero(View view){
        EnvioMensaje enviaMensaje = new EnvioMensaje(numero.getText().toString());
        Request request = enviaMensaje.getRequest(this,this, this.getApplicationContext());
        request.setRetryPolicy(new DefaultRetryPolicy(5000, 3, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        AppController.getInstance().addToRequestQueue(request);
        //Toast notification=Toast.makeText(this, "La clave no puede estar vacía." + numero.getText(), Toast.LENGTH_LONG);
        //notification.show();
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        //Log.d("ErrorResponse", "", error.getMessage());
        Log.e("ErrorResponse", Log.getStackTraceString(error));
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
    }*/
}
