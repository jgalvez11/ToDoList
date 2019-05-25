package com.dolist.modelo.manejadores.utils;

import com.dolist.modelo.enums.TipoOrdenamiento;

/**
 * 
 * @author JGALVEZ
 *
 */
public class InformacionOrdenamiento {	
	
	public final TipoOrdenamiento tipo;
	public final String campo;
	
	public InformacionOrdenamiento(TipoOrdenamiento tipo, String campo) {
		this.tipo = tipo;
		this.campo = campo;
	}        

}
