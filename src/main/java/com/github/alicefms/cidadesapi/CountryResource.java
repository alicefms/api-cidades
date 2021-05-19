package com.github.alicefms.cidadesapi;

import com.github.alicefms.cidadesapi.countries.Country;
import com.github.alicefms.cidadesapi.repository.CountryRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/countries")
public class CountryResource {

    private CountryRepository repository;

    public CountryResource(CountryRepository repository) {
        this.repository = repository;
    }



    @GetMapping
    public List<Country> countries(){
        return repository.findAll();
    }
}