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
@Table(name = "estatus_auditoria")
@NamedQueries({
    @NamedQuery(name = "EstatusAuditoria.findAll", query = "SELECT e FROM EstatusAuditoria e")})
public class EstatusAuditoria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_estatus_auditoria")
    private Integer idEstatusAuditoria;
    @Basic(optional = false)
    @Column(name = "estatus_auditoria")
    private String estatusAuditoria;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estatusAuditoria", fetch = FetchType.LAZY)
    private Set<Auditoria> auditoriaSet;

    public EstatusAuditoria() {
    }

    public EstatusAuditoria(Integer idEstatusAuditoria) {
        this.idEstatusAuditoria = idEstatusAuditoria;
    }

    public EstatusAuditoria(Integer idEstatusAuditoria, String estatusAuditoria) {
        this.idEstatusAuditoria = idEstatusAuditoria;
        this.estatusAuditoria = estatusAuditoria;
    }

    public Integer getIdEstatusAuditoria() {
        return idEstatusAuditoria;
    }

    public void setIdEstatusAuditoria(Integer idEstatusAuditoria) {
        this.idEstatusAuditoria = idEstatusAuditoria;
    }

    public String getEstatusAuditoria() {
        return estatusAuditoria;
    }

    public void setEstatusAuditoria(String estatusAuditoria) {
        this.estatusAuditoria = estatusAuditoria;
    }

    public Set<Auditoria> getAuditoriaSet() {
        return auditoriaSet;
    }

    public void setAuditoriaSet(Set<Auditoria> auditoriaSet) {
        this.auditoriaSet = auditoriaSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstatusAuditoria != null ? idEstatusAuditoria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstatusAuditoria)) {
            return false;
        }
        EstatusAuditoria other = (EstatusAuditoria) object;
        if ((this.idEstatusAuditoria == null && other.idEstatusAuditoria != null) || (this.idEstatusAuditoria != null && !this.idEstatusAuditoria.equals(other.idEstatusAuditoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.com.oitic.deportextil.orm.EstatusAuditoria[ idEstatusAuditoria=" + idEstatusAuditoria + " ]";
    }
    
}
