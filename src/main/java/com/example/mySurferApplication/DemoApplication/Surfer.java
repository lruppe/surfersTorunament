package com.example.mySurferApplication.DemoApplication;

import javax.persistence.*;

@Entity
public class Surfer {

    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String name;
    @Column
    private String country;

    @ManyToOne
    @JoinColumn(name="contest_id", nullable = true)
    private Contest contest;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }
}
