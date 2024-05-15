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
@Table(name = "regimen_fiscal")
@NamedQueries({
    @NamedQuery(name = "RegimenFiscal.findAll", query = "SELECT r FROM RegimenFiscal r")})
public class RegimenFiscal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_regimen_fiscal")
    private Integer idRegimenFiscal;
    @Basic(optional = false)
    @Column(name = "clave_sat")
    private int claveSat;
    @Basic(optional = false)
    @Column(name = "regimen_fiscal")
    private String regimenFiscal;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "regimenFiscal", fetch = FetchType.LAZY)
    private Set<Cliente> clienteSet;

    public RegimenFiscal() {
    }

    public RegimenFiscal(Integer idRegimenFiscal) {
        this.idRegimenFiscal = idRegimenFiscal;
    }

    public RegimenFiscal(Integer idRegimenFiscal, int claveSat, String regimenFiscal) {
        this.idRegimenFiscal = idRegimenFiscal;
        this.claveSat = claveSat;
        this.regimenFiscal = regimenFiscal;
    }

    public Integer getIdRegimenFiscal() {
        return idRegimenFiscal;
    }

    public void setIdRegimenFiscal(Integer idRegimenFiscal) {
        this.idRegimenFiscal = idRegimenFiscal;
    }

    public int getClaveSat() {
        return claveSat;
    }

    public void setClaveSat(int claveSat) {
        this.claveSat = claveSat;
    }

    public String getRegimenFiscal() {
        return regimenFiscal;
    }

    public void setRegimenFiscal(String regimenFiscal) {
        this.regimenFiscal = regimenFiscal;
    }

    public Set<Cliente> getClienteSet() {
        return clienteSet;
    }

    public void setClienteSet(Set<Cliente> clienteSet) {
        this.clienteSet = clienteSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRegimenFiscal != null ? idRegimenFiscal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RegimenFiscal)) {
            return false;
        }
        RegimenFiscal other = (RegimenFiscal) object;
        if ((this.idRegimenFiscal == null && other.idRegimenFiscal != null) || (this.idRegimenFiscal != null && !this.idRegimenFiscal.equals(other.idRegimenFiscal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.com.oitic.deportextil.orm.RegimenFiscal[ idRegimenFiscal=" + idRegimenFiscal + " ]";
    }
    
}
