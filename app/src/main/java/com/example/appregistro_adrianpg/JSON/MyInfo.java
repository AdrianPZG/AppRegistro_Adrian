package com.example.appregistro_adrianpg.JSON;

import java.io.Serializable;

public class MyInfo  implements Serializable {

    private String Correo;
    private String Contraseña;
    private String Nombre;

    public String getCorreo() { return Correo; }

    public void setCorreo(String correo) { Correo = correo; }

    public String getContraseña() { return Contraseña; }

    public void setContraseña(String contraseña) { Contraseña = contraseña; }

    public String getNombre() { return Nombre; }

    public void setNombre(String nombre) { Nombre = nombre; }

    public MyInfo(){

    }
}
