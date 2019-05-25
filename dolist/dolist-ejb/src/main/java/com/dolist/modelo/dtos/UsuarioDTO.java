package com.dolist.modelo.dtos;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;
import java.io.Serializable;
import com.dolist.modelo.entidades.UsuarioPK;
import java.sql.Timestamp;

/**
 * DAO que contiene la información de la entidad UsuarioDTO que se transmite por
 * los servicios REST. Solo se transmiten los atributos simples, es decir, se
 * omiten aquellos atributos que definen relaciones con otras entidades.
 * 
 * @author GeneradorCRUD
 */
@XmlRootElement
public class UsuarioDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private UsuarioPK usuarioPK;

	private String primerNombre;
	private String segundoNombre;
	private String primerApellido;
	private String segundoApellido;
	private String genero;
	private String ciudadResidencia;
	private String estadoCivil;
	private String telefonoCelular;
	private Timestamp fechaNacimiento;

	public UsuarioDTO() {
		usuarioPK = new UsuarioPK();
	}

	public UsuarioPK getUsuarioPK() {
		return this.usuarioPK;
	}

	public void setUsuarioPK(UsuarioPK usuarioPK) {
		this.usuarioPK = usuarioPK;
	}

	public String getPrimerNombre() {
		return this.primerNombre;
	}

	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}

	public String getSegundoNombre() {
		return this.segundoNombre;
	}

	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}

	public String getPrimerApellido() {
		return this.primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public String getSegundoApellido() {
		return this.segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	public String getGenero() {
		return this.genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getCiudadResidencia() {
		return this.ciudadResidencia;
	}

	public void setCiudadResidencia(String ciudadResidencia) {
		this.ciudadResidencia = ciudadResidencia;
	}

	public String getEstadoCivil() {
		return this.estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getTelefonoCelular() {
		return this.telefonoCelular;
	}

	public void setTelefonoCelular(String telefonoCelular) {
		this.telefonoCelular = telefonoCelular;
	}

	public Timestamp getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public void setFechaNacimiento(Timestamp fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @return {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		int hash = 3;

		hash = 37 * hash + Objects.hashCode(this.usuarioPK);
		hash = 37 * hash + Objects.hashCode(this.primerNombre);
		hash = 37 * hash + Objects.hashCode(this.segundoNombre);
		hash = 37 * hash + Objects.hashCode(this.primerApellido);
		hash = 37 * hash + Objects.hashCode(this.segundoApellido);
		hash = 37 * hash + Objects.hashCode(this.genero);
		hash = 37 * hash + Objects.hashCode(this.ciudadResidencia);
		hash = 37 * hash + Objects.hashCode(this.estadoCivil);
		hash = 37 * hash + Objects.hashCode(this.telefonoCelular);
		hash = 37 * hash + Objects.hashCode(this.fechaNacimiento);

		return hash;
	}

	/**
	 * Valida la igualdad de la instancia de la entidad UsuarioDTO que se pasa como
	 * parámetro comprobando que comparten los mismos valores en cada uno de sus
	 * atributos. Solo se tienen en cuenta los atributos simples, es decir, se
	 * omiten aquellos que definen una relación con otra tabla.
	 *
	 * @param obj Instancia de la categoría a comprobar iguales.
	 * @return Verdadero si esta instancia y la que se pasan como parámetros son
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final UsuarioDTO other = (UsuarioDTO) obj;

		if (!Objects.equals(this.usuarioPK, other.usuarioPK)) {
			return false;
		}

		if (!Objects.equals(this.primerNombre, other.primerNombre)) {
			return false;
		}

		if (!Objects.equals(this.segundoNombre, other.segundoNombre)) {
			return false;
		}

		if (!Objects.equals(this.primerApellido, other.primerApellido)) {
			return false;
		}

		if (!Objects.equals(this.segundoApellido, other.segundoApellido)) {
			return false;
		}

		if (!Objects.equals(this.genero, other.genero)) {
			return false;
		}

		if (!Objects.equals(this.ciudadResidencia, other.ciudadResidencia)) {
			return false;
		}

		if (!Objects.equals(this.estadoCivil, other.estadoCivil)) {
			return false;
		}

		if (!Objects.equals(this.telefonoCelular, other.telefonoCelular)) {
			return false;
		}

		return Objects.equals(this.fechaNacimiento, other.fechaNacimiento);

	}

}
