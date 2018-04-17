package com.company.profesor;

public class Profesor {
    protected String nombre;
    protected String apellido;
    protected Integer antiguedadAños;
    protected Integer codigoProfe;

    public Profesor(String nombre, String apellido, Integer codigoProfe) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.codigoProfe = codigoProfe;
        antiguedadAños = 0;
    }

    public void setAntiguedadAños(Integer antiguedadAños) {
        this.antiguedadAños = antiguedadAños;
    }

    public void setCodigoProfe(Integer codigoProfe) {
        this.codigoProfe = codigoProfe;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public Integer getAntiguedadAños() {
        return antiguedadAños;
    }

    public Integer getCodigoProfe() {
        return codigoProfe;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Profesor)){
            return false;
        } else{
            Profesor profeAcomparar = (Profesor) obj;
            return codigoProfe.equals(profeAcomparar.getCodigoProfe());
        }
    }
}
