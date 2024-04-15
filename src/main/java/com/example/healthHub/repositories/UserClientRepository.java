package com.example.healthHub.repositories;

import com.example.healthHub.models.UserClientModel;
import com.example.healthHub.models.UserProfessionalModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserClientRepository extends JpaRepository<UserClientModel, Integer> {
}
