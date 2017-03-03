/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.azptec.controlciber.common;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author sazpeitia
 */
public class EntidadServidorListenerMensajes extends EntidadSocketListener {

   

    private  EntidadServidor servidor;

   
    
    @Override
    public void run() {
        
        
        
        while( getServidor().isConectado() )
        {
            if ( !getServidor().isListaIterando() )
                limpiarClientes();
            
            if ( !getServidor().isListaIterando() & 
                    getServidor().isMensajeSalidaNuevo() ) {
                enviarMensajeAClientes();
                getServidor().setMensajeSalidaNuevo(false);
            }
                
            if ( !getServidor().isListaIterando() )
                recibirMensajesDeClientes();
            
            /*if ( !getServidor().isListaIterando() )
                leerMensajesDeClientes();*/
            
            esperar(5000,"Thread: " + Thread.currentThread().getName() + " Server Listener Mensajes");
        }
    }
    
  
    
    private void recibirMensajesDeClientes () {
        
        if ( getServidor().getEntidadSocketLista()!= null &  
                getServidor().getEntidadSocketLista().size() > 0 ) {

            getServidor().setListaIterando(true);
            Iterator<EntidadSocket> clientes = 
                    getServidor().getEntidadSocketLista().iterator();

            while( clientes.hasNext() ) {

                EntidadSocket cliente = clientes.next();
                cliente.recibirMensaje();
            }
            getServidor().setListaIterando(false);
        } 
        else System.out.println("Listener Server. No hay clientes conectados");
    }
    
    
    private void enviarMensajeAClientes() {
        
        if ( getServidor().getEntidadSocketLista()!= null &  
                getServidor().getEntidadSocketLista().size() > 0 ) {

            getServidor().setListaIterando(true);
            Iterator<EntidadSocket> clientes = 
                    getServidor().getEntidadSocketLista().iterator();

            while( clientes.hasNext() ) {

                EntidadSocket cliente = clientes.next();
                //cliente.setMensajeSalida(cliente);
                cliente.EnviarMensaje();
            }
            getServidor().setListaIterando(false);
        } 
        else System.out.println("Listener Server. No hay clientes conectados");
    }
    
    public void limpiarClientes() {
        
        if ( getServidor().getEntidadSocketLista()!= null &  
                getServidor().getEntidadSocketLista().size() > 0 ) {
            
            getServidor().setListaIterando(true);
            
            List<EntidadSocket> clientesAEliminar = new ArrayList<>();

            Iterator<EntidadSocket> clientes = 
                    getServidor().getEntidadSocketLista().iterator();

            while( clientes.hasNext() ) {

                EntidadSocket cliente = clientes.next();
                if ( cliente.isBrockenPipe() ) {
                    
                    clientesAEliminar.add( cliente );
                }
            }
            
            clientesAEliminar.forEach((clienteAEliminar) -> {
                getServidor().getEntidadSocketLista().remove( clienteAEliminar );
            });
            
            getServidor().setListaIterando(false);
        }
        else System.out.println("Listener Server. No hay clientes conectados");
    }

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
