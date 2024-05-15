/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.oitic.deportextil.orm;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import java.io.Serializable;

/**
 *
 * @author Hp
 */
@Entity
@Table(name = "cofiguracion")
@NamedQueries({
    @NamedQuery(name = "Cofiguracion.findAll", query = "SELECT c FROM Cofiguracion c")})
public class Cofiguracion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_cofiguracion")
    private String idCofiguracion;
    @Basic(optional = false)
    @Lob
    @Column(name = "valor")
    private String valor;
    @Basic(optional = false)
    @Column(name = "archivo")
    private boolean archivo;

    public Cofiguracion() {
    }

    public Cofiguracion(String idCofiguracion) {
        this.idCofiguracion = idCofiguracion;
    }

    public Cofiguracion(String idCofiguracion, String valor, boolean archivo) {
        this.idCofiguracion = idCofiguracion;
        this.valor = valor;
        this.archivo = archivo;
    }

    public String getIdCofiguracion() {
        return idCofiguracion;
    }

    public void setIdCofiguracion(String idCofiguracion) {
        this.idCofiguracion = idCofiguracion;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public boolean getArchivo() {
        return archivo;
    }

    public void setArchivo(boolean archivo) {
        this.archivo = archivo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCofiguracion != null ? idCofiguracion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cofiguracion)) {
            return false;
        }
        Cofiguracion other = (Cofiguracion) object;
        if ((this.idCofiguracion == null && other.idCofiguracion != null) || (this.idCofiguracion != null && !this.idCofiguracion.equals(other.idCofiguracion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.com.oitic.deportextil.orm.Cofiguracion[ idCofiguracion=" + idCofiguracion + " ]";
    }
    
}
