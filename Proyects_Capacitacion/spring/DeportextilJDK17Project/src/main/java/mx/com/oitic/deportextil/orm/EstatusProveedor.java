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
@Table(name = "estatus_proveedor")
@NamedQueries({
    @NamedQuery(name = "EstatusProveedor.findAll", query = "SELECT e FROM EstatusProveedor e")})
public class EstatusProveedor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_estatus_proveedor")
    private Integer idEstatusProveedor;
    @Basic(optional = false)
    @Column(name = "estatus_proveedor")
    private String estatusProveedor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estatusProveedor", fetch = FetchType.LAZY)
    private Set<Proveedor> proveedorSet;

    public EstatusProveedor() {
    }

    public EstatusProveedor(Integer idEstatusProveedor) {
        this.idEstatusProveedor = idEstatusProveedor;
    }

    public EstatusProveedor(Integer idEstatusProveedor, String estatusProveedor) {
        this.idEstatusProveedor = idEstatusProveedor;
        this.estatusProveedor = estatusProveedor;
    }

    public Integer getIdEstatusProveedor() {
        return idEstatusProveedor;
    }

    public void setIdEstatusProveedor(Integer idEstatusProveedor) {
        this.idEstatusProveedor = idEstatusProveedor;
    }

    public String getEstatusProveedor() {
        return estatusProveedor;
    }

    public void setEstatusProveedor(String estatusProveedor) {
        this.estatusProveedor = estatusProveedor;
    }

    public Set<Proveedor> getProveedorSet() {
        return proveedorSet;
    }

    public void setProveedorSet(Set<Proveedor> proveedorSet) {
        this.proveedorSet = proveedorSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstatusProveedor != null ? idEstatusProveedor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstatusProveedor)) {
            return false;
        }
        EstatusProveedor other = (EstatusProveedor) object;
        if ((this.idEstatusProveedor == null && other.idEstatusProveedor != null) || (this.idEstatusProveedor != null && !this.idEstatusProveedor.equals(other.idEstatusProveedor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.com.oitic.deportextil.orm.EstatusProveedor[ idEstatusProveedor=" + idEstatusProveedor + " ]";
    }
    
}
