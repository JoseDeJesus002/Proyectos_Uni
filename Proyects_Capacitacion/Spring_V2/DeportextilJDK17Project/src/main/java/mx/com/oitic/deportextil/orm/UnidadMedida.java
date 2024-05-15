/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.oitic.deportextil.orm;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.Set;

/**
 *
 * @author Hp
 */
@Entity
@Table(name = "unidad_medida")
@NamedQueries({
    @NamedQuery(name = "UnidadMedida.findAll", query = "SELECT u FROM UnidadMedida u")})
public class UnidadMedida implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_unidad_medida")
    private String idUnidadMedida;
    @Column(name = "abreviatura")
    private String abreviatura;
    @Basic(optional = false)
    @Column(name = "unidad_medida")
    private String unidadMedida;
    @Column(name = "unidad_sat")
    private String unidadSat;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "unidadMedida", fetch = FetchType.LAZY)
    private Set<TipoArticulo> tipoArticuloSet;

    public UnidadMedida() {
    }

    public UnidadMedida(String idUnidadMedida) {
        this.idUnidadMedida = idUnidadMedida;
    }

    public UnidadMedida(String idUnidadMedida, String unidadMedida) {
        this.idUnidadMedida = idUnidadMedida;
        this.unidadMedida = unidadMedida;
    }

    public String getIdUnidadMedida() {
        return idUnidadMedida;
    }

    public void setIdUnidadMedida(String idUnidadMedida) {
        this.idUnidadMedida = idUnidadMedida;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public String getUnidadSat() {
        return unidadSat;
    }

    public void setUnidadSat(String unidadSat) {
        this.unidadSat = unidadSat;
    }

    public Set<TipoArticulo> getTipoArticuloSet() {
        return tipoArticuloSet;
    }

    public void setTipoArticuloSet(Set<TipoArticulo> tipoArticuloSet) {
        this.tipoArticuloSet = tipoArticuloSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUnidadMedida != null ? idUnidadMedida.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UnidadMedida)) {
            return false;
        }
        UnidadMedida other = (UnidadMedida) object;
        if ((this.idUnidadMedida == null && other.idUnidadMedida != null) || (this.idUnidadMedida != null && !this.idUnidadMedida.equals(other.idUnidadMedida))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.com.oitic.deportextil.orm.UnidadMedida[ idUnidadMedida=" + idUnidadMedida + " ]";
    }
    
}
