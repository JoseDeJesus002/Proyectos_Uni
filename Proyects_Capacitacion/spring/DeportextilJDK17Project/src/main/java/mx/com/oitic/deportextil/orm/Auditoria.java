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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 *
 * @author Hp
 */
@Entity
@Table(name = "auditoria")
@NamedQueries({
    @NamedQuery(name = "Auditoria.findAll", query = "SELECT a FROM Auditoria a")})
public class Auditoria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_auditoria")
    private Integer idAuditoria;
    @Basic(optional = false)
    @Column(name = "fecha_auditoria")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAuditoria;
    @ManyToMany(mappedBy = "auditoriaSet", fetch = FetchType.LAZY)
    private Set<TipoArticulo> tipoArticuloSet;
    @JoinColumn(name = "id_estatus_auditoria", referencedColumnName = "id_estatus_auditoria")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EstatusAuditoria estatusAuditoria;
    @JoinColumn(name = "id_sucursal", referencedColumnName = "id_sucursal")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Sucursal sucursal;
    @JoinColumn(name = "id_tipo_auditoria", referencedColumnName = "id_tipo_auditoria")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TipoAuditoria tipoAuditoria;

    public Auditoria() {
    }

    public Auditoria(Integer idAuditoria) {
        this.idAuditoria = idAuditoria;
    }

    public Auditoria(Integer idAuditoria, Date fechaAuditoria) {
        this.idAuditoria = idAuditoria;
        this.fechaAuditoria = fechaAuditoria;
    }

    public Integer getIdAuditoria() {
        return idAuditoria;
    }

    public void setIdAuditoria(Integer idAuditoria) {
        this.idAuditoria = idAuditoria;
    }

    public Date getFechaAuditoria() {
        return fechaAuditoria;
    }

    public void setFechaAuditoria(Date fechaAuditoria) {
        this.fechaAuditoria = fechaAuditoria;
    }

    public Set<TipoArticulo> getTipoArticuloSet() {
        return tipoArticuloSet;
    }

    public void setTipoArticuloSet(Set<TipoArticulo> tipoArticuloSet) {
        this.tipoArticuloSet = tipoArticuloSet;
    }

    public EstatusAuditoria getEstatusAuditoria() {
        return estatusAuditoria;
    }

    public void setEstatusAuditoria(EstatusAuditoria estatusAuditoria) {
        this.estatusAuditoria = estatusAuditoria;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public TipoAuditoria getTipoAuditoria() {
        return tipoAuditoria;
    }

    public void setTipoAuditoria(TipoAuditoria tipoAuditoria) {
        this.tipoAuditoria = tipoAuditoria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAuditoria != null ? idAuditoria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Auditoria)) {
            return false;
        }
        Auditoria other = (Auditoria) object;
        if ((this.idAuditoria == null && other.idAuditoria != null) || (this.idAuditoria != null && !this.idAuditoria.equals(other.idAuditoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.com.oitic.deportextil.orm.Auditoria[ idAuditoria=" + idAuditoria + " ]";
    }
    
}
