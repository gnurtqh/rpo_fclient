package ru.iu3.rpo.backend.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="users")
@Access(AccessType.FIELD)
public class User {
    public User() {}
    public User(Long id) {this.id=id;}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", updatable = false, nullable = false)
    public long id;

    @Column(name="login", nullable = false, unique = true)
    public String login;

    @Column(name="email", nullable = false, unique = true)
    public String email;

    @JsonIgnore
    @Column(name="password")
    public String password;

    @JsonIgnore
    @Column(name="salt")
    public String salt;

    @Column(name="token")
    public String token;

    @Column(name="activity")
    public LocalDateTime activity;

    @ManyToMany(mappedBy = "users")
    public Set<Museum> museums = new HashSet<>();

    public void addMuseum(Museum museum) {
        this.museums.add(museum);
        museum.users.add(this);
    }
    public void removeMuseum(Museum museum) {
        this.museums.remove(museum);
        museum.users.remove(this);
    }
}
