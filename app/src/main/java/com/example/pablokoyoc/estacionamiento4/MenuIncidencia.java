package com.example.pablokoyoc.estacionamiento4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MenuIncidencia extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_incidencia);
    }


    public void nuevaIncidencia(View view){
        Intent newIncidencia = new Intent(this,NuevaIncidencia.class);
        startActivity(newIncidencia);
    }
}
