package com.example.ticobooking;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;

public class EnvioMensaje {

    private String numero;
    public EnvioMensaje(String numero){
        this.numero = numero;
    }

    public StringRequest getRequest(Response.Listener<String> responseListener, Response.ErrorListener errorListener, Context context) {
        final HashMap<String, Integer> credenciales = new HashMap<>();
        int id = Integer.parseInt(numero);
        credenciales.put("id", id);

        String url = "http://192.168.56.1:65400/WebService_Hotel.asmx/SearchHotel"; //Direccion del web service
        StringRequest request = new StringRequest(Request.Method.POST, url, responseListener, errorListener) {
            @Override
            public String getBodyContentType() {
                return "application/json charset=" + getParamsEncoding();
            }

            @Override
            public byte[] getBody(){
                try{
                    return new JSONObject(credenciales).toString().getBytes(getParamsEncoding());
                }catch (UnsupportedEncodingException e){

                }

                return null;
            }
        };
        request.setRetryPolicy(new LongTimeoutAndTryRetryPolicy(LongTimeoutAndTryRetryPolicy.RETRIES_PHONE_ISP));
        Toast.makeText(context, "ENVIO MENSAJE" + id, Toast.LENGTH_LONG).show();
        return request;
    }
}
