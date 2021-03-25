package ru.iu3.rpo.backend.models;

import javax.persistence.*;

@Entity
@Table(name="museums")
@Access(AccessType.FIELD)
public class Museum {
    public Museum() {}
    public Museum(Long id) {this.id=id;}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", updatable = false, nullable = false)
    public long id;

    @Column(name="name")
    public String name;

    @Column(name="location")
    public String location;
}
