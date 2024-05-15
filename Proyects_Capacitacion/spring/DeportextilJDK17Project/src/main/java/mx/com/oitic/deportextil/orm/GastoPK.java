/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.oitic.deportextil.orm;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;

/**
 *
 * @author Hp
 */
@Embeddable
public class GastoPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_gasto")
    private long idGasto;
    @Basic(optional = false)
    @Column(name = "id_sucursal")
    private String idSucursal;

    public GastoPK() {
    }

    public GastoPK(long idGasto, String idSucursal) {
        this.idGasto = idGasto;
        this.idSucursal = idSucursal;
    }

    public long getIdGasto() {
        return idGasto;
    }

    public void setIdGasto(long idGasto) {
        this.idGasto = idGasto;
    }

    public String getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(String idSucursal) {
        this.idSucursal = idSucursal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idGasto;
        hash += (idSucursal != null ? idSucursal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GastoPK)) {
            return false;
        }
        GastoPK other = (GastoPK) object;
        if (this.idGasto != other.idGasto) {
            return false;
        }
        if ((this.idSucursal == null && other.idSucursal != null) || (this.idSucursal != null && !this.idSucursal.equals(other.idSucursal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.com.oitic.deportextil.orm.GastoPK[ idGasto=" + idGasto + ", idSucursal=" + idSucursal + " ]";
    }
    
}
