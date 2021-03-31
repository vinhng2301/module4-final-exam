package com.codegym.controller;

import com.codegym.model.City;
import com.codegym.service.CityService;
import com.codegym.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MainWebController {

    @Autowired
    private CountryService countryService;

    @Autowired
    private CityService cityService;

    @GetMapping("/")
    private ModelAndView mainView(){
        List<City> cityList = (List<City>) cityService.findAll();
        ModelAndView model = new ModelAndView("index","cityList",cityList);
        return model;
    }
}
