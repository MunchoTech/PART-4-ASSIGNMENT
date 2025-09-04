package com.clubmanagement.entities.repository;



import com.clubmanagement.entities.Registration;
import com.clubmanagement.entities.RegistrationId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationRepository extends JpaRepository<Registration, RegistrationId> {
}
