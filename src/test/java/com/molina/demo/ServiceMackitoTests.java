package com.molina.demo;

import com.molina.demo.beans.Country;
import com.molina.demo.controllers.AddResponse;
import com.molina.demo.repositories.ContryRepository;
import com.molina.demo.services.CountryService;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = {ServiceMackitoTests.class})
public class ServiceMackitoTests {
    @Mock
    ContryRepository contryRepository;

    @InjectMocks
    CountryService countryService;

    @Test
    @Order(1)
    public void test_getAllCountryes()  {
        List <Country> countrys = new ArrayList<Country>();
        countrys.add(new Country(1L,"India","Delhi"));
        countrys.add(new Country(2L,"Argentina","buenos aires"));
        when(contryRepository.findAll()).thenReturn(countrys);
        assertEquals(2,countryService.getAllCountries().size());
    }

    @Test
    public void test_getcountrybyId(){
        List <Country> countrys = new ArrayList<Country>();
        countrys.add(new Country(1L,"India","Delhi"));
        countrys.add(new Country(2L,"Argentina","buenos aires"));
        int countryID=1;
        when(contryRepository.findById(countryID)).thenReturn(Optional.of(countrys.get(0)));
       Country result = countryService.getCountrybyID(countryID);
       assertEquals(countryID,countryService.getCountrybyID(countryID).getId());
       assertEquals("India",result.getCountryName());
    }

    @Test
    public void test_getCountrybyName(){
        List <Country> countrys = new ArrayList<Country>();
        countrys.add(new Country(1L,"India","Delhi"));
        countrys.add(new Country(2L,"Argentina","buenos aires"));
        String countryname= "Argentina";
        when(contryRepository.findAll()).thenReturn(countrys);
        assertEquals("Argentina",countryService.getCountrybyName(countryname).getCountryName());
    }

    @Test
    public void test_addCountry(){
        Country country = new Country(3L,"Germany","Berlin");
        when(contryRepository.save(country)).thenReturn(country);
        assertEquals(country,countryService.addCountry(country));
    }

    @Test
    public void test_deleteCountry(){
        int countryId = 3;
        doNothing().when(contryRepository).deleteById(countryId);
        AddResponse result = countryService.deleteCountry(countryId);
        assertEquals("Country deleted", result.getMessage());
        verify(contryRepository, times(1)).deleteById(countryId);
    }
}
