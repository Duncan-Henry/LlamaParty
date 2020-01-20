/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.llamaparty.data;

import com.mycompany.llamaparty.models.Reservation;
import java.util.ArrayList;
import org.springframework.stereotype.Repository;

/**
 *
 * @author G10-DEV10W2
 */
@Repository
public class PartyDao {
    ArrayList<Reservation> reservations = new ArrayList();
    
    public PartyDao() {
        
    }
    
    public void makeReservation(Reservation newRes) {
        reservations.add(newRes);
    }
    
    public ArrayList<Reservation> getAllReservations() {
        return new ArrayList<Reservation>(reservations);
    }
    
    
}
