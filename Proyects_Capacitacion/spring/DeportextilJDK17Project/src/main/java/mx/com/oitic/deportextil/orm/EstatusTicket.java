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
@Table(name = "estatus_ticket")
@NamedQueries({
    @NamedQuery(name = "EstatusTicket.findAll", query = "SELECT e FROM EstatusTicket e")})
public class EstatusTicket implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_estatus_ticket")
    private String idEstatusTicket;
    @Basic(optional = false)
    @Column(name = "estatus_ticket")
    private String estatusTicket;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estatusTicket", fetch = FetchType.LAZY)
    private Set<Ticket> ticketSet;

    public EstatusTicket() {
    }

    public EstatusTicket(String idEstatusTicket) {
        this.idEstatusTicket = idEstatusTicket;
    }

    public EstatusTicket(String idEstatusTicket, String estatusTicket) {
        this.idEstatusTicket = idEstatusTicket;
        this.estatusTicket = estatusTicket;
    }

    public String getIdEstatusTicket() {
        return idEstatusTicket;
    }

    public void setIdEstatusTicket(String idEstatusTicket) {
        this.idEstatusTicket = idEstatusTicket;
    }

    public String getEstatusTicket() {
        return estatusTicket;
    }

    public void setEstatusTicket(String estatusTicket) {
        this.estatusTicket = estatusTicket;
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
        hash += (idEstatusTicket != null ? idEstatusTicket.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstatusTicket)) {
            return false;
        }
        EstatusTicket other = (EstatusTicket) object;
        if ((this.idEstatusTicket == null && other.idEstatusTicket != null) || (this.idEstatusTicket != null && !this.idEstatusTicket.equals(other.idEstatusTicket))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.com.oitic.deportextil.orm.EstatusTicket[ idEstatusTicket=" + idEstatusTicket + " ]";
    }
    
}
