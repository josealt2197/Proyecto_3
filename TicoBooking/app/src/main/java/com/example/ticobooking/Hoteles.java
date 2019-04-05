package com.example.ticobooking;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.util.ArrayList;
import java.util.List;


public class Hoteles extends Fragment {

    private ListView lv;
    int []img={R.mipmap.bg_masthead, R.mipmap.bg_masthead2};
    String []name=new String[15];
    String []desc=new String[15];
    String []precio=new String[15];
    //int []price=new int[15];
    Button cargar;

    SoapPrimitive resultString;
    String mensaje;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hoteles, container, false);
        lv= (ListView) view.findViewById(R.id.lvHoteles);

        cargar = (Button) view.findViewById(R.id.btnlist);

        cargar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                SegundoPlano tarea = new SegundoPlano();
                tarea.execute();
            }
        });

        // Inflate the layout for this fragment
        return view;
    }

    public class SegundoPlano extends AsyncTask<Void, Void, Void>{

        @Override
        protected Void doInBackground(Void... params) {
            cargarhotel();
            CustomAdapter customAdapter = new CustomAdapter();
            lv.setAdapter(customAdapter);
            return null;
        }

        @Override
        protected void onPostExecute(Void result){
            //nombreHos.setText("RESPONSE: " + resultString + ", MENSAJE: " + mensaje);
        }
    }

    public void cargarhotel() {
        String SOAP_ACTION = "http://localhost:65400/WebService_Hotel/SearchHotel";
        String METHOD_NAME = "SearchHotel";
        String NAMESPACE = "http://localhost:65400/WebService_Hotel";
        String URL = "http://192.168.100.17:8091/WebService_Hotel.asmx";

        try {
            SoapObject Request = new SoapObject(NAMESPACE, METHOD_NAME);

            Request.addProperty("id", 1);
            SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER12);
            soapEnvelope.dotNet = true;
            soapEnvelope.setOutputSoapObject(Request);

            HttpTransportSE transport = new HttpTransportSE(URL);
            transport.call(SOAP_ACTION, soapEnvelope);
            resultString = (SoapPrimitive) soapEnvelope.getResponse();
            Log.e("VALORDEVUELTO", resultString.toString());

            String strJSON = resultString.toString();
            Gson gson = new Gson();

            TypeToken<ArrayList<Mensaje>> token = new TypeToken<ArrayList<Mensaje>>() {};
            List<Mensaje> hotellist = gson.fromJson(strJSON, token.getType());

            for (int i = 0; i < 2; i++) {
                name[i] = hotellist.get(i).getNombreHos();
                desc[i] = hotellist.get(i).getDescripcionhos();
                precio[i] = String.valueOf(hotellist.get(i).getPrecio());
                //String precio = String.valueOf(price[i]);
                Log.d("Name:", name[i]);
                Log.d("Desc:", desc[i]);
                Log.d("Price:", String.valueOf(precio[i]));
            }

            mensaje = "OK";

        } catch (Exception ex) {
            mensaje = "ERROR: " + ex.getMessage();
            Log.e("ErrorResponse", Log.getStackTraceString(ex));
        }
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
}
