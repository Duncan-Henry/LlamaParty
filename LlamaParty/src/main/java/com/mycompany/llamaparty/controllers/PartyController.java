/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.llamaparty.controllers;

import com.mycompany.llamaparty.data.PartyDao;
import com.mycompany.llamaparty.models.Reservation;
import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author G10-DEV10W2
 */
@Controller
public class PartyController {
    
    private final PartyDao dao;
    
    public PartyController(PartyDao dao) {
        this.dao = dao;
    }
    
    @GetMapping("/")
    public String home(Model model) {
        return "PartyApp";
    }
    
    @GetMapping("/PartyApp/RSVP")
    public String reservationsPage(Model model) {
        
        return "RSVP";
    }
    
    @PostMapping("/PartyApp/RSVP")
    public String addReservation(Model model, Reservation res, String attendance) {
        System.out.println(attendance);
        if(attendance == null || res.getName() == null || res.getName().equals("") || res.getNumLlamas() <= 0) {
            return "Seriously";
        }
        if(attendance.equals("true")) {
            res.setAttending(true);
        }
        if(res.isAttending()) {
            dao.makeReservation(res);
            ArrayList<Reservation> allReservations = dao.getAllReservations();
            int totalLlamas = 0;
            double avgLlamas = 0;
            for(Reservation r : allReservations) {
                totalLlamas += r.getNumLlamas();
            }
            avgLlamas = (double)totalLlamas/(double)allReservations.size();
            
            model.addAttribute("allReservations", allReservations);
            model.addAttribute("totalLlamas", totalLlamas);
            model.addAttribute("avgLlamas", avgLlamas);
            
            return "Hurrah";
        }
        //Passive aggressive model
        return "WellThen";
    }
}
