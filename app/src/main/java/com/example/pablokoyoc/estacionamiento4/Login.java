package com.example.pablokoyoc.estacionamiento4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;
import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Login extends AppCompatActivity {

    private static final String url="jdbc:mysql://192.168.43.100/";
    private EditText etUsuario, etContrasena;
    private Button btnIniciar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsuario = (EditText)findViewById(R.id.txt_usuario);
        etContrasena = (EditText)findViewById(R.id.txt_contraseña);

        btnIniciar = (Button)findViewById(R.id.btn_iniciar);
        btnIniciar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Thread tr = new Thread(){
                    @Override
                    public void run() {
                        final String res = enviarDatosGET(etUsuario.getText().toString(),etContrasena.getText().toString());
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                int r = objJSON(res);
                                if (r>0){
                                    Intent i = new Intent(getApplicationContext(),MenuIncidencia.class);
                                    startActivity(i);
                                } else {
                                    Toast.makeText(getApplicationContext(),"El usuario o la contraseña son incorrectos",Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                    }
                };
                tr.start();
            }
        });
    }

    public String enviarDatosGET(String user, String password){

        String inserccion = "user="+user+"&password="+password;
        HttpURLConnection connection = null;
        String respuesta = "";

        try {
            URL url = new URL("http://192.168.0.15/WebService/valida.php?");
            connection = (HttpURLConnection)url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Length",""+Integer.toString(inserccion.getBytes().length));

            connection.setDoOutput(true);
            DataOutputStream dop = new DataOutputStream(connection.getOutputStream());
            dop.writeBytes(inserccion);
            dop.close();

            Scanner inStream = new Scanner(connection.getInputStream());

            while (inStream.hasNextLine())
                respuesta+=(inStream.nextLine());
        } catch (Exception e){

        }

        return respuesta.toString();
    }

    public int objJSON(String respuesta){
        int res = 0;
        try {
            JSONArray json = new JSONArray(respuesta);
            if (json.length()>0)
                res=1;
        } catch (Exception e) {

        }
        return res;
    }
}
