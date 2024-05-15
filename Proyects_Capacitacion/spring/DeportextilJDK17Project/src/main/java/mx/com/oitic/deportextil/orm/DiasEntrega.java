/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.oitic.deportextil.orm;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
@Table(name = "dias_entrega")
@NamedQueries({
    @NamedQuery(name = "DiasEntrega.findAll", query = "SELECT d FROM DiasEntrega d")})
public class DiasEntrega implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_dias_entrega")
    private Integer idDiasEntrega;
    @Basic(optional = false)
    @Column(name = "dias_entrega")
    private String diasEntrega;
    @OneToMany(mappedBy = "diasEntrega", fetch = FetchType.LAZY)
    private Set<TipoArticulo> tipoArticuloSet;

    public DiasEntrega() {
    }

    public DiasEntrega(Integer idDiasEntrega) {
        this.idDiasEntrega = idDiasEntrega;
    }

    public DiasEntrega(Integer idDiasEntrega, String diasEntrega) {
        this.idDiasEntrega = idDiasEntrega;
        this.diasEntrega = diasEntrega;
    }

    public Integer getIdDiasEntrega() {
        return idDiasEntrega;
    }

    public void setIdDiasEntrega(Integer idDiasEntrega) {
        this.idDiasEntrega = idDiasEntrega;
    }

    public String getDiasEntrega() {
        return diasEntrega;
    }

    public void setDiasEntrega(String diasEntrega) {
        this.diasEntrega = diasEntrega;
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
        hash += (idDiasEntrega != null ? idDiasEntrega.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DiasEntrega)) {
            return false;
        }
        DiasEntrega other = (DiasEntrega) object;
        if ((this.idDiasEntrega == null && other.idDiasEntrega != null) || (this.idDiasEntrega != null && !this.idDiasEntrega.equals(other.idDiasEntrega))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.com.oitic.deportextil.orm.DiasEntrega[ idDiasEntrega=" + idDiasEntrega + " ]";
    }
    
}
