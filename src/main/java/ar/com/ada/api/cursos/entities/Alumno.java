package ar.com.ada.api.cursos.entities;

import java.util.*;

import javax.persistence.*;

@Entity
@Table(name = "alumnos")
public class Alumno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "alumnos_id")
    private Integer id;

    private String nombre;

    private String dni;

    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;

    @ManyToOne
    @JoinColumn(name = "curso_id", referencedColumnName = "curso_id")
    private Curso curso;

    @Column(name = "estado_id")
    private Integer estadoId;

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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
        this.curso.agregarAlumno(this);
    }

    public EstadoAlumnoEnum getEstadoId() {

        return EstadoAlumnoEnum.parse(this.estadoId);
    }

    public void setEstadoId(EstadoAlumnoEnum estadoId) {
        this.estadoId = estadoId.getValue();
    }

    public enum EstadoAlumnoEnum {
        SOLICITADO(1), ACTIVO(2), EGRESADO(3);

        private final int value;

        // NOTE: Enum constructor tiene que estar en privado
        private EstadoAlumnoEnum(int value) {
            this.value = value;
        }
        public int getValue() {
            return value;
        }

        public static EstadoAlumnoEnum parse(int id) {
            EstadoAlumnoEnum status = null; // Default
            for (EstadoAlumnoEnum item : EstadoAlumnoEnum.values()) {
                if (item.getValue() == id) {
                    status = item;
                    break;
                }
            }
            return status;
        }
    }

}
