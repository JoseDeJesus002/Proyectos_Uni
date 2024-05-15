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
@Table(name = "pieza")
@NamedQueries({
    @NamedQuery(name = "Pieza.findAll", query = "SELECT p FROM Pieza p")})
public class Pieza implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_pieza")
    private Integer idPieza;
    @Column(name = "acrilan")
    private String acrilan;
    @Column(name = "algodon")
    private String algodon;
    @Basic(optional = false)
    @Column(name = "cantidad")
    private double cantidad;
    @Basic(optional = false)
    @Column(name = "costo")
    private double costo;
    @Column(name = "elastano")
    private String elastano;
    @Basic(optional = false)
    @Column(name = "fecha_ingreso")
    @Temporal(TemporalType.DATE)
    private Date fechaIngreso;
    @Column(name = "fecha_saparicion")
    @Temporal(TemporalType.DATE)
    private Date fechaSaparicion;
    @Column(name = "nylon")
    private String nylon;
    @Column(name = "pais")
    private String pais;
    @Column(name = "poliester")
    private String poliester;
    @Basic(optional = false)
    @Column(name = "id_bodega_actual")
    private int idBodegaActual;
    @Basic(optional = false)
    @Column(name = "id_bodega_ingreso")
    private int idBodegaIngreso;
    @Basic(optional = false)
    @Column(name = "id_compra")
    private int idCompra;
    @ManyToMany(mappedBy = "piezaSet", fetch = FetchType.LAZY)
    private Set<Traspaso> traspasoSet;
    @JoinColumn(name = "id_color", referencedColumnName = "id_color")
    @ManyToOne(fetch = FetchType.LAZY)
    private Color color;
    @JoinColumn(name = "id_estatus_pieza", referencedColumnName = "id_estatus_pieza")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EstatusPieza estatusPieza;
    @JoinColumn(name = "id_tipo_articulo", referencedColumnName = "id_tipo_articulo")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TipoArticulo tipoArticulo;

    public Pieza() {
    }

    public Pieza(Integer idPieza) {
        this.idPieza = idPieza;
    }

    public Pieza(Integer idPieza, double cantidad, double costo, Date fechaIngreso, int idBodegaActual, int idBodegaIngreso, int idCompra) {
        this.idPieza = idPieza;
        this.cantidad = cantidad;
        this.costo = costo;
        this.fechaIngreso = fechaIngreso;
        this.idBodegaActual = idBodegaActual;
        this.idBodegaIngreso = idBodegaIngreso;
        this.idCompra = idCompra;
    }

    public Integer getIdPieza() {
        return idPieza;
    }

    public void setIdPieza(Integer idPieza) {
        this.idPieza = idPieza;
    }

    public String getAcrilan() {
        return acrilan;
    }

    public void setAcrilan(String acrilan) {
        this.acrilan = acrilan;
    }

    public String getAlgodon() {
        return algodon;
    }

    public void setAlgodon(String algodon) {
        this.algodon = algodon;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public String getElastano() {
        return elastano;
    }

    public void setElastano(String elastano) {
        this.elastano = elastano;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Date getFechaSaparicion() {
        return fechaSaparicion;
    }

    public void setFechaSaparicion(Date fechaSaparicion) {
        this.fechaSaparicion = fechaSaparicion;
    }

    public String getNylon() {
        return nylon;
    }

    public void setNylon(String nylon) {
        this.nylon = nylon;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getPoliester() {
        return poliester;
    }

    public void setPoliester(String poliester) {
        this.poliester = poliester;
    }

    public int getIdBodegaActual() {
        return idBodegaActual;
    }

    public void setIdBodegaActual(int idBodegaActual) {
        this.idBodegaActual = idBodegaActual;
    }

    public int getIdBodegaIngreso() {
        return idBodegaIngreso;
    }

    public void setIdBodegaIngreso(int idBodegaIngreso) {
        this.idBodegaIngreso = idBodegaIngreso;
    }

    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public Set<Traspaso> getTraspasoSet() {
        return traspasoSet;
    }

    public void setTraspasoSet(Set<Traspaso> traspasoSet) {
        this.traspasoSet = traspasoSet;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public EstatusPieza getEstatusPieza() {
        return estatusPieza;
    }

    public void setEstatusPieza(EstatusPieza estatusPieza) {
        this.estatusPieza = estatusPieza;
    }

    public TipoArticulo getTipoArticulo() {
        return tipoArticulo;
    }

    public void setTipoArticulo(TipoArticulo tipoArticulo) {
        this.tipoArticulo = tipoArticulo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPieza != null ? idPieza.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pieza)) {
            return false;
        }
        Pieza other = (Pieza) object;
        if ((this.idPieza == null && other.idPieza != null) || (this.idPieza != null && !this.idPieza.equals(other.idPieza))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.com.oitic.deportextil.orm.Pieza[ idPieza=" + idPieza + " ]";
    }
    
}
