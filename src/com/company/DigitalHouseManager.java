package com.company;

import com.company.profesor.ProfeAdjunto;
import com.company.profesor.ProfeTitular;
import com.company.profesor.Profesor;
import sun.util.resources.cldr.om.CurrencyNames_om;

import java.util.ArrayList;
import java.util.List;

public class DigitalHouseManager {
    private List<Alumno> listaAlumnos;
    private List<Profesor> listaProfes;
    private List<Curso> listaCursos;
    private List<Inscripcion> listaInscripciones;

    public DigitalHouseManager() {
        this.listaAlumnos = new ArrayList<>();
        this.listaProfes = new ArrayList<>();
        this.listaCursos = new ArrayList<>();
        this.listaInscripciones = new ArrayList<>();
    }

    public void darAltaCurso(String nombre, Integer codigoCurso, Integer cupoMaximoAlumnos) {

        Curso unCurso = new Curso(nombre, codigoCurso, cupoMaximoAlumnos);
        if (!(listaCursos.contains(unCurso))) {
            listaCursos.add(unCurso);
        } else {
            System.out.println("El curso " + unCurso.getNombre() + " que intenta crear ya existe.");
        }
    }

    public void darBajaCurso(Integer codigoCurso) {
        Curso cursoTempo = null;
        List<Curso> listaCursosQueMeQuedan = new ArrayList<>();
        for (Curso unCurso : listaCursos) {
            if (unCurso.getCodigoCurso().equals(codigoCurso)) {
                cursoTempo = unCurso;
            }
            if (!(unCurso.getCodigoCurso().equals(codigoCurso))) {
                listaCursosQueMeQuedan.add(unCurso);

            }
        }

        listaCursos = listaCursosQueMeQuedan;

        if (cursoTempo == null) {
            System.out.println("El curso que paso por parametro no se encuentra en la lista," +
                    " no se ha dado de baja.");
        } else {
            System.out.println("Se dio de baja satisfactoriamente el curso: " + cursoTempo.getNombre() + " codigo curso: "
                    + cursoTempo.getCodigoCurso());
        }
    }

    public void darAltaProfeAdjunto(String nombre, String apellido, Integer codigoProfe, Integer cantidadHoras) {
        ProfeAdjunto unProfeAdjunto = new ProfeAdjunto(nombre, apellido, codigoProfe, cantidadHoras);
        if (!(listaProfes.contains(unProfeAdjunto))) {
            listaProfes.add(unProfeAdjunto);
            System.out.println("Se dio de alta al profesor Adjunto " + unProfeAdjunto.getApellido() +
                    " con el codigo profesor: " + unProfeAdjunto.getCodigoProfe());
        } else {
            System.out.println("No se pudo dar de alta al profesor Adjunto " + unProfeAdjunto.getApellido() +
                    " con el codigo profesor: " + unProfeAdjunto.getCodigoProfe());
        }
    }

    public void darAltaProfeTitular(String nombre, String apellido, Integer codigoProfe, String especialidad) {
        ProfeTitular unProfeTitular = new ProfeTitular(nombre, apellido, codigoProfe, especialidad);
        if (!(listaProfes.contains(unProfeTitular))) {
            listaProfes.add(unProfeTitular);
            System.out.println("Se dio de alta al profesor Titular " + unProfeTitular.getApellido() +
                    " con el codigo profesor: " + unProfeTitular.getCodigoProfe());
        } else {
            System.out.println("No se pudo dar de alta al profesor Titular " + unProfeTitular.getApellido() +
                    " con el codigo profesor: " + unProfeTitular.getCodigoProfe());
        }
    }

    public void darBajaProfesor(Integer codigoProfe) {
        List<Profesor> listaProfesQueQuedan = new ArrayList<>();
        Profesor profeTempo = null;
        for (Profesor unProfe : listaProfes) {
            if (unProfe.getCodigoProfe().equals(codigoProfe)) {
                profeTempo = unProfe;
            }
            if (!(unProfe.getCodigoProfe().equals(codigoProfe))) {
                listaProfesQueQuedan.add(unProfe);
            }
        }
        listaProfes = listaProfesQueQuedan;

        if (profeTempo == null) {
            System.out.println("No se pudo dar de baja al profesor con el codigo " + codigoProfe +
                    " ya que no se encuentra en la lista.");
        } else {
            System.out.println("Se ha dado de baja satisfactoriamente al profesor " +
                    profeTempo.getApellido() + " su codigo de profesor es " + profeTempo.getCodigoProfe());
        }


    }

    public void darAltaAlumno(String nombre, String apellido, Integer codigoAlumno) {
        Alumno unAlumno = new Alumno(codigoAlumno, nombre, apellido);
        if (!(listaAlumnos.contains(unAlumno))) {
            listaAlumnos.add(unAlumno);
            System.out.println("Se dio de alta al alumno " + unAlumno.getApellido() +
                    ". El codigo del alumno es: " + unAlumno.getCodigoAlumno());
        } else {
            System.out.println("El alumno " + nombre + " " + apellido + " con el codigo de alumno " +
                    codigoAlumno + " que quiere dar de alta ya se encuentra en la lista de alumnos.");
        }
    }

    public void darAltaListaAlumnos(List<Alumno> listaAlumnos){
        for(Alumno unAlumno : listaAlumnos){
            darAltaAlumno(unAlumno.getNombre(), unAlumno.getApellido(), unAlumno.getCodigoAlumno());
        }
    }

