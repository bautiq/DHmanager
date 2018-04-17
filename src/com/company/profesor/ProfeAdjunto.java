package com.company.profesor;

public class ProfeAdjunto extends Profesor{
    private Integer horasDedicadasConsultas;

    public ProfeAdjunto(String nombre, String apellido, Integer codigoProfe, Integer horasDedicadasConsultas) {
        super(nombre, apellido, codigoProfe);
        this.horasDedicadasConsultas = horasDedicadasConsultas;
    }

    public Integer getHorasDedicadasConsultas() {
        return horasDedicadasConsultas;
    }

    public void setHorasDedicadasConsultas(Integer horasDedicadasConsultas) {
        this.horasDedicadasConsultas = horasDedicadasConsultas;
    }
}
