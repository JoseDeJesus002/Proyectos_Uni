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
@Table(name = "estatus_usuario")
@NamedQueries({
    @NamedQuery(name = "EstatusUsuario.findAll", query = "SELECT e FROM EstatusUsuario e")})
public class EstatusUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_estatus_usuario")
    private Integer idEstatusUsuario;
    @Basic(optional = false)
    @Column(name = "estatus_usuario")
    private String estatusUsuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estatusUsuario", fetch = FetchType.LAZY)
    private Set<Usuario> usuarioSet;

    public EstatusUsuario() {
    }

    public EstatusUsuario(Integer idEstatusUsuario) {
        this.idEstatusUsuario = idEstatusUsuario;
    }

    public EstatusUsuario(Integer idEstatusUsuario, String estatusUsuario) {
        this.idEstatusUsuario = idEstatusUsuario;
        this.estatusUsuario = estatusUsuario;
    }

    public Integer getIdEstatusUsuario() {
        return idEstatusUsuario;
    }

    public void setIdEstatusUsuario(Integer idEstatusUsuario) {
        this.idEstatusUsuario = idEstatusUsuario;
    }

    public String getEstatusUsuario() {
        return estatusUsuario;
    }

    public void setEstatusUsuario(String estatusUsuario) {
        this.estatusUsuario = estatusUsuario;
    }

    public Set<Usuario> getUsuarioSet() {
        return usuarioSet;
    }

    public void setUsuarioSet(Set<Usuario> usuarioSet) {
        this.usuarioSet = usuarioSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstatusUsuario != null ? idEstatusUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstatusUsuario)) {
            return false;
        }
        EstatusUsuario other = (EstatusUsuario) object;
        if ((this.idEstatusUsuario == null && other.idEstatusUsuario != null) || (this.idEstatusUsuario != null && !this.idEstatusUsuario.equals(other.idEstatusUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.com.oitic.deportextil.orm.EstatusUsuario[ idEstatusUsuario=" + idEstatusUsuario + " ]";
    }
    
}
