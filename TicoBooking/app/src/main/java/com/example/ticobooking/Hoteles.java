package com.example.ticobooking;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;


public class Hoteles extends Fragment {

    private ListView lv;
    private int []img={R.mipmap.bg_masthead, R.mipmap.bg_masthead2};
    private String []name;
    private String []desc;

    SoapPrimitive resultString;
    String mensaje;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hoteles, container, false);
        lv= (ListView) view.findViewById(R.id.lvHoteles);

        String SOAP_ACTION = "http://localhost:65400/WebService_Hotel/SearchHotel";
        String METHOD_NAME = "SearchHotel";
        String NAMESPACE = "http://localhost:65400/WebService_Hotel";
        String URL = "http://192.168.100.6:8091/WebService_Hotel.asmx";

        try{
            SoapObject Request = new SoapObject(NAMESPACE, METHOD_NAME);

            Request.addProperty("id", 1);
            SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER12);
            soapEnvelope.dotNet = true;
            soapEnvelope.setOutputSoapObject(Request);

            HttpTransportSE transport = new HttpTransportSE(URL);
            transport.call(SOAP_ACTION, soapEnvelope);
            resultString = (SoapPrimitive) soapEnvelope.getResponse();
            Log.e("VALORDEVUELTO", resultString.toString() );

            String  strJSON = resultString.toString();
            crearLista(strJSON);

            mensaje = "OK";

        }catch (Exception ex){
            mensaje = "ERROR: " + ex.getMessage();
            // Log.e("MENSAJEERROR:", ex.getMessage());
        }

        CustomAdapter customAdapter = new CustomAdapter();
        lv.setAdapter(customAdapter);
        // Inflate the layout for this fragment
        return view;
    }

    public class CustomAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return img.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = getLayoutInflater().inflate(R.layout.customlayout,null);

            ImageView ivHotelList = (ImageView) convertView.findViewById(R.id.ivHotelList);
            TextView tvNombreListHotel = (TextView) convertView.findViewById(R.id.tvNombreListHotel);
            TextView tvDescListHotel = (TextView) convertView.findViewById(R.id.tvDescListHotel);

            ivHotelList.setImageResource(img[position]);
            tvNombreListHotel.setText(name[position]);
            tvDescListHotel.setText(desc[position]);

            return convertView;
        }
    }

    public void crearLista(String strJSON){
        //se crea el objeto que ayuda deserealizar la cadena JSON
        Gson gson = new Gson();

        String arrListAOS;
        arrListAOS=strJSON.replaceAll("\\[", "").replaceAll("\\]","");
        Log.e("ARRAY:", arrListAOS );

        Mensaje userObject = gson.fromJson(arrListAOS, Mensaje.class);

        for(int i=0;i<img.length;i++){
            name[i]=userObject.getNombreHos();
            desc[i]=userObject.getDescripcionhos();
            Log.d("Name:",name[i]);
            Log.d("Desc:",desc[i]);
        }

    }
}
