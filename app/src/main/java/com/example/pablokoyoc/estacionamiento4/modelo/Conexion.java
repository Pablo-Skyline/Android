package com.example.pablokoyoc.estacionamiento4.modelo;

/**
 * Created by KOYOC on 13/03/2018.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Conexion {
    private static final String url="//192.168.43.100/conexionBD";

    /**
     * Dirección IP de genymotion o AVD
     */
    private static final String IP = "192.168.43.100";

    /**
     * URLs del Web Service
     */
    public static final String GET = "http://" + IP + "/conexionBD/Mostrar.php";
    public static final String INSERT = "http://" + IP + "/conexionBD/Insertar.php";
}
