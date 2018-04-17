package com.company;

public class Alumno {
    private String nombre;
    private String apellido;
    private Integer codigoAlumno;

    public Alumno(String[] args){
        this.nombre = args[1];
        this.apellido = args[2];
        this.codigoAlumno = Integer.valueOf(args[0]);
    }
    public Alumno(Integer codigoAlumno, String nombre, String apellido ){
        this.codigoAlumno = codigoAlumno;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public Integer getCodigoAlumno() {
        return codigoAlumno;
    }

    @Override
    public boolean equals(Object obj) {

        if(!(obj instanceof Alumno)){
            return false;
        } else{
            Alumno alumnoAcomparar = (Alumno) obj;
            return codigoAlumno.equals(alumnoAcomparar.getCodigoAlumno());
        }
    }
}
