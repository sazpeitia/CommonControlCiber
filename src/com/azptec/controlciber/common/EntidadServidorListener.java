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
public abstract class EntidadServidorListener extends EntidadSocketListener {

    

    private EntidadServidor servidor;
    
    
    
    @Override
    public abstract void run();
    
    
    
    /**
     * @return the servidor
     */
    public EntidadServidor getServidor() {
        return servidor;
    }

    /**
     * @param servidor the servidor to set
     */
    public void setServidor(EntidadServidor servidor) {
        this.servidor = servidor;
    }

  
}
