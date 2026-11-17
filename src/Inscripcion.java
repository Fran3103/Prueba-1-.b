
public class Inscripcion {



    Integer Id;

    String Alumno;

    String Curso;

    String Estado;

    public Inscripcion(Integer id, String alumno, String curso, String estado) {
        Id = id;
        Alumno = alumno;
        Curso = curso;
        Estado = estado;
    }


    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }

    public String getCurso() {
        return Curso;
    }

    public void setCurso(String curso) {
        Curso = curso;
    }

    public String getAlumno() {
        return Alumno;
    }

    public void setAlumno(String alumno) {
        Alumno = alumno;
    }

    public Integer getId() {
        return Id;
    }

}
