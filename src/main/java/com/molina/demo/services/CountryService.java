package com.molina.demo.services;

import com.molina.demo.beans.Country;
import com.molina.demo.controllers.AddResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.molina.demo.repositories.ContryRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class CountryService {
    @Autowired
    ContryRepository countryRepository;
    public List <Country> getAllCountries() {
       return countryRepository.findAll();
    }

    public Country getCountrybyID(int id) {
       return countryRepository.findById(id).get();
    }

    public Country getCountrybyName(String name) {
    return countryRepository.findAll()
            .stream()
            .filter(country -> country.getCountryName().equals(name))
            .findFirst()
            .orElse(null);
    }

    public Country addCountry(Country country) {
       return countryRepository.save(country);
    }
    public Country updateCountry(Country country) {
       return countryRepository.save(country);
    }

    public AddResponse deleteCountry(int id){
    AddResponse response = new AddResponse();
    try{
        countryRepository.deleteById(id);
        response.setMessage("Country deleted");
    }catch(Exception e){
        response.setMessage("Error while deleting");
    }
    return response;
    }

}
