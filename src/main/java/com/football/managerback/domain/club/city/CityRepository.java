package com.football.managerback.domain.club.city;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CityRepository extends JpaRepository<City, Integer> {
    @Query("select c from City c where c.country.name = ?1")
    List<City> findByCountry_Name(String name);

    @Query("select c from City c where c.name = ?1")
    Optional<City> findByName(String name);

    @Query("select count(c) from City c where c.name = ?1")
    long countByName(String name);
}