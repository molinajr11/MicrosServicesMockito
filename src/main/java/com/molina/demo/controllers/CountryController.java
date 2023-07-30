package com.molina.demo.controllers;

import com.molina.demo.beans.Country;
import com.molina.demo.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.List;

@RestController
@RequestMapping(value = "/country")
public class CountryController {

@Autowired
CountryService countryService;

    @GetMapping( "/getcountries")
    public List getCountries(){
      return countryService.getAllCountries();
    }

    @GetMapping("/countries/{id}")
    public Country getCountriesById(@PathVariable int id){
      return countryService.getCountrybyID(id);
    }

    @GetMapping("/getcountries/countryname")
    public Country getCountriesByName(@RequestParam String name){
        return countryService.getCountrybyName(name);
    }

    @PostMapping("/addcountry")
    public Country addCountry(@RequestBody Country country){
    return countryService.addCountry(country);
    }

    @PutMapping("/updatecountry")
    public Country updateCountry(@RequestBody Country country){
        return countryService.addCountry(country);
    }

    @DeleteMapping("/deletecountry/{id}")
    public AddResponse deleteCountry(@PathVariable int id){
        return countryService.deleteCountry(id);
    }





}
