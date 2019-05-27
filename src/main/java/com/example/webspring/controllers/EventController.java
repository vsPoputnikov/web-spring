package com.example.webspring.controllers;

import com.example.webspring.entity.Event;
import com.example.webspring.entity.University;
import com.example.webspring.repositories.EventRepository;
import com.example.webspring.repositories.UniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EventController {
    @Autowired
    private EventRepository eventRepository;

    @RequestMapping(value = "/event/add", method = RequestMethod.GET)
    public String showForm(@ModelAttribute Event event, Model model){
        model.addAttribute("event", new Event());
        return "add_event";
    }

    @RequestMapping(value = "/event/add", method = RequestMethod.POST)
    public String submitForm(@ModelAttribute Event event, Model model){
        eventRepository.save(event);
        model.addAttribute("addInfo",event.getEventTitle());
        return "add_event";
    }
}
