/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.azptec.controlciber.common;

/**
 *
 * @author sazpeitia
 */
public abstract class EntidadSocketListener implements Runnable {

   
    
    @Override
    public abstract void run();
    
    
    
    protected void esperar( long milisegundos, String identificador ) {
        
        System.out.println( identificador + ". Esperando 5 segundos...");
            try {
                
                Thread.sleep(5000);
            } catch (InterruptedException interruptedException) {
                
                System.out.println(identificador + ". Ocurrio un error "
                        + "en la espera: " + interruptedException.getMessage());
            }
        
    } 
  
}
