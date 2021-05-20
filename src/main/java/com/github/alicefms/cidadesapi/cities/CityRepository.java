package com.github.alicefms.cidadesapi.cities;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Long> {
    Double distanceByPoints(Long city1, Long city2);

    Double distanceByCube(double x, double y, double x1, double y1);
}