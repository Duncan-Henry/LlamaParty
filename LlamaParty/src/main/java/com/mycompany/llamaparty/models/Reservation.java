/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.llamaparty.models;

import java.util.Objects;

/**
 *
 * @author G10-DEV10W2
 */
public class Reservation {
    private String name;
    private int numLlamas;
    private boolean attendance;
    
    public Reservation() {
        name = "";
        numLlamas = 0;
        attendance = false;
    }
    
    public Reservation(String name, int numLlamas, String attendance) {
        this.name = name;
        this.numLlamas = numLlamas;
        if(attendance.equals("true")) {
            this.attendance = true;
        } else {
            this.attendance = false;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumLlamas() {
        return numLlamas;
    }

    public void setNumLlamas(int numLlamas) {
        this.numLlamas = numLlamas;
    }

    public boolean isAttending() {
        return attendance;
    }

    public void setAttending(boolean attendance) {
        this.attendance = attendance;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.name);
        hash = 89 * hash + this.numLlamas;
        hash = 89 * hash + (this.attendance ? 1 : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Reservation other = (Reservation) obj;
        return true;
    }
    
    
}
