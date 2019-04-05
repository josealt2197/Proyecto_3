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

//    private ListView lv;
    int []img={R.mipmap.bg_masthead, R.mipmap.bg_masthead2, R.mipmap.bg_masthead2, R.mipmap.bg_masthead2, R.mipmap.bg_masthead2, R.mipmap.bg_masthead2, R.mipmap.bg_masthead2, R.mipmap.bg_masthead2, R.mipmap.bg_masthead2};

    //region Variables para TextView e ImageView
    TextView tvNombre1, tvNombre2, tvNombre3, tvNombre4, tvNombre5, tvNombre6, tvNombre7, tvNombre8, tvNombre9, tvNombre10;
    TextView tvProvincia1, tvProvincia2, tvProvincia3, tvProvincia4, tvProvincia5, tvProvincia6, tvProvincia7, tvProvincia8, tvProvincia9, tvProvincia10;
    TextView tvPrecio1, tvPrecio2, tvPrecio3, tvPrecio4, tvPrecio5, tvPrecio6, tvPrecio7, tvPrecio8, tvPrecio9, tvPrecio10;
    TextView tvCantidad1, tvCantidad2, tvCantidad3, tvCantidad4, tvCantidad5, tvCantidad6, tvCantidad7, tvCantidad8, tvCantidad9, tvCantidad10;
    TextView tvTipo1, tvTipo2, tvTipo3, tvTipo4, tvTipo5, tvTipo6, tvTipo7, tvTipo8, tvTipo9, tvTipo10;
    ImageView imgHotel1, imgHotel2, imgHotel3, imgHotel4, imgHotel5, imgHotel6, imgHotel7, imgHotel8, imgHotel9, imgHotel10;
    //endregion

    //region Arreglos para valores
    String []name=new String[15];
    String []prov=new String[15];
    String []precio=new String[15];
    String []cant=new String[15];
    String []tipo=new String[15];
    //endregion

    Button cargar;

    SoapPrimitive resultString;
    String mensaje;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hoteles, container, false);
        //        lv= (ListView) view.findViewById(R.id.lvHoteles);

        //region Inicializacion de los TextView y ImageView

        //region Inicializacion de TextView: Nombre
            tvNombre1 = view.findViewById(R.id.tvNombre1);
            tvNombre2 = view.findViewById(R.id.tvNombre2);
            tvNombre3 = view.findViewById(R.id.tvNombre3);
            tvNombre4 = view.findViewById(R.id.tvNombre4);
            tvNombre5 = view.findViewById(R.id.tvNombre5);
            tvNombre6 = view.findViewById(R.id.tvNombre6);
            tvNombre7 = view.findViewById(R.id.tvNombre7);
            tvNombre8 = view.findViewById(R.id.tvNombre8);
            tvNombre9 = view.findViewById(R.id.tvNombre9);
            tvNombre10 = view.findViewById(R.id.tvNombre10);
        //endregion

        //region Inicializacion de TextView: Provincia
            tvProvincia1 = view.findViewById(R.id.tvProvincia1);
            tvProvincia2 = view.findViewById(R.id.tvProvincia2);
            tvProvincia3 = view.findViewById(R.id.tvProvincia3);
            tvProvincia4 = view.findViewById(R.id.tvProvincia4);
            tvProvincia5 = view.findViewById(R.id.tvProvincia5);
            tvProvincia6 = view.findViewById(R.id.tvProvincia6);
            tvProvincia7 = view.findViewById(R.id.tvProvincia7);
            tvProvincia8 = view.findViewById(R.id.tvProvincia8);
            tvProvincia9 = view.findViewById(R.id.tvProvincia9);
            tvProvincia10 = view.findViewById(R.id.tvProvincia10);
        //endregion

        //region Inicializacion de TextView: Cantidad
            tvCantidad1 = view.findViewById(R.id.tvCantidad1);
            tvCantidad2 = view.findViewById(R.id.tvCantidad2);
            tvCantidad3 = view.findViewById(R.id.tvCantidad3);
            tvCantidad4 = view.findViewById(R.id.tvCantidad4);
            tvCantidad5 = view.findViewById(R.id.tvCantidad5);
            tvCantidad6 = view.findViewById(R.id.tvCantidad6);
            tvCantidad7 = view.findViewById(R.id.tvCantidad7);
            tvCantidad8 = view.findViewById(R.id.tvCantidad8);
            tvCantidad9 = view.findViewById(R.id.tvCantidad9);
            tvCantidad10 = view.findViewById(R.id.tvCantidad10);
        //endregion

        //region Inicializacion de TextView: Precio
            tvPrecio1 = view.findViewById(R.id.tvPrecio1);
            tvPrecio2 = view.findViewById(R.id.tvPrecio2);
            tvPrecio3 = view.findViewById(R.id.tvPrecio3);
            tvPrecio4 = view.findViewById(R.id.tvPrecio4);
            tvPrecio5 = view.findViewById(R.id.tvPrecio5);
            tvPrecio6 = view.findViewById(R.id.tvPrecio6);
            tvPrecio7 = view.findViewById(R.id.tvPrecio7);
            tvPrecio8 = view.findViewById(R.id.tvPrecio8);
            tvPrecio9 = view.findViewById(R.id.tvPrecio10);
            tvPrecio10 = view.findViewById(R.id.tvPrecio10);
        //endregion

        //region Inicializacion de TextView: Tipo
            tvTipo1 = view.findViewById(R.id.tvTipo1);
            tvTipo2 = view.findViewById(R.id.tvTipo2);
            tvTipo3 = view.findViewById(R.id.tvTipo3);
            tvTipo4 = view.findViewById(R.id.tvTipo4);
            tvTipo5 = view.findViewById(R.id.tvTipo5);
            tvTipo6 = view.findViewById(R.id.tvTipo6);
            tvTipo7 = view.findViewById(R.id.tvTipo7);
            tvTipo8 = view.findViewById(R.id.tvTipo8);
            tvTipo9 = view.findViewById(R.id.tvTipo9);
            tvTipo10 = view.findViewById(R.id.tvTipo10);
        //endregion

        //region Inicializacion de ImageView
            imgHotel1 = view.findViewById(R.id.imgHotel1);
            imgHotel2 = view.findViewById(R.id.imgHotel2);
            imgHotel3 = view.findViewById(R.id.imgHotel3);
            imgHotel4 = view.findViewById(R.id.imgHotel4);
            imgHotel5 = view.findViewById(R.id.imgHotel5);
            imgHotel6 = view.findViewById(R.id.imgHotel6);
            imgHotel7 = view.findViewById(R.id.imgHotel7);
            imgHotel8 = view.findViewById(R.id.imgHotel8);
            imgHotel9 = view.findViewById(R.id.imgHotel9);
            imgHotel9 = view.findViewById(R.id.imgHotel10);
        //endregion

        //endregion

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
        protected void onPreExecute(){

        }

        @Override
        protected Void doInBackground(Void... params) {
            cargarhotel();

            return null;
        }

        @Override
        protected void onPostExecute(Void result){
            cargarvalores();
        }
    }

    public void cargarhotel() {
        String SOAP_ACTION = "http://localhost:65400/WebService_Hotel/SearchHotel";
        String METHOD_NAME = "SearchHotel";
        String NAMESPACE = "http://localhost:65400/WebService_Hotel";
        String URL = "http://192.168.100.6:8091/WebService_Hotel.asmx";

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

            for (int i = 0; i < 10; i++) {
                name[i] = hotellist.get(i).getNombreHos();
                prov[i] = hotellist.get(i).getProvincia();
                precio[i] = String.valueOf(hotellist.get(i).getPrecio());
                cant[i] = String.valueOf(hotellist.get(i).getCantidad());
                tipo[i] = hotellist.get(i).getTipo();

                Log.d("Nombre:", name[i]);
                Log.d("Provincia:", prov[i]);
                Log.d("Precio:", precio[i]);
                Log.d("Huepedes:", cant[i]);
                Log.d("Precio:", tipo[i]);
            }


//            CustomAdapter customAdapter = new CustomAdapter();
//            lv.setAdapter(customAdapter);

            mensaje = "OK";

        } catch (Exception ex) {
            mensaje = "ERROR: " + ex.getMessage();
            Log.e("ErrorResponse", Log.getStackTraceString(ex));
        }
    }

    public void cargarvalores(){

        //region Valores Nombre
        tvNombre1.setText(name[0]);
        tvNombre2.setText(name[1]);
        tvNombre3.setText(name[2]);
        tvNombre4.setText(name[3]);
        tvNombre5.setText(name[4]);
        tvNombre6.setText(name[5]);
        tvNombre7.setText(name[6]);
        tvNombre8.setText(name[7]);
        tvNombre9.setText(name[8]);
        tvNombre10.setText(name[9]);
        //endregion

        //region Valores Provincia
        tvProvincia1.setText(prov[0]);
        tvProvincia2.setText(prov[1]);
        tvProvincia3.setText(prov[2]);
        tvProvincia4.setText(prov[3]);
        tvProvincia5.setText(prov[4]);
        tvProvincia6.setText(prov[5]);
        tvProvincia7.setText(prov[6]);
        tvProvincia8.setText(prov[7]);
        tvProvincia9.setText(prov[8]);
        tvProvincia10.setText(prov[9]);
        //endregion

        //region Valores Cantidad
        tvCantidad1.setText(cant[0]);
        tvCantidad2.setText(cant[1]);
        tvCantidad3.setText(cant[2]);
        tvCantidad4.setText(cant[3]);
        tvCantidad5.setText(cant[4]);
        tvCantidad6.setText(cant[5]);
        tvCantidad7.setText(cant[6]);
        tvCantidad8.setText(cant[7]);
        tvCantidad9.setText(cant[8]);
        tvCantidad10.setText(cant[9]);
        //endregion

        //region Valores Precio
        tvNombre1.setText(precio[0]);
        tvNombre2.setText(precio[1]);
        tvNombre3.setText(precio[2]);
        tvNombre4.setText(precio[3]);
        tvNombre5.setText(precio[4]);
        tvNombre6.setText(precio[5]);
        tvNombre7.setText(precio[6]);
        tvNombre8.setText(precio[7]);
        tvNombre9.setText(precio[8]);
        tvNombre10.setText(precio[9]);
        //endregion

        //region Valores Tipo
        tvTipo1.setText(tipo[0]);
        tvTipo2.setText(tipo[1]);
        tvTipo3.setText(tipo[2]);
        tvTipo4.setText(tipo[3]);
        tvTipo5.setText(tipo[4]);
        tvTipo6.setText(tipo[5]);
        tvTipo7.setText(tipo[6]);
        tvTipo8.setText(tipo[7]);
        tvTipo9.setText(tipo[8]);
        tvTipo10.setText(tipo[9]);
        //endregion

    }

// region Codigo del Adapter
//        public class CustomAdapter extends BaseAdapter{
//
//        @Override
//        public int getCount() {
//            return img.length;
//        }
//
//        @Override
//        public Object getItem(int position) {
//            return null;
//        }
//
//        @Override
//        public long getItemId(int position) {
//            return 0;
//        }
//
//        @Override
//        public View getView(int position, View convertView, ViewGroup parent) {
//            convertView = getLayoutInflater().inflate(R.layout.customlayout,null);
//
//            ImageView ivHotelList = (ImageView) convertView.findViewById(R.id.ivHotelList);
//            TextView tvNombreListHotel = (TextView) convertView.findViewById(R.id.tvNombreListHotel);
//            TextView tvDescListHotel = (TextView) convertView.findViewById(R.id.tvDescListHotel);
//
//            ivHotelList.setImageResource(img[position]);
//            tvNombreListHotel.setText(name[position]);
//            tvDescListHotel.setText(prov[position]);
//
//            return convertView;
//        }
//    }
//endregion
}
