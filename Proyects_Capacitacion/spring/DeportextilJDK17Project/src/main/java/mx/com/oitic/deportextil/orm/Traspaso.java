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
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
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
@Table(name = "traspaso")
@NamedQueries({
    @NamedQuery(name = "Traspaso.findAll", query = "SELECT t FROM Traspaso t")})
public class Traspaso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_traspaso")
    private Integer idTraspaso;
    @Column(name = "enruta")
    private Integer enruta;
    @Column(name = "fecha_recibido")
    @Temporal(TemporalType.DATE)
    private Date fechaRecibido;
    @Basic(optional = false)
    @Column(name = "fecha_traspaso")
    @Temporal(TemporalType.DATE)
    private Date fechaTraspaso;
    @Column(name = "id_pedido")
    private Integer idPedido;
    @JoinTable(name = "articulo_traspaso", joinColumns = {
        @JoinColumn(name = "id_traspaso", referencedColumnName = "id_traspaso")}, inverseJoinColumns = {
        @JoinColumn(name = "id_pieza", referencedColumnName = "id_pieza")})
    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Pieza> piezaSet;
    @JoinColumn(name = "id_sucursal_destino", referencedColumnName = "id_sucursal")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Sucursal sucursal;
    @JoinColumn(name = "id_sucursal_origen", referencedColumnName = "id_sucursal")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Sucursal sucursal1;
    @OneToMany(mappedBy = "traspaso", fetch = FetchType.LAZY)
    private Set<Traspaso> traspasoSet;
    @JoinColumn(name = "id_traspaso_padre", referencedColumnName = "id_traspaso")
    @ManyToOne(fetch = FetchType.LAZY)
    private Traspaso traspaso;

    public Traspaso() {
    }

    public Traspaso(Integer idTraspaso) {
        this.idTraspaso = idTraspaso;
    }

    public Traspaso(Integer idTraspaso, Date fechaTraspaso) {
        this.idTraspaso = idTraspaso;
        this.fechaTraspaso = fechaTraspaso;
    }

    public Integer getIdTraspaso() {
        return idTraspaso;
    }

    public void setIdTraspaso(Integer idTraspaso) {
        this.idTraspaso = idTraspaso;
    }

    public Integer getEnruta() {
        return enruta;
    }

    public void setEnruta(Integer enruta) {
        this.enruta = enruta;
    }

    public Date getFechaRecibido() {
        return fechaRecibido;
    }

    public void setFechaRecibido(Date fechaRecibido) {
        this.fechaRecibido = fechaRecibido;
    }

    public Date getFechaTraspaso() {
        return fechaTraspaso;
    }

    public void setFechaTraspaso(Date fechaTraspaso) {
        this.fechaTraspaso = fechaTraspaso;
    }

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public Set<Pieza> getPiezaSet() {
        return piezaSet;
    }

    public void setPiezaSet(Set<Pieza> piezaSet) {
        this.piezaSet = piezaSet;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public Sucursal getSucursal1() {
        return sucursal1;
    }

    public void setSucursal1(Sucursal sucursal1) {
        this.sucursal1 = sucursal1;
    }

    public Set<Traspaso> getTraspasoSet() {
        return traspasoSet;
    }

    public void setTraspasoSet(Set<Traspaso> traspasoSet) {
        this.traspasoSet = traspasoSet;
    }

    public Traspaso getTraspaso() {
        return traspaso;
    }

    public void setTraspaso(Traspaso traspaso) {
        this.traspaso = traspaso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTraspaso != null ? idTraspaso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Traspaso)) {
            return false;
        }
        Traspaso other = (Traspaso) object;
        if ((this.idTraspaso == null && other.idTraspaso != null) || (this.idTraspaso != null && !this.idTraspaso.equals(other.idTraspaso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.com.oitic.deportextil.orm.Traspaso[ idTraspaso=" + idTraspaso + " ]";
    }
    
}
