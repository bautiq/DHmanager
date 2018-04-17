package com.company;

public class Inscripcion {
    private Alumno unAlumno;
    private Curso unCurso;
    private String fechaInscripcion;

    public Inscripcion(Alumno unAlumno, Curso unCurso, String fechaInscripcion) {
        this.unAlumno = unAlumno;
        this.unCurso = unCurso;
        this.fechaInscripcion = fechaInscripcion;
    }

    public Alumno getUnAlumno() {
        return unAlumno;
    }

    public Curso getUnCurso() {
        return unCurso;
    }
}
