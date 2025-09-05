package com.clubmanagement.Services;


import com.clubmanagement.entities.Hosts;
import com.clubmanagement.entities.HostsId;
import com.clubmanagement.entities.repository.HostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HostsService {
    @Autowired
    private HostsRepository hostsRepository;

    public List<Hosts> getAllHosts() {
        return hostsRepository.findAll();
    }

    public Optional<Hosts> getHostsById(HostsId id) {
        return hostsRepository.findById(id);
    }

    public Hosts saveHosts(Hosts hosts) {
        return hostsRepository.save(hosts);
    }

    public void deleteHosts(HostsId id) {
        hostsRepository.deleteById(id);
    }
}