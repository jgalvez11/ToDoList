package com.dolist.modelo.manejadores;

import com.dolist.modelo.manejadores.utils.ManejadorCrud;
import com.dolist.modelo.entidades.Usuario;
import com.dolist.modelo.entidades.UsuarioPK;
import javax.ejb.Stateless;

/**
 * Manejador que define las operaciones CRUD y de negocio a realizar sobre la
 * tabla correspondiente a la entidad Usuario.
 * 
 * @author JGALVEZ
 *
 */
@Stateless
public class ManejadorUsuario extends ManejadorCrud<Usuario, UsuarioPK> {

	public ManejadorUsuario() {
		super(Usuario.class);
	}
}
