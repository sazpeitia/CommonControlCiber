/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.azptec.controlciber.common;

import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author sazpeitia
 */
public class EntidadCliente extends EntidadSocket {

    @Override
    public void iniciarConexion() {
        
        setConectado(false);
        
        try {
            
            setSocket( new Socket(getHost(), getPort()) );
            System.out.println("Cliente. Conexión establecida...");
            setConectado(true);
            setBrockenPipe(false);
        }
        
        catch ( IOException iOException ) {
            
            System.out.println("No hay conexión..." + iOException.getMessage());
            setConectado(false);
        }
        
        
    }

    @Override
    public void cerrarConexion() {
        
        try {
            
            getSocket().close();
            System.out.println("Cliente. Conexión cerrada correctamente");
            setConectado(false);
        }
        
        catch ( IOException iOException ) {
            
            System.out.println("Cliente. Ocurrió un error al cerrar conexion: " + 
                    iOException.getMessage()
            );
        }
    }
    
}
