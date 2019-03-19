package org.softuni.residentevil.repository;

import org.softuni.residentevil.domain.entities.Capital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CapitalRepository extends JpaRepository<Capital, String> {

    @Query("select c from Capital c order by c.name")
    List<Capital> findAllOrderByName();

    Optional<Capital> findById(String id);
}
