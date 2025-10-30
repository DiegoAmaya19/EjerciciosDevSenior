package com.damaya.even.Model.Entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Entity
@AllArgsConstructor
@Builder
@Table(name = "participantes")
public class ParticipantesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, name = "nombre")
    private String nombre;

    @Column(nullable = false, name = "username")
    private String userName;

    @Column(nullable = false, name = "password")
    private String passWord;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "asistente_evento", // Nombre de la tabla intermedia
        joinColumns = @JoinColumn(name = "asistente_id"), // Columna de esta entidad en la tabla intermedia
        inverseJoinColumns = @JoinColumn(name = "evento_id") // Columna de la otra entidad en la tabla intermedia
    )
    private Set<EventoEntity> evento;
}