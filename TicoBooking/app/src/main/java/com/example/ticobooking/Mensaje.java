package com.example.ticobooking;

import com.google.gson.annotations.SerializedName;

public class Mensaje {

    @SerializedName("NombreHos")
    private String nombreHos;

    @SerializedName("Tipo")
    private String tipo;

    @SerializedName("CantidadHuespedes")
    private int cantidad;

    @SerializedName("ProvinciaHos")
    private String provincia;

    @SerializedName("Precio")
    private int precio;

    public String getNombreHos() {
        return nombreHos;
    }

    public void setNombreHos(String nombreHos) {
        this.nombreHos = nombreHos;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
}
