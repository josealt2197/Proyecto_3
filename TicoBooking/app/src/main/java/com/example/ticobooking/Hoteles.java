package com.example.ticobooking;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


public class Hoteles extends Fragment {

    private ListView lv;
    private int []img={R.mipmap.bg_masthead, R.mipmap.bg_masthead2, R.mipmap.bg_masthead3, R.mipmap.bg_masthead, R.mipmap.bg_masthead};
    private String []name={"Hotel 1","Hotel 2", "Hotel 3", "Hotel 4", "Hotel 5"};
    private String []desc={"Desc1", "Desc2","Desc3","Desc4","Desc5"};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hoteles, container, false);
        lv= (ListView) view.findViewById(R.id.lvHoteles);

        CustomAdapter customAdapter = new CustomAdapter();
        lv.setAdapter(customAdapter);
        // Inflate the layout for this fragment
        return view;
    }

    class CustomAdapter extends BaseAdapter{

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
