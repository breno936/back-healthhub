package com.example.healthHub.models;


import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "TB_Consultation")
public class ConsultationModel {
    public enum Status{
        pending("pending"),
        accepted("accepted"),
        not_accepted("not accepted");

        public final String status;

        private Status(String label) {
            this.status = label;
        }
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "fk_client", referencedColumnName = "id")
    private UserClientModel fk_client;

    @ManyToOne
    @JoinColumn(name = "fk_professional", referencedColumnName = "id")
    private UserProfessionalModel fk_professional;
    @ManyToOne
    @JoinColumn(name = "fk_address", referencedColumnName = "id")
    private AddressModel fk_address;
    private boolean isOnline;
    private Double price;
    private Date date;
    private Status status;
    private Double duration;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserClientModel getFk_client() {
        return fk_client;
    }

    public void setFk_client(UserClientModel fk_client) {
        this.fk_client = fk_client;
    }

    public UserProfessionalModel getFk_professional() {
        return fk_professional;
    }

    public void setFk_professional(UserProfessionalModel fk_professional) {
        this.fk_professional = fk_professional;
    }

    public boolean isOnline() {
        return isOnline;
    }

    public void setOnline(boolean online) {
        isOnline = online;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Double getDuration() {
        return duration;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }

    public AddressModel getFk_address() {
        return fk_address;
    }

    public void setFk_address(AddressModel fk_address) {
        this.fk_address = fk_address;
    }
}
