package ar.com.ada.api.cursos.entities;

import java.util.*;

import javax.persistence.*;


@Entity
@Table(name = "curso")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "curso_id")
    private Integer id;

    private String nombre;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_inicio")
    private Date fechaInicio;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_finalizacion")
    private Date fechaFinalizacion;

    
    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Alumno> alumnos = new ArrayList<>();

    public void agregarAlumno(Alumno alumno){
        this.alumnos.add(alumno);
        //alumno.setCurso(this);
    }
    
    public List<Alumno> getAlumnos() {
        return alumnos;
    }
    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Date getFechaInicio() {
        return fechaInicio;
    }
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
    public Date getFechaFinalizacion() {
        return fechaFinalizacion;
    }
    public void setFechaFinalizacion(Date fechaFinalizacion) {
        this.fechaFinalizacion = fechaFinalizacion;
    }


    

    

    
}
