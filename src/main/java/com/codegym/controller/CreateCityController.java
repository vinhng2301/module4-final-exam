package com.codegym.controller;

import com.codegym.model.City;
import com.codegym.model.Country;
import com.codegym.service.CityService;
import com.codegym.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CreateCityController {

    @Autowired
    private CountryService countryService;

    @Autowired
    private CityService cityService;

    @GetMapping("/createCountry")
    public ModelAndView createCountryForm(){
        ModelAndView model = new ModelAndView("country", "country",new Country());
        return model;
    }

    @PostMapping("/createCountry")
    public ModelAndView createCountry(@ModelAttribute Country country){
        countryService.save(country);
        return new ModelAndView("country");
    }

    @GetMapping("/create")
    public ModelAndView createCityForm(){
        List<Country> countryList = (List<Country>) countryService.findAll();
        ModelAndView model= new ModelAndView("city", "city", new City());
        model.addObject("countryList",countryList);
        return model;
    }

    @PostMapping("/create")
    public ModelAndView createCity(@ModelAttribute City city){
        cityService.save(city);
        ModelAndView modelAndView = new ModelAndView("city","message","Add City Succesfully");
        return modelAndView;
    }
}
