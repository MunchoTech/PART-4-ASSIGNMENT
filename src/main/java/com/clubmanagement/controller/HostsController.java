package com.clubmanagement.controller;


import com.clubmanagement.entities.Hosts;
import com.clubmanagement.entities.HostsId;
import com.clubmanagement.Services.HostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/hosts")
public class HostsController {
    @Autowired
    private HostsService hostsService;

    @GetMapping
    public List<Hosts> getAllHosts() {
        return hostsService.getAllHosts();
    }

    @GetMapping("/{clubId}/{eventId}")
    public ResponseEntity<Hosts> getHostsById(@PathVariable Integer clubId, @PathVariable Integer eventId) {
        HostsId id = new HostsId();
        id.setClubId(clubId);
        id.setEventId(eventId);
        Optional<Hosts> hosts = hostsService.getHostsById(id);
        return hosts.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Hosts createHosts(@RequestBody Hosts hosts) {
        return hostsService.saveHosts(hosts);
    }

    @PutMapping("/{clubId}/{eventId}")
    public ResponseEntity<Hosts> updateHosts(@PathVariable Integer clubId, @PathVariable Integer eventId, @RequestBody Hosts hostsDetails) {
        HostsId id = new HostsId();
        id.setClubId(clubId);
        id.setEventId(eventId);
        Optional<Hosts> hostsOptional = hostsService.getHostsById(id);
        if (hostsOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Hosts hosts = hostsOptional.get();
        hosts.setClub(hostsDetails.getClub());
        hosts.setEvent(hostsDetails.getEvent());
        Hosts updatedHosts = hostsService.saveHosts(hosts);
        return ResponseEntity.ok(updatedHosts);
    }

    @DeleteMapping("/{clubId}/{eventId}")
    public ResponseEntity<Void> deleteHosts(@PathVariable Integer clubId, @PathVariable Integer eventId) {
        HostsId id = new HostsId();
        id.setClubId(clubId);
        id.setEventId(eventId);
        hostsService.deleteHosts(id);
        return ResponseEntity.noContent().build();
    }
}