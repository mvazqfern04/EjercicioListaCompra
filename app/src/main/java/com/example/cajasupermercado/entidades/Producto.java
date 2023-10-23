package com.example.cajasupermercado.entidades;

public class Producto {

    private String nombre;
    private Integer id, cantidad;
    private Double precio;
    private Integer cant_Actual;

    public Producto() {
    }

    public Producto(String nombre, Integer id, Integer cantidad, Double precio) {
        this.nombre = nombre;
        this.id = id;
        this.cantidad = cantidad;
        this.precio = precio;
        this.cant_Actual=cantidad;
    }

    @Override
    public String toString() {
        return "producto{" +
                "nombre='" + nombre + '\'' +
                ", id=" + id +
                ", cantidad=" + cantidad +
                ", precio=" + precio +
                ", cantidad_actual= "+cant_Actual+'}';
    }

    public boolean isLow(){
        return !(cantidad*0.25>=cant_Actual);
    }

    public Integer getCant_Actual() {
        return cant_Actual;
    }

    public void setCant_Actual(Integer cant_Actual) {
        this.cant_Actual = cant_Actual;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
}
