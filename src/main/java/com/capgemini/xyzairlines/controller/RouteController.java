package com.capgemini.xyzairlines.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;


@Controller
@RequestMapping("/")
public class RouteController {

    @RequestMapping(value="/airports", method = RequestMethod.GET)
    public String airports(Map<String, Object> model) {
        return "airports";
    }

    @RequestMapping(value="/airplaines", method = RequestMethod.GET)
    public String airplaines(Map<String, Object> model) {
        return "airplaines";
    }

    @RequestMapping(value="/addAirplaines", method = RequestMethod.GET)
    public String addAirplaines(Map<String, Object> model) {
        return "addAirplaines";
    }

    @RequestMapping(value="/addAirports", method = RequestMethod.GET)
    public String addAirports(Map<String, Object> model) {
        return "addAirports";
    }
  
    @RequestMapping(value="/", method = RequestMethod.GET)
    public String index(Map<String, Object> model) {
        return "index";
    }
}
