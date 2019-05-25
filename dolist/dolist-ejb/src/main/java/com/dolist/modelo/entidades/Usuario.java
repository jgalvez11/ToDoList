package com.dolist.modelo.entidades;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EmbeddedId;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * The persistent class for the CATEGORIES database table.
 *
 */
@Entity
@Table(name = "USUARIO")
@NamedQuery(name = "Usuario.findAll", query = "SELECT p FROM Usuario p")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	// Definicion de atributos de la entidad (Exceptuando relaciones)
	public static final String ENTIDAD_USUARIO_PK_TIPO_DOCUMENTO = "usuarioPK.tipoDocumento";
	public static final String ENTIDAD_USUARIO_PK_NUMERO_DOCUMENTO = "usuarioPK.numeroDocumento";
	public static final String ENTIDAD_USUARIO_PRIMER_NOMBRE = "primerNombre";
	public static final String ENTIDAD_USUARIO_SEGUNDO_NOMBRE = "segundoNombre";
	public static final String ENTIDAD_USUARIO_PRIMER_APELLIDO = "primerApellido";
	public static final String ENTIDAD_USUARIO_SEGUNDO_APELLIDO = "segundoApellido";
	public static final String ENTIDAD_USUARIO_GENERO = "genero";
	public static final String ENTIDAD_USUARIO_CIUDAD_RESIDENCIA = "ciudadResidencia";
	public static final String ENTIDAD_USUARIO_ESTADO_CIVIL = "estadoCivil";
	public static final String ENTIDAD_USUARIO_TELEFONO_CELULAR = "telefonoCelular";
	public static final String ENTIDAD_USUARIO_FECHA_NACIMIENTO = "fechaNacimiento";
	private static final String[] ATRIBUTOS_ENTIDAD_USUARIO = { ENTIDAD_USUARIO_PRIMER_APELLIDO,
			ENTIDAD_USUARIO_PK_TIPO_DOCUMENTO, ENTIDAD_USUARIO_CIUDAD_RESIDENCIA, ENTIDAD_USUARIO_PK_NUMERO_DOCUMENTO,
			ENTIDAD_USUARIO_FECHA_NACIMIENTO, ENTIDAD_USUARIO_GENERO, ENTIDAD_USUARIO_PRIMER_NOMBRE,
			ENTIDAD_USUARIO_SEGUNDO_APELLIDO, ENTIDAD_USUARIO_TELEFONO_CELULAR, ENTIDAD_USUARIO_SEGUNDO_NOMBRE,
			ENTIDAD_USUARIO_ESTADO_CIVIL };

	@EmbeddedId
	private UsuarioPK usuarioPK;

	@Column(name = "PRIMER_NOMBRE")
	private String primerNombre;

	@Column(name = "SEGUNDO_NOMBRE")
	private String segundoNombre;

	@Column(name = "PRIMER_APELLIDO")
	private String primerApellido;

	@Column(name = "SEGUNDO_APELLIDO")
	private String segundoApellido;

	@Column(name = "GENERO")
	private String genero;

	@Column(name = "CIUDAD_RESIDENCIA")
	private String ciudadResidencia;

	@Column(name = "ESTADO_CIVIL")
	private String estadoCivil;

	@Column(name = "TELEFONO_CELULAR")
	private String telefonoCelular;

	@Column(name = "FECHA_NACIMIENTO")
	private Timestamp fechaNacimiento;

	public Usuario() {
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
	 * Verifica si la entidad contiene el atributo que se pasa como parámetro
	 *
	 * @param atributo Nombre del atributo a validar
	 * @return Verdadero si la entidad contiene al atributo.
	 */
	public static boolean contieneAtributo(String atributo) {

		boolean contiene = false;
		for (final String atr : ATRIBUTOS_ENTIDAD_USUARIO) {
			if (atr.equals(atributo)) {
				contiene = true;
			}
		}

		return contiene;
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
	 * Valida la igualdad de la instancia de la entidad Usuario que se pasa como
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
		final Usuario other = (Usuario) obj;

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
