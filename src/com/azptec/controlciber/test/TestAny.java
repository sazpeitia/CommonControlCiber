/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.azptec.controlciber.test;

/**
 *
 * @author sazpeitia
 */
public class TestAny {
    public static void main(String[] args) {
        
        Cadena obj = new Cadena();
        if ( obj.getAlgo().equals("null") )
            System.out.println("Igual");
    }
}

class Cadena {
    
    private String algo;

    /**
     * @return the algo
     */
    public String getAlgo() {
        return algo;
    }

    /**
     * @param algo the algo to set
     */
    public void setAlgo(String algo) {
        this.algo = algo;
    }
}
