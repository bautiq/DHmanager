package com.company;

import com.company.profesor.ProfeAdjunto;
import com.company.profesor.ProfeTitular;

import java.util.ArrayList;
import java.util.List;

public class Curso {
    private String nombre;
    private Integer codigoCurso;
    private ProfeTitular profeTitular;
    private ProfeAdjunto profeAdjunto;
    private Integer cupoMaximoAlumnos;
    private List<Alumno> inscriptos;

    public Curso(String nombre, Integer codigoCurso, Integer cupoMaximoAlumnos) {
        this.nombre = nombre;
        this.codigoCurso = codigoCurso;
        this.cupoMaximoAlumnos = cupoMaximoAlumnos;
        this.inscriptos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCodigoCurso() {
        return codigoCurso;
    }

    public void setCodigoCurso(Integer codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    public ProfeTitular getProfeTitular() {
        return profeTitular;
    }

    public void setProfeTitular(ProfeTitular profeTitular) {
        this.profeTitular = profeTitular;
    }

    public ProfeAdjunto getProfeAdjunto() {
        return profeAdjunto;
    }

    public void setProfeAdjunto(ProfeAdjunto profeAdjunto) {
        this.profeAdjunto = profeAdjunto;
    }

    public Integer getCupoMaximoAlumnos() {
        return cupoMaximoAlumnos;
    }

    public void setCupoMaximoAlumnos(Integer cupoMaximoAlumnos) {
        this.cupoMaximoAlumnos = cupoMaximoAlumnos;
    }

    public List<Alumno> getInscriptos() {
        return inscriptos;
    }

    public void setInscriptos(List<Alumno> inscriptos) {
        this.inscriptos = inscriptos;
    }

    public Boolean agregarUnAlumno(Alumno unAlumno) {
        if (inscriptos.size() < cupoMaximoAlumnos) {
            inscriptos.add(unAlumno);
            System.out.println("Se realizo la inscripcion del alumno " + unAlumno.getNombre() +
            " " + unAlumno.getApellido() + " al Curso " + nombre + ". El codigo del alumno es " + unAlumno.getCodigoAlumno());
            return true;
        } else {
            System.out.println("No quedan cupos disponibles en el curso " + nombre + ". No se agrego al alumno "
                    + unAlumno.getApellido() +
                    " con el codigo " + unAlumno.getCodigoAlumno());
            return false;
        }
    }

    public void eliminarAlumno(Alumno unAlumno){
        if(inscriptos.contains(unAlumno)){
            inscriptos.remove(unAlumno);
            //este sout es para chequear
          //  System.out.println("Se elimino satisfactoriamente al alumno "+ unAlumno.getNombre() +
            //        " " + unAlumno.getApellido() + " de la lista de Cursos el codigo del alumno es: " + unAlumno.getCodigoAlumno());
        } else{
            System.out.println("El alumno " + unAlumno.getApellido() + " con el codigo " + unAlumno.getCodigoAlumno() +
                    " no esta inscripto, no se elimino a nadie de la lista de Inscriptos");
        }
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Curso)){
            return false;
        } else{
            Curso cursoAcomparar = (Curso) obj;
            return codigoCurso.equals(cursoAcomparar.getCodigoCurso());
        }
    }
}