    public void darBajaAlumnoDeCurso(Integer codigoAlumno, Integer codigoCurso) {
        List<Alumno> alumnosQueQuedan = new ArrayList<>();
        Curso cursoTempo = null;
        Alumno alumnoTempo = null;

        //busca el curso
        for (Curso unCurso : listaCursos) {
            if (codigoCurso.equals(unCurso.getCodigoCurso())) {
                cursoTempo = unCurso;
                break;
            }
        }
        if (cursoTempo == null) {
            System.out.println("No se pudo encontrar el curso, escribio mal el codigo o ya no se encuentra disponible.");

        }
//busca el alumno
        for (Alumno unAlumno : listaAlumnos) {
            if (unAlumno.getCodigoAlumno().equals(codigoAlumno)) {
                alumnoTempo = unAlumno;
                break;
            }
        }

        List<Inscripcion> inscripcionesQuequedan = new ArrayList<>();
        for (Inscripcion unaInscripcion : listaInscripciones) {
            if (!(unaInscripcion.getUnAlumno().getCodigoAlumno().equals(alumnoTempo.getCodigoAlumno()) &&
                    unaInscripcion.getUnCurso().getCodigoCurso().equals(cursoTempo.getCodigoCurso()))) {
                inscripcionesQuequedan.add(unaInscripcion);

            }
        }
        listaInscripciones = inscripcionesQuequedan;

        if (alumnoTempo == null) {
            System.out.println("No se pudo dar de baja al alumno, no se encuentra en la lista o escribio mal el codigo");
        }
        if (alumnoTempo != null & cursoTempo != null) {
            cursoTempo.eliminarAlumno(alumnoTempo);
            System.out.println("Se dio de baja satisfactoriamente al alumno " + alumnoTempo.getApellido() +
                    " del curso " + cursoTempo.getNombre());
        }
    }


    public void inscribirAlumno(Integer codigoAlumno, Integer codigoCurso) {
        boolean encontroAlumno = false;
        Alumno alumnoTempo = null;
        Curso cursoTempo = null;
        boolean encontroCurso = false;
        for (Alumno unAlumno : listaAlumnos) {
            if (codigoAlumno.equals(unAlumno.getCodigoAlumno())) {
                alumnoTempo = unAlumno;
                encontroAlumno = true;
                break;
            }
        }
        if (encontroAlumno == false) {
            System.out.println("El alumno que esta intentando inscribir con el codigo "
                    + codigoAlumno + " no se ha dado nunca de alta.");
        }
        for (Curso unCurso : listaCursos) {
            if (codigoCurso.equals(unCurso.getCodigoCurso())) {
                cursoTempo = unCurso;
                encontroCurso = true;
                break;
            }
        }
        if (encontroCurso == false) {
            System.out.println("El curso con el codigo " + codigoCurso + " en el que esta intentando inscribir al alumno " +
                    "no se dio de alta, o lo dieron de baja.");
        }

        if (alumnoTempo != null && cursoTempo != null) {
            Inscripcion unaInscripcion = new Inscripcion(alumnoTempo, cursoTempo, "13 abril 2018");
            listaInscripciones.add(unaInscripcion);
            cursoTempo.agregarUnAlumno(alumnoTempo);
        }

    }

    public void inscribirListaAlumnos(List<Alumno> listAlumnos, Integer codigoCurso) {

        for (Alumno unAlumno : listAlumnos) {
            inscribirAlumno(unAlumno.getCodigoAlumno(), codigoCurso);
        }

    }


    public void asignarProfesores(Integer codigoCurso, Integer codigoProfeTitular, Integer codigoProfeAdjunto) {
        Curso cursoTempo = null;
        boolean asignoTitular = false;
        boolean asignoAdjunto = false;
        for (Curso unCurso : listaCursos) {
            if (codigoCurso.equals(unCurso.getCodigoCurso())) {
                cursoTempo = unCurso;
                break;
            }
        }

        if (cursoTempo == null) {
            System.out.println("El curso con el codigo " + codigoCurso + " en el que esta intentando asignar profesores " +
                    "nunca se dio de alta");
        }


        for (Profesor unProfeTitular : listaProfes) {
            if (codigoProfeTitular.equals(unProfeTitular.getCodigoProfe())) {
                //asumo que si o si me van a pasar un profe titular
                cursoTempo.setProfeTitular((ProfeTitular) unProfeTitular);
                System.out.println("Se asigno al profesor " + unProfeTitular.getApellido() + " al curso " + cursoTempo.getNombre());
                asignoTitular = true;
                break;
            }
        }
        if (asignoTitular == false) {
            System.out.println("No se encontro el profesor titular con el codigo " + codigoProfeTitular);
        }

        for (Profesor unProfeAdjunto : listaProfes) {
            if (codigoProfeAdjunto.equals(unProfeAdjunto.getCodigoProfe())) {
                //asumo que si o si me van a pasar un  profe adjunto
                cursoTempo.setProfeAdjunto((ProfeAdjunto) unProfeAdjunto);
                System.out.println("Se asigno al profesor " + unProfeAdjunto.getApellido() + " al curso " + cursoTempo.getNombre());
                asignoAdjunto = true;
                break;
            }
        }

        if (asignoAdjunto == false) {
            System.out.println("No se encontro el profesor adjunto con el codigo " + codigoProfeAdjunto);
        }


    }


}
