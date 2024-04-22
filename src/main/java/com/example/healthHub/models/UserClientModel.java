package com.example.healthHub.models;


import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Entity
@Table(name = "TB_Client")
public class UserClientModel  implements UserDetails {
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public enum Sexo{
        masculino("masculino"),
        feminino("feminino"),
        naodeclarar("não declarar");

        public final String sexo;

        private Sexo(String label) {
            this.sexo = label;
        }
    }

    public enum Roles{
        ADMIN("ADMIN"),
        CLIENT("CLIENT"),
        PROFESSIONAL("PROFESSIONAL");

        public final String role;

        private Roles(String label) {
            this.role = label;
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
    private Roles roles;
    private String email;
    private String password;

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

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
