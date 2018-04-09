package com.example.pablokoyoc.estacionamiento4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pablokoyoc.estacionamiento4.modelo.Conexion;

import org.json.JSONObject;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class NuevaIncidencia extends AppCompatActivity {

    private static final String TAG = NuevaIncidencia.class.getSimpleName();
    private EditText et1;
    private EditText et2;
    private EditText et3;
    private TextView tv1;
    private Date date1;
    private TextView tv2;
    private Spinner spinner1;
    private Spinner spinner2;
    private ImageView imgView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nueva_incidencia);

        et1 = (EditText)findViewById(R.id.pt_titulo);
        et2 = (EditText)findViewById(R.id.date_fecha);
        et3 = (EditText)findViewById(R.id.mt_descripcion);
        spinner2 = (Spinner)findViewById(R.id.spn_categoria);

        String [] categorias = {"Categoría","Mobilario","Estacionamiento"};

        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, R.layout.spinner_item_categoria, categorias);
        spinner2.setAdapter(adapter2);
    }

    public void guardar(View view){
        if (et1.length() == 0){
            Toast.makeText(this, "Debes de ingresar un título", Toast.LENGTH_LONG).show();
        } else if (et2.length() == 0){
            Toast.makeText(this, "Debes de ingresar una fecha", Toast.LENGTH_LONG).show();
        } else if (et3.length() == 0){
            Toast.makeText(this, "Debes de ingresar un descripción", Toast.LENGTH_LONG).show();
        } else {
            final String titulo = et1.getText().toString();
            final String descripcion = et2.getText().toString();
            final String categoria = spinner2.getItemAtPosition(4).toString();

            HashMap<String, String> map = new HashMap<>();// Mapeo previo

            map.put("titulo", titulo);
            map.put("descripcion", descripcion);
            map.put("categoria", categoria);

            // Crear nuevo objeto Json basado en el mapa
            JSONObject jobject = new JSONObject(map);

            // Depurando objeto Json...
            Log.d(TAG, jobject.toString());

            Toast.makeText(this, "Se guardo correctamente los datos", Toast.LENGTH_LONG).show();
            //Conexion.INSERT.
        }
    }

    public void regresar(View view){
        Intent menuIncidencia = new Intent(this,MenuIncidencia.class);
        startActivity(menuIncidencia);
    }

    public void guardarMeta() {

    }
}
