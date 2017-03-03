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
public abstract class EntidadClienteListener extends EntidadSocketListener {


    private  EntidadCliente cliente;

    @Override
    public abstract void run();
   
    
      /**
     * @return the cliente
     */
    public EntidadCliente getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(EntidadCliente cliente) {
        this.cliente = cliente;
    }

    
       /**
     * @return the escuchando
     */
   
}
