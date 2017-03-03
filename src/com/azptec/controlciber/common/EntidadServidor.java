/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.azptec.controlciber.common;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sazpeitia
 */
public class EntidadServidor extends EntidadSocket {

    /**
     * @return the listaIterando
     */
    public boolean isListaIterando() {
        return listaIterando;
    }

    /**
     * @param listaIterando the listaIterando to set
     */
    public void setListaIterando(boolean listaIterando) {
        this.listaIterando = listaIterando;
    }

   

    private ServerSocket serverSocket;
    private boolean listaIterando;
    private final List<EntidadSocket> entidadSocketLista;

    public EntidadServidor() {
        
        entidadSocketLista = new ArrayList<>();
    }
    
    @Override
    public void iniciarConexion() {
        
        setConectado(false);
         
         try {
             
             setServerSocket(new ServerSocket(getPort()));
             System.out.println("Servidor. Conexión establecida...");
             setConectado(true);
         }
         
         catch ( IOException iOException ) {
             
             System.out.println("Servidor. No se logró conectar: " 
                     + iOException.getMessage());
             setConectado(false);
         }
        
    }
    
    public void nuevaConexionCliente( EntidadSocket nuevaEntidad ) {
        
        try {
            
            System.out.println("Server. En espera de clientes...");
            nuevaEntidad.setSocket( getServerSocket().accept() );
            System.out.println("Server. Nuevo cliente conectado");
            setListaIterando(true);
            getEntidadSocketLista().add(nuevaEntidad);
             setListaIterando(false);
            System.out.println("Server. "
                    + "Nuevo cliente conectado adicionado a la lista");
        }
        
        catch ( IOException iOException ) {
            
            System.out.println("Server. En espera de clientes, sucedió un error: " + 
                    iOException.getMessage());
        }
    }
    
     /**
     * @return the serverSocket
     */
    public ServerSocket getServerSocket() {
        return serverSocket;
    }

    /**
     * @param serverSocket the serverSocket to set
     */
    public void setServerSocket(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    @Override
    public void cerrarConexion() {
       
        try {
            
            getServerSocket().close();
            System.out.println("Server. Conexión cerrada correctamente");
            setConectado(false);
        }
        
        catch ( IOException iOException ) {
            
            System.out.println("Server. Ocurrió un error al cerrar conexion: " + 
                    iOException.getMessage()
            );
        }
        
    }
    
     /**
     * @return the entidadSocketLista
     */
    public List<EntidadSocket> getEntidadSocketLista() {
        return entidadSocketLista;
    }
}
