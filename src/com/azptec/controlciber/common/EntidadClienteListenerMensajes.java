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
public class EntidadClienteListenerMensajes extends EntidadSocketListener {

 
   

    private  EntidadCliente cliente;
    private boolean escuchando;

   
    
    @Override
    public void run() {
        
        
        
        do
        {
            
            esperar(5000,"Thread: " + Thread.currentThread().getName() + " Cliente Listener Mensajes");
            
            if ( cliente.isBrockenPipe() ) {
                
                cliente.cerrarConexion();
            }
            
            if ( cliente.isConectado() & !cliente.isMensajeEntradaNuevo() ) {
                cliente.recibirMensaje();
            }
            
            if ( cliente.isConectado() &  cliente.isMensajeSalidaNuevo() ) {
                cliente.EnviarMensaje();
                cliente.setMensajeSalidaNuevo(false);
            }
            
            
        }while( isEscuchando() );
    }
    
   
    
 
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
    public boolean isEscuchando() {
        return escuchando;
    }

    /**
     * @param escuchando the escuchando to set
     */
    public void setEscuchando(boolean escuchando) {
        this.escuchando = escuchando;
    }


    
    
}
