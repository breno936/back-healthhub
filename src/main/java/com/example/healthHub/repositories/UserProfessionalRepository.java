package com.example.healthHub.repositories;

import com.example.healthHub.models.UserProfessionalModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProfessionalRepository extends JpaRepository<UserProfessionalModel, Integer> {
}
