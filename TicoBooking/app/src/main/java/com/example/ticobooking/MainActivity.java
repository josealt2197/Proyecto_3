package com.example.ticobooking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText et1, et2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1=(EditText)findViewById(R.id.et1);
        et2=(EditText)findViewById(R.id.et2);
    }

    public void verificar(View v){
        String clave=et2.getText().toString();
        String usuario=et1.getText().toString();
        if(clave.length()==0){
            Toast notification=Toast.makeText(this, "La clave no puede estar vacía.", Toast.LENGTH_LONG);
            notification.show();
        }else if(usuario.length()==0){
            Toast notification=Toast.makeText(this, "El usuario no puede estar vacío.", Toast.LENGTH_LONG);
            notification.show();
        }else if(!clave.equals("pass1234")){
            Toast notification=Toast.makeText(this, "La clave es incorrecta.", Toast.LENGTH_LONG);
            notification.show();
        }else{
            Toast notification = Toast.makeText(this, "La clave es correcta.", Toast.LENGTH_LONG);
            notification.show();
            Intent i = new Intent(this, Servicios.class);
            i.putExtra("nombre", usuario);
            startActivity(i);
        }
    }
}
