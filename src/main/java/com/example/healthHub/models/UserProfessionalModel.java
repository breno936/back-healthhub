package com.example.healthHub.models;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "TB_Professional")
public class UserProfessionalModel {
    public enum Sexo{
        masculino("masculino"),
        feminino("feminino"),
        naodeclarar("não declarar");

        public final String sexo;

        private Sexo(String label) {
            this.sexo = label;
        }
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private Sexo gender;
    private String crn_cref;
    private String job;
    private Double rating;
    @ManyToMany(mappedBy = "fk_professional", fetch = FetchType.EAGER)
    private List<AddressModel> fk_address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sexo getGender() {
        return gender;
    }

    public void setGender(Sexo gender) {
        this.gender = gender;
    }

    public String getCrn_cref() {
        return crn_cref;
    }

    public void setCrn_cref(String crn_cref) {
        this.crn_cref = crn_cref;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public List<AddressModel> getFk_address() {
        return fk_address;
    }

    public void setFk_address(List<AddressModel> fk_address) {
        this.fk_address = fk_address;
    }
}
