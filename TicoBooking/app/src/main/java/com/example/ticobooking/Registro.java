package com.example.ticobooking;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.content.ContentValues;
import android.widget.Toast;

public class Registro extends AppCompatActivity {

    private EditText edtCedula, edtNombre, edtApellidos, edtTelefono, edtCorreo, edtFechaNacimiento, edtPass, edtRePass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        edtCedula = (EditText)findViewById(R.id.edtCedula);
        edtNombre = (EditText)findViewById(R.id.edtNombre);
        edtApellidos = (EditText)findViewById(R.id.edtApellidos);
        edtTelefono = (EditText)findViewById(R.id.edtTelefono);
        edtCorreo = (EditText)findViewById(R.id.edtCorreo);
        edtFechaNacimiento = (EditText)findViewById(R.id.edtFechaNacimiento);
        edtPass = (EditText)findViewById(R.id.edtPass);
        edtRePass = (EditText)findViewById(R.id.edtRePass);
    }

    public void registrousuario(View view) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String ced = edtCedula.getText().toString();
        String nom = edtNombre.getText().toString();
        String ape = edtApellidos.getText().toString();
        String tel = edtTelefono.getText().toString();
        String mail = edtCorreo.getText().toString();
        String date = edtFechaNacimiento.getText().toString();
        String pass = edtPass.getText().toString();

        ContentValues registro = new ContentValues();
        registro.put("cedula", ced);
        registro.put("nombre", nom);
        registro.put("apellidos", ape);
        registro.put("telefono", tel);
        registro.put("email", mail);
        registro.put("fechanac", date);
        registro.put("pass", pass);
        bd.insert("usuarios", null, registro);
        bd.close();
        edtCedula.setText("");
        edtNombre.setText("");
        edtApellidos.setText("");
        edtTelefono.setText("");
        edtCorreo.setText("");
        edtFechaNacimiento.setText("");
        edtPass.setText("");
        edtRePass.setText("");
        Toast.makeText(this, "Su cuenta ha sido creada correctmente.", Toast.LENGTH_SHORT).show();
    }
}
