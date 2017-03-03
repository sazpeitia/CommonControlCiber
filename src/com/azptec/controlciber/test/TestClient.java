/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.azptec.controlciber.test;

import com.azptec.controlciber.common.EntidadCliente;
import com.azptec.controlciber.common.EntidadClienteListener;
import com.azptec.controlciber.common.EntidadClienteListenerMensajes;
import com.azptec.controlciber.common.EntidadSocketListener;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sazpeitia
 */
public class TestClient {
    public static void main(String[] args) {
      /*  
        EntidadCliente cliente1 = new EntidadCliente();
        cliente1.setIdEntidad(25);
        cliente1.setHost("localhost");
        cliente1.setPort(42001);
        
        EntidadCliente cliente2 = new EntidadCliente();
        cliente2.setIdEntidad(10);
        cliente2.setHost("localhost");
        cliente2.setPort(42001);
        
         EntidadClienteListener clienteListenerConexion = 
                new EntidadClienteListener();
        EntidadClienteListenerMensajes clienteListenerMensajes = 
                new EntidadClienteListenerMensajes();
        EntidadClienteListener clienteListenerConexion2 = 
                new EntidadClienteListener();
        EntidadClienteListenerMensajes clienteListenerMensajes2 = 
                new EntidadClienteListenerMensajes();
  
        
        clienteListenerConexion.setEscuchando(true);
        clienteListenerMensajes.setEscuchando(true);
        clienteListenerConexion2.setEscuchando(true);
        clienteListenerMensajes2.setEscuchando(true);
        
        
       clienteListenerConexion.setCliente(cliente1);
       clienteListenerMensajes.setCliente(cliente1);
       clienteListenerConexion2.setCliente(cliente2);
       clienteListenerMensajes2.setCliente(cliente2);
       
       List<EntidadSocketListener> coleccionListeners = new ArrayList<>();
       
       coleccionListeners.add(clienteListenerConexion);
       coleccionListeners.add(clienteListenerMensajes);
       coleccionListeners.add(clienteListenerConexion2);
       coleccionListeners.add(clienteListenerMensajes2);
       
       for ( EntidadSocketListener listener : coleccionListeners ) {
           Thread hilo = new Thread(listener);
           hilo.start();
           System.out.println("Hilo Numero: " + hilo.getId());
          
       }
        */
    }
}
