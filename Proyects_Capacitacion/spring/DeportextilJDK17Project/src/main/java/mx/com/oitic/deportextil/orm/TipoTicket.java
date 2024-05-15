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
@Table(name = "tipo_ticket")
@NamedQueries({
    @NamedQuery(name = "TipoTicket.findAll", query = "SELECT t FROM TipoTicket t")})
public class TipoTicket implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_ticket")
    private Integer idTipoTicket;
    @Basic(optional = false)
    @Column(name = "codigo_tecla")
    private int codigoTecla;
    @Basic(optional = false)
    @Column(name = "diferenciador")
    private String diferenciador;
    @Basic(optional = false)
    @Column(name = "tipo_ticket")
    private String tipoTicket;
    @Basic(optional = false)
    @Column(name = "usado_sucursal")
    private int usadoSucursal;
    @Column(name = "empresa")
    private String empresa;
    @OneToMany(mappedBy = "tipoTicket", fetch = FetchType.LAZY)
    private Set<Ticket> ticketSet;

    public TipoTicket() {
    }

    public TipoTicket(Integer idTipoTicket) {
        this.idTipoTicket = idTipoTicket;
    }

    public TipoTicket(Integer idTipoTicket, int codigoTecla, String diferenciador, String tipoTicket, int usadoSucursal) {
        this.idTipoTicket = idTipoTicket;
        this.codigoTecla = codigoTecla;
        this.diferenciador = diferenciador;
        this.tipoTicket = tipoTicket;
        this.usadoSucursal = usadoSucursal;
    }

    public Integer getIdTipoTicket() {
        return idTipoTicket;
    }

    public void setIdTipoTicket(Integer idTipoTicket) {
        this.idTipoTicket = idTipoTicket;
    }

    public int getCodigoTecla() {
        return codigoTecla;
    }

    public void setCodigoTecla(int codigoTecla) {
        this.codigoTecla = codigoTecla;
    }

    public String getDiferenciador() {
        return diferenciador;
    }

    public void setDiferenciador(String diferenciador) {
        this.diferenciador = diferenciador;
    }

    public String getTipoTicket() {
        return tipoTicket;
    }

    public void setTipoTicket(String tipoTicket) {
        this.tipoTicket = tipoTicket;
    }

    public int getUsadoSucursal() {
        return usadoSucursal;
    }

    public void setUsadoSucursal(int usadoSucursal) {
        this.usadoSucursal = usadoSucursal;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public Set<Ticket> getTicketSet() {
        return ticketSet;
    }

    public void setTicketSet(Set<Ticket> ticketSet) {
        this.ticketSet = ticketSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoTicket != null ? idTipoTicket.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoTicket)) {
            return false;
        }
        TipoTicket other = (TipoTicket) object;
        if ((this.idTipoTicket == null && other.idTipoTicket != null) || (this.idTipoTicket != null && !this.idTipoTicket.equals(other.idTipoTicket))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.com.oitic.deportextil.orm.TipoTicket[ idTipoTicket=" + idTipoTicket + " ]";
    }
    
}
