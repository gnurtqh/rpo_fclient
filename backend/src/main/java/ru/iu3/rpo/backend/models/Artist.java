package ru.iu3.rpo.backend.models;

import javax.persistence.*;

@Entity
@Table(name="artists")
@Access(AccessType.FIELD)
public class Artist {
    public Artist() {}
    public Artist(Long id) {this.id=id;}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", updatable = false, nullable = false)
    public long id;

    @Column(name="name")
    public String name;

    @Column(name="countryid")
    public Long countryid;

    @Column(name="year")
    public int year;
}
