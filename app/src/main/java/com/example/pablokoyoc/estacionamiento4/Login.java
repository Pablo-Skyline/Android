package com.example.pablokoyoc.estacionamiento4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import modelo.*;

public class Login extends AppCompatActivity {

    private static final String url="jdbc:mysql://192.168.43.100/";
    private EditText etUsuario, etContrasena;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsuario = (EditText)findViewById(R.id.txt_usuario);
        etContrasena = (EditText)findViewById(R.id.txt_contraseña);;
    }

    public boolean conectarMYSQL(){
        boolean estadoConexión= false;
        Connection conexionMySQL = null;

        String usuario = etUsuario.getText().toString();
        String contraseña = etContrasena.getText().toString();

        String driver = "com.mysql.jdbc.Driver";

        return estadoConexión;
    }

    public void Registrar(View view){
        String usuario = etUsuario.getText().toString();
        String contraseña = etContrasena.getText().toString();

        if (usuario.length() == 0){
            Toast.makeText(this, "Debes de ingresar un nombre", Toast.LENGTH_LONG).show();
        } else if (contraseña.length() == 0){
            Toast.makeText(this, "Debes de ingresar una contraseña", Toast.LENGTH_SHORT).show();
        } else if (usuario.length() != 0 && contraseña.length() != 0){
            Toast.makeText(this, "Inicio en proceso...", Toast.LENGTH_SHORT).show();
            //Usuario(view);
        }
    }

    public void login(View view){
        Intent siguiente = new Intent(this,MenuIncidencia.class);
        startActivity(siguiente);
    }
}
