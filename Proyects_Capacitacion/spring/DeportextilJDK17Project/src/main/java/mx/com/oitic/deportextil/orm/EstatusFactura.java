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
@Table(name = "estatus_factura")
@NamedQueries({
    @NamedQuery(name = "EstatusFactura.findAll", query = "SELECT e FROM EstatusFactura e")})
public class EstatusFactura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_estatus_factura")
    private Integer idEstatusFactura;
    @Basic(optional = false)
    @Column(name = "estatus_factura")
    private String estatusFactura;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estatusFactura", fetch = FetchType.LAZY)
    private Set<Factura> facturaSet;

    public EstatusFactura() {
    }

    public EstatusFactura(Integer idEstatusFactura) {
        this.idEstatusFactura = idEstatusFactura;
    }

    public EstatusFactura(Integer idEstatusFactura, String estatusFactura) {
        this.idEstatusFactura = idEstatusFactura;
        this.estatusFactura = estatusFactura;
    }

    public Integer getIdEstatusFactura() {
        return idEstatusFactura;
    }

    public void setIdEstatusFactura(Integer idEstatusFactura) {
        this.idEstatusFactura = idEstatusFactura;
    }

    public String getEstatusFactura() {
        return estatusFactura;
    }

    public void setEstatusFactura(String estatusFactura) {
        this.estatusFactura = estatusFactura;
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
        hash += (idEstatusFactura != null ? idEstatusFactura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstatusFactura)) {
            return false;
        }
        EstatusFactura other = (EstatusFactura) object;
        if ((this.idEstatusFactura == null && other.idEstatusFactura != null) || (this.idEstatusFactura != null && !this.idEstatusFactura.equals(other.idEstatusFactura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.com.oitic.deportextil.orm.EstatusFactura[ idEstatusFactura=" + idEstatusFactura + " ]";
    }
    
}
