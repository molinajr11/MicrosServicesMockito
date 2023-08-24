package com.molina.demo.controllers;

import com.molina.demo.beans.Country;
import com.molina.demo.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity getCountriesById(@PathVariable int id){
      try{
          Country country= countryService.getCountrybyID(id);
          return new ResponseEntity<Country>(country, HttpStatus.OK);
      } catch (Exception e){
          return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }

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
    public ResponseEntity<Country> updateCountry(@PathVariable int id, @RequestBody Country country){
       try{
           Country idExist = countryService.getCountrybyID(id);
           idExist.setCountryName(country.getCountryName());
           idExist.setCountryCapital(country.getCountryCapital());
          Country countryUpdated= countryService.updateCountry(idExist);
           return  new ResponseEntity<Country>(countryUpdated,HttpStatus.OK);
       }catch (Exception e){
           return new ResponseEntity<>(HttpStatus.CONFLICT);
       }

    }

    @DeleteMapping("/deletecountry/{id}")
    public AddResponse deleteCountry(@PathVariable int id){
        return countryService.deleteCountry(id);
    }
}
