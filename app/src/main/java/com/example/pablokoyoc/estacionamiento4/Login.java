package com.example.pablokoyoc.estacionamiento4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    private EditText etu, etc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void Registrar(View view){
        String usuario = etu.getText().toString();
        String contraseña = etc.getText().toString();

        if (usuario.length() == 0){
            Toast.makeText(this, "Debes de ingresar un nombre", Toast.LENGTH_LONG).show();
        } else if (contraseña.length() == 0){
            Toast.makeText(this, "Debes de ingresar una contraseña", Toast.LENGTH_SHORT).show();
        } else if (usuario.length() != 0 && contraseña.length() != 0){
            Toast.makeText(this, "Inicio en proceso...", Toast.LENGTH_SHORT).show();
            //login(view);
        }
    }

    public void login(View view){
        Intent siguiente = new Intent(this,MenuIncidencia.class);
        startActivity(siguiente);
    }
}
