package com.example.ticobooking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


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
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String clave=et2.getText().toString();
        String usuario=et1.getText().toString();
        Cursor user = bd.rawQuery("select email, pass from usuarios where email='"+usuario+"'", null);

        if(usuario.length()==0){
            Toast notification=Toast.makeText(this, "El usuario no puede estar vacío.", Toast.LENGTH_LONG);
            notification.show();
        }else if(clave.length()==0){
            Toast notification=Toast.makeText(this, "La clave no puede estar vacía.", Toast.LENGTH_LONG);
            notification.show();
        }else{
            if(user.moveToFirst()){
                if(!clave.equals(user.getString(1))){
                    Toast notification=Toast.makeText(this, "Su correo o contraseña no son correctos.", Toast.LENGTH_LONG);
                    notification.show();
                }else if(!usuario.equals(user.getString(0))){
                    Toast notification = Toast.makeText(this, "Su correo o contraseña no son correctos.", Toast.LENGTH_LONG);
                    notification.show();
                }else if(usuario.equals(user.getString(0)) && (clave.equals(user.getString(1)))){
                    Intent i = new Intent(this, Servicios.class);
                    i.putExtra("nombre", usuario);
                    startActivity(i);
                }
            }else{
                Toast.makeText(this, "No existe un usuario con dichas credenciales", Toast.LENGTH_SHORT).show();
            }
        }
        bd.close();
    }

    public void crearcuenta(View v){
        Intent i = new Intent(this, Registro.class);
        startActivity(i);
    }
}
