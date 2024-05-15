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
@Table(name = "uso_cfdi")
@NamedQueries({
    @NamedQuery(name = "UsoCfdi.findAll", query = "SELECT u FROM UsoCfdi u")})
public class UsoCfdi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_uso_cfdi")
    private String idUsoCfdi;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usoCfdi", fetch = FetchType.LAZY)
    private Set<Factura> facturaSet;

    public UsoCfdi() {
    }

    public UsoCfdi(String idUsoCfdi) {
        this.idUsoCfdi = idUsoCfdi;
    }

    public UsoCfdi(String idUsoCfdi, String descripcion) {
        this.idUsoCfdi = idUsoCfdi;
        this.descripcion = descripcion;
    }

    public String getIdUsoCfdi() {
        return idUsoCfdi;
    }

    public void setIdUsoCfdi(String idUsoCfdi) {
        this.idUsoCfdi = idUsoCfdi;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Set<Factura> getFacturaSet() {
        return facturaSet;
    }

    public void setFacturaSet(Set<Factura> facturaSet) {
        this.facturaSet = facturaSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsoCfdi != null ? idUsoCfdi.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsoCfdi)) {
            return false;
        }
        UsoCfdi other = (UsoCfdi) object;
        if ((this.idUsoCfdi == null && other.idUsoCfdi != null) || (this.idUsoCfdi != null && !this.idUsoCfdi.equals(other.idUsoCfdi))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.com.oitic.deportextil.orm.UsoCfdi[ idUsoCfdi=" + idUsoCfdi + " ]";
    }
    
}
