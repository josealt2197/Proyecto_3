package com.example.ticobooking;

import com.google.gson.annotations.SerializedName;

public class Mensaje {

    @SerializedName("Id")
    private int id;

    @SerializedName("NombreHos")
    private String nombreHos;

    @SerializedName("Tipo")
    private String tipo;

    @SerializedName("CantidadHuespedes")
    private int cantidad;

    @SerializedName("UbicacionExacta")
    private String ubicacionexacta;

    @SerializedName("ProvinciaHos")
    private String provincia;

    @SerializedName("ServiciosIncluidos")
    private String serviciosincluidos;

    @SerializedName("Precio")
    private int precio;

    @SerializedName("ImagenHos")
    private String imagenhos;

    @SerializedName("HoraEntradaHos")
    private String horaentrada;

    @SerializedName("HoraSalidaHos")
    private String horasalida;

    @SerializedName("DescripcionHos")
    private String descripcionhos;

    @SerializedName("ImagenDetail")
    private String imagendetail;

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

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

    public String getUbicacionexacta() { return ubicacionexacta; }

    public void setUbicacionexacta(String ubicacionexacta) { this.ubicacionexacta = ubicacionexacta; }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getServiciosincluidos() { return serviciosincluidos; }

    public void setServiciosincluidos(String serviciosincluidos) { this.serviciosincluidos = serviciosincluidos; }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getImagenhos() { return imagenhos; }

    public void setImagenhos(String imagenhos) { this.imagenhos = imagenhos; }

    public String getHoraentrada() { return horaentrada; }

    public void setHoraentrada(String horaentrada) { this.horaentrada = horaentrada; }

    public String getHorasalida() { return horasalida; }

    public void setHorasalida(String horasalida) { this.horasalida = horasalida; }

    public String getDescripcionhos() { return descripcionhos; }

    public void setDescripcionhos(String descripcionhos) { this.descripcionhos = descripcionhos; }

    public String getImagendetail() { return imagendetail; }

    public void setImagendetail(String imagendetail) { this.imagendetail = imagendetail; }
}
