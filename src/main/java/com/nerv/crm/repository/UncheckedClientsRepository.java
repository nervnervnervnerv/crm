package com.nerv.crm.repository;

import com.nerv.crm.model.Client;
import com.nerv.crm.model.UncheckedClient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UncheckedClientsRepository extends JpaRepository<UncheckedClient, Long> {
    UncheckedClient findFirstById(Long id);
}
