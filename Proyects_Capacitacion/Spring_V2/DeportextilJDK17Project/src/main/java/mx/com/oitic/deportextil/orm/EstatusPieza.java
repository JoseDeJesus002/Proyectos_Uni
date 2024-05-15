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
@Table(name = "estatus_pieza")
@NamedQueries({
    @NamedQuery(name = "EstatusPieza.findAll", query = "SELECT e FROM EstatusPieza e")})
public class EstatusPieza implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_estatus_pieza")
    private Integer idEstatusPieza;
    @Basic(optional = false)
    @Column(name = "estatus_pieza")
    private String estatusPieza;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estatusPieza", fetch = FetchType.LAZY)
    private Set<Pieza> piezaSet;

    public EstatusPieza() {
    }

    public EstatusPieza(Integer idEstatusPieza) {
        this.idEstatusPieza = idEstatusPieza;
    }

    public EstatusPieza(Integer idEstatusPieza, String estatusPieza) {
        this.idEstatusPieza = idEstatusPieza;
        this.estatusPieza = estatusPieza;
    }

    public Integer getIdEstatusPieza() {
        return idEstatusPieza;
    }

    public void setIdEstatusPieza(Integer idEstatusPieza) {
        this.idEstatusPieza = idEstatusPieza;
    }

    public String getEstatusPieza() {
        return estatusPieza;
    }

    public void setEstatusPieza(String estatusPieza) {
        this.estatusPieza = estatusPieza;
    }

    public Set<Pieza> getPiezaSet() {
        return piezaSet;
    }

    public void setPiezaSet(Set<Pieza> piezaSet) {
        this.piezaSet = piezaSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstatusPieza != null ? idEstatusPieza.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstatusPieza)) {
            return false;
        }
        EstatusPieza other = (EstatusPieza) object;
        if ((this.idEstatusPieza == null && other.idEstatusPieza != null) || (this.idEstatusPieza != null && !this.idEstatusPieza.equals(other.idEstatusPieza))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.com.oitic.deportextil.orm.EstatusPieza[ idEstatusPieza=" + idEstatusPieza + " ]";
    }
    
}
