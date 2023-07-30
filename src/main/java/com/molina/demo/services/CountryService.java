package com.molina.demo.services;

import com.molina.demo.beans.Country;
import com.molina.demo.controllers.AddResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class CountryService {
    static HashMap<Integer, Country>countryMap = new HashMap<Integer, Country>();

    public CountryService(){
        countryMap= new HashMap<Integer, Country>();
        Country colombia= new Country(1,"colombia","bogota");
        Country españa= new Country(2,"españa","madrid");
        Country Ecuador= new Country(3,"Ecuador","Quito");

        countryMap.put(1,colombia);
        countryMap.put(2,españa);
        countryMap.put(3,Ecuador);
    }

    public List getAllCountries() {
        List countries= new ArrayList(countryMap.values());
        return countries;
    }

    public Country getCountrybyID(int id) {
       return countryMap.get(id);
    }

    public Country getCountrybyName(String name) {
       Country country = null;
       for(int i:countryMap.keySet()) {
           if(countryMap.get(i).getCountryName().equals(name)){
               country=countryMap.get(i);
           }
       }
       return country;
    }

    public Country addCountry(Country country) {
       country.setId(getMaxId());
       countryMap.put(country.getId(), country);
       return country;
    }
    public static int getMaxId(){
        int maxId = 0;
        for(int id :countryMap.keySet())
            if(maxId<id)
                maxId=id;
        return maxId+1;
    }
    public AddResponse deleteCountry(int id){
        countryMap.remove(id);
        AddResponse response= new AddResponse();
        response.setMessage("Country deleted");
        response.setId(id);
        return response;
    }

}
