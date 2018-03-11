package com.example.pablokoyoc.estacionamiento4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;

public class NuevaIncidencia extends AppCompatActivity {

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
        spinner1 = (Spinner)findViewById(R.id.spn_prioridad);
        spinner2 = (Spinner)findViewById(R.id.spn_categoria);

        String [] opciones = {"Prioridad","Alta","Media","Baja"};
        String [] categorias = {"Categoría","Mobilario","Estacionamiento"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_item_prioridad, opciones);
        spinner1.setAdapter(adapter);

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
            Toast.makeText(this, "Se guardo correctamente los datos", Toast.LENGTH_LONG).show();
            //regresar(view);
        }
    }

    public void regresar(View view){
        Intent menuIncidencia = new Intent(this,MenuIncidencia.class);
        startActivity(menuIncidencia);
    }
}
