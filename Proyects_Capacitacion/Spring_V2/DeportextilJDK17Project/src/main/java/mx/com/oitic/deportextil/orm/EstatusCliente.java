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
@Table(name = "estatus_cliente")
@NamedQueries({
    @NamedQuery(name = "EstatusCliente.findAll", query = "SELECT e FROM EstatusCliente e")})
public class EstatusCliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_estatus_cliente")
    private Integer idEstatusCliente;
    @Basic(optional = false)
    @Column(name = "estatus_cliente")
    private String estatusCliente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estatusCliente", fetch = FetchType.LAZY)
    private Set<Cliente> clienteSet;

    public EstatusCliente() {
    }

    public EstatusCliente(Integer idEstatusCliente) {
        this.idEstatusCliente = idEstatusCliente;
    }

    public EstatusCliente(Integer idEstatusCliente, String estatusCliente) {
        this.idEstatusCliente = idEstatusCliente;
        this.estatusCliente = estatusCliente;
    }

    public Integer getIdEstatusCliente() {
        return idEstatusCliente;
    }

    public void setIdEstatusCliente(Integer idEstatusCliente) {
        this.idEstatusCliente = idEstatusCliente;
    }

    public String getEstatusCliente() {
        return estatusCliente;
    }

    public void setEstatusCliente(String estatusCliente) {
        this.estatusCliente = estatusCliente;
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
        hash += (idEstatusCliente != null ? idEstatusCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstatusCliente)) {
            return false;
        }
        EstatusCliente other = (EstatusCliente) object;
        if ((this.idEstatusCliente == null && other.idEstatusCliente != null) || (this.idEstatusCliente != null && !this.idEstatusCliente.equals(other.idEstatusCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.com.oitic.deportextil.orm.EstatusCliente[ idEstatusCliente=" + idEstatusCliente + " ]";
    }
    
}
