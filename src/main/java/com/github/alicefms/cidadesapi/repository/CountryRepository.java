package com.github.alicefms.cidadesapi.repository;

import com.github.alicefms.cidadesapi.countries.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
