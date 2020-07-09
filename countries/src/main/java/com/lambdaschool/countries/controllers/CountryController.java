package com.lambdaschool.countries.controllers;

import com.lambdaschool.countries.models.Country;
import com.lambdaschool.countries.repositories.CountryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CountryController {

    public List<Country> countryList = new ArrayList<>();

    @Autowired
    CountryRepo countryrepo;

    private List<Country> findCountries (List<Country> countryList, TestCountry tester) {
        List<Country> tempList = new ArrayList<>();

        for (Country c : countryList) {
            if (tester.test(c)) {
                tempList.add(c);
            }
        }

        return tempList;
    }

    @GetMapping(value = "/names/all",
                produces = {"application/json"})
    public ResponseEntity<?> listAllCountryNames() {
        countryrepo.findAll().iterator().forEachRemaining(countryList::add);

        countryList.sort((c1, c2) -> c1.getCname().compareToIgnoreCase(c2.getCname()));
        return new ResponseEntity<>(countryList, HttpStatus.OK);
    }

    @GetMapping(value = "/names/start/{letter}",
                produces = {"application/json"})

    public ResponseEntity<?> listAllByFirstName(@PathVariable char letter) {
        countryrepo.findAll().iterator().forEachRemaining(countryList::add);
        List<Country> rtnList = findCountries(countryList, e-> e.getCname().charAt(0) == letter);

        for (Country c : rtnList)
        {
            System.out.println(c);
        }

        return new ResponseEntity<>(rtnList, HttpStatus.OK);
    }

    @GetMapping(value = "/names/size/{people}",
            produces = {"application/json"})
    public ResponseEntity<?> listByGreaterThanOrEqualTo(@PathVariable char people) {
        countryrepo.findAll().iterator().forEachRemaining(countryList::add);
        List<Country> rtnList = findCountries(countryList, e-> e.getPopulation() > );

        for (Country c : rtnList)
        {
            System.out.println(c);
        }

        return new ResponseEntity<>(rtnList, HttpStatus.OK);
    }

}