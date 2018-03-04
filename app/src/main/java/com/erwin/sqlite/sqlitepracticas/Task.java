package com.erwin.sqlite.sqlitepracticas;

/**
 * Created by erwin on 3/4/2018.
 */

public class Task {
    public String id;
    public String nombre;
    public String descripcion;
    public String fecha;

    public Task(String id, String nombre, String descripcion, String fecha) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha = fecha;
    }
}
