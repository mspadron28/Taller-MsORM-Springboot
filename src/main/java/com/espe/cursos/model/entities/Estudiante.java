package com.espe.cursos.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Estudiantes")
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellido;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private Date fechaNacimiento;

    @Column(nullable = false)
    private String telefono;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, updatable = false)
    private Date creadoEn;

    @ManyToMany(mappedBy = "estudiantes")
    @JsonIgnore
    private List<Curso> cursos;

    // Getters y Setters
    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public String getNombre() {return nombre;}

    public void setNombre(String nombre) {this.nombre = nombre;}

    public String getApellido() {return apellido;}

    public void setApellido(String apellido) {this.apellido = apellido;}

    public String getEmail() {return email;}

    public void setEmail(String email) {this.email = email;}

    public Date getFechaNacimiento() {return fechaNacimiento;}

    public void setFechaNacimiento(Date fechaNacimiento) {this.fechaNacimiento = fechaNacimiento;}

    public String getTelefono() {return telefono;}

    public void setTelefono(String telefono) {this.telefono = telefono;}

    public Date getCreadoEn() {return creadoEn;}

    @PrePersist
    protected void onCreate() {
        this.creadoEn = new Date();
    }

    public List<Curso> getCursos() {return cursos;}

    public void setCursos(List<Curso> cursos) {this.cursos = cursos;}


}
