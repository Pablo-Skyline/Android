package com.example.pablokoyoc.estacionamiento4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Login extends AppCompatActivity {

    private static final String url="jdbc:mysql://192.168.43.100/";
    private EditText etUsuario, etContrasena;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsuario = (EditText)findViewById(R.id.txt_usuario);
        etContrasena = (EditText)findViewById(R.id.txt_contraseña);
    }

    public String enviarDatosGET(String user, String password){
        URL url = null;
        String linea = "";
        int respuesta = 0;
        StringBuilder result = null;

        try {
            url = new URL("http://192.168.0.15/WebService/valida.php?user="+user+"&password="+password);
            HttpURLConnection conexion = (HttpURLConnection)url.openConnection();
            respuesta = conexion.getResponseCode();

            result = new StringBuilder();

            if(respuesta==HttpURLConnection.HTTP_OK){
                InputStream in = new BufferedInputStream(conexion.getInputStream());
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));

                while((linea=reader.readLine())!=null){
                    result.append(linea);
                }
            }
        } catch (Exception e){

        }

        return result.toString();
    }

    public void accesoDatos(View view){
        if(enviarDatosGET(etUsuario.toString(),etContrasena.toString())!=""){
            Intent siguiente = new Intent( this,MenuIncidencia.class);
            startActivity(siguiente);
        } else {
            Toast.makeText(this,"El usuario o la contraseña son incorrectos",Toast.LENGTH_LONG).show();
        }
    }
}
