package com.dolist.modelo.entidades;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class UsuarioPK implements Serializable{

private static final long serialVersionUID = 1L;
	
	@Basic(optional = false)
    @NotNull
    @Column(name="TIPO_DOCUMENTO")
    
    private String tipoDocumento;       
	@Basic(optional = false)
    @NotNull
    @Column(name="NUMERO_DOCUMENTO")
    
    private String numeroDocumento;       

	public UsuarioPK(){
		
	}

    public UsuarioPK(String tipoDocumento, String numeroDocumento) {
		this.tipoDocumento = tipoDocumento;       
		this.numeroDocumento = numeroDocumento;       
    }

    
	public String getTipoDocumento(){
		return this.tipoDocumento;
	}
	
	public void setTipoDocumento(String tipoDocumento){
		this.tipoDocumento = tipoDocumento;
	}
		
    
	public String getNumeroDocumento(){
		return this.numeroDocumento;
	}
	
	public void setNumeroDocumento(String numeroDocumento){
		this.numeroDocumento = numeroDocumento;
	}
		

	/**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
	@Override
	public int hashCode() {
        int hash = 3;
                
        hash = 37 * hash + Objects.hashCode(this.tipoDocumento);
        hash = 37 * hash + Objects.hashCode(this.numeroDocumento);
        
        return hash;
    }

	/**
     * Valida la igualdad de la instancia de la entidad UsuarioPK que se pasa
     * como parámetro comprobando que comparten los mismos valores en cada uno
     * de sus atributos. Solo se tienen en cuenta los atributos simples, es
     * decir, se omiten aquellos que definen una relación con otra tabla.
     *
     * @param obj Instancia de la categoría a comprobar
     * @return Verdadero si esta instancia y la que se pasan como parámetros son
     * iguales.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final UsuarioPK other = (UsuarioPK) obj;
        
        
        if (!Objects.equals(this.tipoDocumento, other.tipoDocumento)) {
            return false;
        }
        
        return Objects.equals(this.numeroDocumento, other.numeroDocumento);
                
    }
    
    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
     @Override
     public String toString(){
     	StringBuilder cadena = new StringBuilder();
	     cadena.append("tipoDocumento");
		 cadena.append(this.tipoDocumento);
	 	cadena.append(", ");
         
	     cadena.append("numeroDocumento");
		 cadena.append(this.numeroDocumento);
         
     	return cadena.toString(); 
     }

} 
