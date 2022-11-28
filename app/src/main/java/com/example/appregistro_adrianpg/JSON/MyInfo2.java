package com.example.appregistro_adrianpg.JSON;

import java.io.Serializable;

public class MyInfo2  implements Serializable {

    private String contra;
    private int image;
    private String usuario;

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
}
