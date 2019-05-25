/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dolist.web.servicio.utils;

/**
 * Constantes utilizadas en los servicios.
 * @author GeneradorCRUD
 */
public class ConstantesServicios {
        
    //Tipos de datos consumidos o producidos por los servicios
    public static final String APPLICATION_JSON = "application/json";
    public static final String TEXT_PLAIN = "text/plain";
    public static final String ACCESS_CONTROL_ALLOW_HEADERS = "Access-Control-Allow-Headers";
    public static final String X_EXTRA_HEADER = "X-extra-header";
    
    // Mensajes de error
    public static final String ERROR_CREAR_USUARIO = "No se ha podido crear el usuario";
    public static final String ERROR_ACTUALIZAR_USUARIO = "No se ha podido actualizar el usuario";
    public static final String ERROR_ELIMINAR_USUARIO = "No se ha podido eliminar el usuario";
    private ConstantesServicios(){};      
    
}
