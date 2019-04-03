package com.example.ticobooking;

import com.android.volley.DefaultRetryPolicy;

/*__________________________________ESPERA EN MILISEGUNDOS EN CONEXION Y VECES DE INTENTOS___________________________*/

/**
 * Created by DavidGam on 29/11/16.
 */
public class LongTimeoutAndTryRetryPolicy extends DefaultRetryPolicy {

    public static final int TIMEOUT_MS = 2000;
    public static final int RETRIES_PHONE_ISP = 3;

    public LongTimeoutAndTryRetryPolicy(int retries) {
        super(TIMEOUT_MS, retries, DEFAULT_BACKOFF_MULT);
    }
}