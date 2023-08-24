package com.molina.demo.repositories;

import com.molina.demo.beans.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContryRepository extends JpaRepository<Country,Integer> {

}
