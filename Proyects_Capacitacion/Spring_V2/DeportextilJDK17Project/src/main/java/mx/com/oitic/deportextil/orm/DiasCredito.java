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
@Table(name = "dias_credito")
@NamedQueries({
    @NamedQuery(name = "DiasCredito.findAll", query = "SELECT d FROM DiasCredito d")})
public class DiasCredito implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_dias_credito")
    private String idDiasCredito;
    @Basic(optional = false)
    @Column(name = "dias_credito")
    private String diasCredito;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "diasCredito", fetch = FetchType.LAZY)
    private Set<Cliente> clienteSet;

    public DiasCredito() {
    }

    public DiasCredito(String idDiasCredito) {
        this.idDiasCredito = idDiasCredito;
    }

    public DiasCredito(String idDiasCredito, String diasCredito) {
        this.idDiasCredito = idDiasCredito;
        this.diasCredito = diasCredito;
    }

    public String getIdDiasCredito() {
        return idDiasCredito;
    }

    public void setIdDiasCredito(String idDiasCredito) {
        this.idDiasCredito = idDiasCredito;
    }

    public String getDiasCredito() {
        return diasCredito;
    }

    public void setDiasCredito(String diasCredito) {
        this.diasCredito = diasCredito;
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
        hash += (idDiasCredito != null ? idDiasCredito.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DiasCredito)) {
            return false;
        }
        DiasCredito other = (DiasCredito) object;
        if ((this.idDiasCredito == null && other.idDiasCredito != null) || (this.idDiasCredito != null && !this.idDiasCredito.equals(other.idDiasCredito))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.com.oitic.deportextil.orm.DiasCredito[ idDiasCredito=" + idDiasCredito + " ]";
    }
    
}
