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
@Table(name = "tipo_auditoria")
@NamedQueries({
    @NamedQuery(name = "TipoAuditoria.findAll", query = "SELECT t FROM TipoAuditoria t")})
public class TipoAuditoria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_auditoria")
    private Integer idTipoAuditoria;
    @Basic(optional = false)
    @Column(name = "tipo_auditoria")
    private String tipoAuditoria;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoAuditoria", fetch = FetchType.LAZY)
    private Set<Auditoria> auditoriaSet;

    public TipoAuditoria() {
    }

    public TipoAuditoria(Integer idTipoAuditoria) {
        this.idTipoAuditoria = idTipoAuditoria;
    }

    public TipoAuditoria(Integer idTipoAuditoria, String tipoAuditoria) {
        this.idTipoAuditoria = idTipoAuditoria;
        this.tipoAuditoria = tipoAuditoria;
    }

    public Integer getIdTipoAuditoria() {
        return idTipoAuditoria;
    }

    public void setIdTipoAuditoria(Integer idTipoAuditoria) {
        this.idTipoAuditoria = idTipoAuditoria;
    }

    public String getTipoAuditoria() {
        return tipoAuditoria;
    }

    public void setTipoAuditoria(String tipoAuditoria) {
        this.tipoAuditoria = tipoAuditoria;
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
        hash += (idTipoAuditoria != null ? idTipoAuditoria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoAuditoria)) {
            return false;
        }
        TipoAuditoria other = (TipoAuditoria) object;
        if ((this.idTipoAuditoria == null && other.idTipoAuditoria != null) || (this.idTipoAuditoria != null && !this.idTipoAuditoria.equals(other.idTipoAuditoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.com.oitic.deportextil.orm.TipoAuditoria[ idTipoAuditoria=" + idTipoAuditoria + " ]";
    }
    
}
