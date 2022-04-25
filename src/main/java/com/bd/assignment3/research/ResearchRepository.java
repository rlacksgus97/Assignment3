package com.bd.assignment3.research;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ResearchRepository extends JpaRepository<Research, Long> {
    Optional<Research> findByNum(String num);
}
