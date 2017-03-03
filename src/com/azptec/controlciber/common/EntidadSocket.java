/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.azptec.controlciber.common;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author sazpeitia
 */
public abstract class EntidadSocket {

   
    private int idEntidad;
    private Socket socket;
    private DataOutputStream dataOutputStream;
    private DataInputStream dataInputStream;
    private String mensajeEntrada;
    private String mensajeSalida;
    private String host;
    private int port;
    private boolean conectado;
    private boolean brockenPipe;
    private boolean mensajeEntradaNuevo;
    private boolean mensajeSalidaNuevo;

    public EntidadSocket() {
        
        setMensajeEntrada("");
        setMensajeSalida("");
    }
    
    public abstract void iniciarConexion();
    public abstract void cerrarConexion();
    
    public void EnviarMensaje() {
        
        try {
            
            setDataOutputStream( new DataOutputStream(getSocket().getOutputStream()) );
            getDataOutputStream().writeUTF(getMensajeSalida());
            System.out.println("Mensaje enviado correctamente: " + getMensajeSalida());
        }
        
        catch ( IOException iOException ) {
            
            System.out.println("Error al enviar mensaje: " + 
                    iOException.getMessage());
            if ( iOException.getMessage().contains("Write failed") | 
                    iOException.getMessage().contains( "connection abort")) {
                
                setBrockenPipe(true);
            }
        }
    }
    
    public void recibirMensaje() {
        
        try {
            
            setDataInputStream( new DataInputStream( getSocket().getInputStream() ) );
            System.out.println("En espera de mensaje entrante...");
            setMensajeEntrada( getDataInputStream().readUTF() );
            System.out.println("Mensaje recibido correctamente: " + getMensajeEntrada());
        }
        
        catch ( IOException iOException ) {
            
            System.out.println("Error al recibir mensaje: " + 
                    iOException.getMessage());
        }
    }
    
    public void cerrarObjectoEntrada(){
        
        try {
            
            getDataInputStream().close();
            System.out.println("Objeto de entrada cerrado correctamente");
        }
        
        catch ( IOException iOException ) {
            
            System.out.println("Ocurrió un error al cerrar objeto de entrada: " +
                    iOException.getMessage()
            );
        }
    }
    
    public void cerrarObjectoSalida(){
        
        try {
            
            getDataOutputStream().close();
            System.out.println("Objeto de salida cerrado correctamente");
        }
        
        catch ( IOException iOException ) {
            
            System.out.println("Ocurrió un error al cerrar objeto de salida: " +
                    iOException.getMessage()
            );
        }
    }
    
        /**
     * @return the idEntidad
     */
    public int getIdEntidad() {
        return idEntidad;
    }

    /**
     * @param idEntidad the idEntidad to set
     */
    public void setIdEntidad(int idEntidad) {
        this.idEntidad = idEntidad;
    }

    /**
     * @return the socket
     */
    public Socket getSocket() {
        return socket;
    }

    /**
     * @param socket the socket to set
     */
    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    /**
     * @return the dataOutputStream
     */
    public DataOutputStream getDataOutputStream() {
        return dataOutputStream;
    }

    /**
     * @param dataOutputStream the dataOutputStream to set
     */
    public void setDataOutputStream(DataOutputStream dataOutputStream) {
        this.dataOutputStream = dataOutputStream;
    }

    /**
     * @return the dataInputStream
     */
    public DataInputStream getDataInputStream() {
        return dataInputStream;
    }

    /**
     * @param dataInputStream the dataInputStream to set
     */
    public void setDataInputStream(DataInputStream dataInputStream) {
        this.dataInputStream = dataInputStream;
    }

    /**
     * @return the host
     */
    public String getHost() {
        return host;
    }

    /**
     * @param host the host to set
     */
    public void setHost(String host) {
        this.host = host;
    }

    /**
     * @return the port
     */
    public int getPort() {
        return port;
    }

    /**
     * @param port the port to set
     */
    public void setPort(int port) {
        this.port = port;
    }
    
    
     /**
     * @return the conectado
     */
    public boolean isConectado() {
        return conectado;
    }

    /**
     * @param conectado the conectado to set
     */
    public void setConectado(boolean conectado) {
        this.conectado = conectado;
    }
    
        /**
     * @return the mensajeEntrada
     */
    public String getMensajeEntrada() {
        return mensajeEntrada;
    }

    /**
     * @param mensajeEntrada the mensajeEntrada to set
     */
    public void setMensajeEntrada(String mensajeEntrada) {
        
        this.mensajeEntrada = mensajeEntrada;
        this.setMensajeEntradaNuevo(true);
    }

    /**
     * @return the mensajeSalida
     */
    public String getMensajeSalida() {
        return mensajeSalida;
    }

    /**
     * @param mensajeSalida the mensajeSalida to set
     */
    public void setMensajeSalida(String mensajeSalida) {
        
        
        this.mensajeSalida = mensajeSalida;
        setMensajeSalidaNuevo(true);
    }

   
    /**
     * @return the brockenPipe
     */
    public boolean isBrockenPipe() {
        return brockenPipe;
    }

    /**
     * @param brockenPipe the brockenPipe to set
     */
    public void setBrockenPipe(boolean brockenPipe) {
        this.brockenPipe = brockenPipe;
    }
    
    /**
     * @return the mensajeNuevo
     */
    public boolean isMensajeEntradaNuevo() {
        return mensajeEntradaNuevo;
    }

    /**
     * @param mensajeEntradaNuevo the mensajeNuevo to set
     */
    public void setMensajeEntradaNuevo(boolean mensajeEntradaNuevo) {
        this.mensajeEntradaNuevo = mensajeEntradaNuevo;
    }

    
     /**
     * @return the salidaEntradaNuevo
     */
    public boolean isMensajeSalidaNuevo() {
        return mensajeSalidaNuevo;
    }

    /**
     * @param mensajeSalidaNuevo the salidaEntradaNuevo to set
     */
    public void setMensajeSalidaNuevo(boolean mensajeSalidaNuevo) {
        this.mensajeSalidaNuevo = mensajeSalidaNuevo;
    }

    
}
