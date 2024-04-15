package com.example.healthHub.models;


import jakarta.persistence.*;

@Entity
@Table(name = "TB_Client")
public class UserClientModel {
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
    private Integer age;
    @ManyToOne
    @JoinColumn(name = "fk_address", referencedColumnName = "id")
    private AddressModel fk_address;


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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public AddressModel getFk_address() {
        return fk_address;
    }

    public void setFk_address(AddressModel fk_address) {
        this.fk_address = fk_address;
    }
}
