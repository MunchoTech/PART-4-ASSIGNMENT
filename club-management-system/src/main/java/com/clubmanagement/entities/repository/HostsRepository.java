package com.clubmanagement.entities.repository;


import com.clubmanagement.entities.Hosts;
import com.clubmanagement.entities.HostsId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HostsRepository extends JpaRepository<Hosts, HostsId> {
}
