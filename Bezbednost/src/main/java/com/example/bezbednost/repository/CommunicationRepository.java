package com.example.bezbednost.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bezbednost.model.Communication;

public interface CommunicationRepository extends JpaRepository<Communication, Long> {

	Communication findOneById(long id);
}
