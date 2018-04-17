package com.company;

public class Main {

    public static void main(String[] args) {

        DigitalHouseManager elManager = new DigitalHouseManager();

        elManager.darAltaProfeTitular("Nicolas", "Dubiansky", 1, "Android Mobile");
        elManager.darAltaProfeTitular("José", "Fermoso", 2, "Android Mobile");
        elManager.darAltaProfeAdjunto("Luis", "Diaz Muñiz", 3, 4);
        //le mande fruta el apellido jajaj
        elManager.darAltaProfeAdjunto("Clara", "Gonzalez", 4, 3);
        System.out.println(" ");

        elManager.darAltaCurso("Full Stack", 20001, 3);
        elManager.darAltaCurso("Android", 20002, 2);
        System.out.println(" ");

        elManager.asignarProfesores(20001, 2, 4);
        elManager.asignarProfesores(20002, 1, 3);
        System.out.println(" ");

        elManager.darAltaAlumno("Bautista", "Querejeta", 1);
        elManager.darAltaAlumno("Martin", "Kiper", 2);
        elManager.darAltaAlumno("Javier", "Torres", 3);
        elManager.darAltaAlumno("Fernando", "Causerano", 4);
        elManager.darAltaAlumno("Daniel", "Gonzalez", 5);
        System.out.println(" ");

        elManager.inscribirAlumno(1, 20002);
        elManager.inscribirAlumno(1, 20001);
        elManager.inscribirAlumno(2, 20002);
        elManager.inscribirAlumno(2, 20001);

        elManager.darBajaAlumnoDeCurso(1, 20002);
        elManager.inscribirAlumno(3, 20002);
        elManager.inscribirAlumno(4, 20002);
        elManager.inscribirAlumno(5, 20002);
        elManager.darBajaProfesor(4);
        elManager.darAltaCurso("Android mobile cupos Extendidos", 20003, 21);
        System.out.println(" ");
        LectorDeArchivosCSV lectorDeArchivosCSV = new LectorDeArchivosCSV();
        lectorDeArchivosCSV.leerCsv();

        // primero tengo que darlos de alta.
        elManager.darAltaListaAlumnos(lectorDeArchivosCSV.getListaAlumnos());
        System.out.println("  ");
        elManager.inscribirListaAlumnos(lectorDeArchivosCSV.getListaAlumnos(), 20003);




    }
}
