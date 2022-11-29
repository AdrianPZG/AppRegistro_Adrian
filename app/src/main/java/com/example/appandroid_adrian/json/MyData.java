package com.example.appandroid_adrian.json;

import java.io.Serializable;

public class MyData  implements Serializable {

    private String contra;
    private int image;
    private String usuario;
    private String email;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = usuario;
    }


}
