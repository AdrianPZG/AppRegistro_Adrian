package com.example.appregistro_adrianpg.JSON;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MyInfo  implements Serializable {

    private String Correo;
    private String Contraseña;
    private String Nombre;
    private List<MyData> contras = new ArrayList<>();

    public List<MyData> getContras() {
        return contras;
    }

    public void setContras(List<MyData> contras) {
        this.contras = contras;
    }


    public String getCorreo() { return Correo; }

    public void setCorreo(String correo) { Correo = correo; }

    public String getContraseña() { return Contraseña; }

    public void setContraseña(String contraseña) { Contraseña = contraseña; }

    public String getNombre() { return Nombre; }

    public void setNombre(String nombre) { Nombre = nombre; }

    public MyInfo(){

    }
}
