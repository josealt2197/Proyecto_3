package com.example.ticobooking;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;


/*__________________________________INTERFAZ PARA ACCERDER A DISTINTOS METODOS___________________________*/

/**
 * Created by DavidGam on 29/11/16.
 */
public interface RequestFactory {

    public StringRequest getRequest(Response.Listener<String> responseListener,
                                    Response.ErrorListener errorListener);

}
