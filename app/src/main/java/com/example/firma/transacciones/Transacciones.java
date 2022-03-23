package com.example.firma.transacciones;

public class Transacciones {
    /*TABLA*/
    public static final String tabla_firmas = "tabla_firmas";


    /*CAMPOS*/
    public static final String id = "id";
    public static final String imagen = "imagen";
    public static final String descripcion = "descripcion";


    /* tablas - CREATE , DROP */
    public static final String CreateTableFirmas= "CREATE TABLE tabla_firmas" +
            "(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "imagen BLOB, " +
            "descripcion TEXT)";

    public static final String DropTableFirmas= "DROP TABLE IF EXISTS tabla_firmas";


    /* Creacion del nombre de la base de datos */
    public static final String NameDataBase = "DB_prueba";
}
