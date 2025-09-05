package com.clubmanagement.Services;


import com.clubmanagement.entities.Registration;
import com.clubmanagement.entities.RegistrationId;
import com.clubmanagement.entities.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegistrationService {
    @Autowired
    private RegistrationRepository registrationRepository;

    public List<Registration> getAllRegistrations() {
        return registrationRepository.findAll();
    }

    public Optional<Registration> getRegistrationById(RegistrationId id) {
        return registrationRepository.findById(id);
    }

    public Registration saveRegistration(Registration registration) {
        return registrationRepository.save(registration);
    }

    public void deleteRegistration(RegistrationId id) {
        registrationRepository.deleteById(id);
    }
}