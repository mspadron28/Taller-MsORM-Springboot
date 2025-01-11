package com.espe.cursos.model.entities;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="Cursos")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    //Especificar como esta en la base de datos pero en programación se coloca nombre
    //@Column(name="name")
    @Column(nullable=false)
    private String nombre;
    @Column(nullable=false)
    private String descripcion;
    @Column(nullable=false)
    private int creditos;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, updatable = false)
    private Date creadoEn;

    @ManyToMany
    @JoinTable(
            name = "curso_estudiante",
            joinColumns = @JoinColumn(name = "curso_id"),
            inverseJoinColumns = @JoinColumn(name = "estudiante_id")
    )
    private List<Estudiante> estudiantes;

    // Getters y Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public Date getCreadoEn() {return creadoEn;}

    @PrePersist
    protected void onCreate() {
        this.creadoEn = new Date();
    }

    public List<Estudiante> getEstudiantes() {return estudiantes;}

    public void setEstudiantes(List<Estudiante> estudiantes) {this.estudiantes = estudiantes;}



}
