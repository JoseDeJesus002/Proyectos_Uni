/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.oitic.deportextil.orm;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Hp
 */
@Entity
@Table(name = "traspaso_padre")
@NamedQueries({
    @NamedQuery(name = "TraspasoPadre.findAll", query = "SELECT t FROM TraspasoPadre t")})
public class TraspasoPadre implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_traspaso_padre")
    private Integer idTraspasoPadre;
    @Column(name = "fecha_recibido")
    @Temporal(TemporalType.DATE)
    private Date fechaRecibido;
    @Basic(optional = false)
    @Column(name = "fecha_traspaso")
    @Temporal(TemporalType.DATE)
    private Date fechaTraspaso;
    @Basic(optional = false)
    @Column(name = "id_bodega_desde")
    private int idBodegaDesde;
    @Basic(optional = false)
    @Column(name = "id_bodega_hasta")
    private int idBodegaHasta;

    public TraspasoPadre() {
    }

    public TraspasoPadre(Integer idTraspasoPadre) {
        this.idTraspasoPadre = idTraspasoPadre;
    }

    public TraspasoPadre(Integer idTraspasoPadre, Date fechaTraspaso, int idBodegaDesde, int idBodegaHasta) {
        this.idTraspasoPadre = idTraspasoPadre;
        this.fechaTraspaso = fechaTraspaso;
        this.idBodegaDesde = idBodegaDesde;
        this.idBodegaHasta = idBodegaHasta;
    }

    public Integer getIdTraspasoPadre() {
        return idTraspasoPadre;
    }

    public void setIdTraspasoPadre(Integer idTraspasoPadre) {
        this.idTraspasoPadre = idTraspasoPadre;
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

    public int getIdBodegaDesde() {
        return idBodegaDesde;
    }

    public void setIdBodegaDesde(int idBodegaDesde) {
        this.idBodegaDesde = idBodegaDesde;
    }

    public int getIdBodegaHasta() {
        return idBodegaHasta;
    }

    public void setIdBodegaHasta(int idBodegaHasta) {
        this.idBodegaHasta = idBodegaHasta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTraspasoPadre != null ? idTraspasoPadre.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TraspasoPadre)) {
            return false;
        }
        TraspasoPadre other = (TraspasoPadre) object;
        if ((this.idTraspasoPadre == null && other.idTraspasoPadre != null) || (this.idTraspasoPadre != null && !this.idTraspasoPadre.equals(other.idTraspasoPadre))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.com.oitic.deportextil.orm.TraspasoPadre[ idTraspasoPadre=" + idTraspasoPadre + " ]";
    }
    
}
