package com.company.profesor;

public class ProfeTitular extends  Profesor{
    private String especialidad;

    public ProfeTitular(String nombre, String apellido, Integer codigoProfe, String especialidad) {
        super(nombre, apellido, codigoProfe);
        this.especialidad = especialidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }
}
