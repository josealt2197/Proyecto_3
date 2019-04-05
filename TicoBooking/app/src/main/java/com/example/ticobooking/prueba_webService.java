package com.example.ticobooking;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
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
import com.google.gson.reflect.TypeToken;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.lang.reflect.Type;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class prueba_webService extends AppCompatActivity /*implements Response.ErrorListener, Response.Listener<String> */{
    EditText numero;
    TextView nombreHos, tipo, cantidad, provincia, precio, imagendetail;
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
        imagendetail = (TextView) findViewById(R.id.imagendetail);

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
            //nombreHos.setText("RESPONSE: " + resultString + ", MENSAJE: " + mensaje);
        }

    }

    public void enviaNumero(){
//        String SOAP_ACTION = "http://localhost:65400/WebService_Hotel/SearchHotel";
//        String METHOD_NAME = "SearchHotel";
//        String NAMESPACE = "http://localhost:65400/WebService_Hotel";
//        String URL = "http://192.168.100.17:8091/WebService_Hotel.asmx";

        String SOAP_ACTION = "http://localhost:65400/WebService_Hotel/SearchHotel";
        String METHOD_NAME = "SearchHotel";
        String NAMESPACE = "http://localhost:65400/WebService_Hotel";
        String URL = "http://192.168.100.17:8091/WebService_Hotel.asmx";

        try{
            SoapObject Request = new SoapObject(NAMESPACE, METHOD_NAME);

            Request.addProperty("id", id);
            Log.e("ID ENVIADO:", id);
            SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER12);
            soapEnvelope.dotNet = true;
            soapEnvelope.setOutputSoapObject(Request);

            HttpTransportSE transport = new HttpTransportSE(URL);
            transport.call(SOAP_ACTION, soapEnvelope);
            resultString = (SoapPrimitive) soapEnvelope.getResponse();
            Log.d("VALORDEVUELTO", resultString.toString() );

            String  strJSON = resultString.toString();
            crearLista(strJSON);

            mensaje = "OK";

        }catch (Exception ex){
            mensaje = "ERROR: " + ex.getMessage();
            Log.e("MENSAJEERROR:", ex.getMessage());
        }
    }

    private void crearLista(String strJSON){
        String name[]= new String[10];
        //se crea el objeto que ayuda deserealizar la cadena JSON
        Gson gson = new Gson();

        String arrListAOS;
        arrListAOS=strJSON.replaceAll("\\[", "").replaceAll("\\]","");
        Log.e("ARRAY:", arrListAOS );

//        Mensaje userObject = gson.fromJson(strJSON, Mensaje.class);


//        List<Mensaje> hotellist = (List<Mensaje>) new Gson().fromJson( strJSON , Mensaje.class);

        TypeToken<ArrayList<Mensaje>> token = new TypeToken<ArrayList<Mensaje>>() {};
        List<Mensaje> hotellist = gson.fromJson(strJSON, token.getType());

//        nombreHos.setText("NOMBRE: " + userObject.getNombreHos());
//        tipo.setText("TIPO: " + userObject.getTipo());
//        cantidad.setText("CANTIDAD: " + userObject.getCantidad());
//        provincia.setText("PROVINCIA: " + userObject.getProvincia());
//        precio.setText("PRECIO: " + userObject.getPrecio());
//        imagendetail.setText("IMGDETAIL: " + userObject.getImagendetail());

        for (int i = 0; i <= 9; i++) {
            name[i] = hotellist.get(i).getNombreHos();
            Log.d("Name:", name[i]);
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
