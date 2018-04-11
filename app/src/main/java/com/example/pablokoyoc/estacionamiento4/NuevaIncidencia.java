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

        // Obtener valores actuales de los controles
        /*final String titulo = titulo_input.getText().toString();
        final String descripcion = descripcion_input.getText().toString();
        final String fecha = fecha_text.getText().toString();
        final String categoria = categoria_spinner.getSelectedItem().toString();
        final String prioridad = prioridad_spinner.getSelectedItem().toString();

        HashMap<String, String> map = new HashMap<>();// Mapeo previo

        map.put("titulo", titulo);
        map.put("descripcion", descripcion);
        map.put("fechaLim", fecha);
        map.put("categoria", categoria);
        map.put("prioridad", prioridad);

        // Crear nuevo objeto Json basado en el mapa
        JSONObject jobject = new JSONObject(map);

        // Depurando objeto Json...
        Log.d(TAG, jobject.toString());

        // Actualizar datos en el servidor
        VolleySingleton.getInstance(getActivity()).addToRequestQueue(
                new JsonObjectRequest(
                        Request.Method.POST,
                        Constantes.INSERT,
                        jobject,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                // Procesar la respuesta del servidor
                                procesarRespuesta(response);
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Log.d(TAG, "Error Volley: " + error.getMessage());
                            }
                        }

                ) {
                    @Override
                    public Map<String, String> getHeaders() {
                        Map<String, String> headers = new HashMap<String, String>();
                        headers.put("Content-Type", "application/json; charset=utf-8");
                        headers.put("Accept", "application/json");
                        return headers;
                    }

                    @Override
                    public String getBodyContentType() {
                        return "application/json; charset=utf-8" + getParamsEncoding();
                    }
                }
        );
    */
    }
}
