/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.oitic.deportextil.orm;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToOne;
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
@Table(name = "personal_seguridad")
@NamedQueries({
    @NamedQuery(name = "PersonalSeguridad.findAll", query = "SELECT p FROM PersonalSeguridad p")})
public class PersonalSeguridad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_usuario")
    private String idUsuario;
    @Basic(optional = false)
    @Column(name = "contrasenna")
    private String contrasenna;
    @Basic(optional = false)
    @Column(name = "credencial_no_expirada")
    private boolean credencialNoExpirada;
    @Basic(optional = false)
    @Column(name = "cuenta_no_bloqueada")
    private boolean cuentaNoBloqueada;
    @Basic(optional = false)
    @Column(name = "cuenta_no_expirada")
    private boolean cuentaNoExpirada;
    @Basic(optional = false)
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @Basic(optional = false)
    @Column(name = "habilitado")
    private boolean habilitado;
    @Basic(optional = false)
    @Column(name = "intentos_fallidos")
    private short intentosFallidos;
    @Basic(optional = false)
    @Column(name = "pregunta_secreta")
    private String preguntaSecreta;
    @Basic(optional = false)
    @Column(name = "respuesta_secreta")
    private String respuestaSecreta;
    @Basic(optional = false)
    @Column(name = "user_name")
    private String userName;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario", insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private Usuario usuario;

    public PersonalSeguridad() {
    }

    public PersonalSeguridad(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public PersonalSeguridad(String idUsuario, String contrasenna, boolean credencialNoExpirada, boolean cuentaNoBloqueada, boolean cuentaNoExpirada, Date fechaCreacion, boolean habilitado, short intentosFallidos, String preguntaSecreta, String respuestaSecreta, String userName) {
        this.idUsuario = idUsuario;
        this.contrasenna = contrasenna;
        this.credencialNoExpirada = credencialNoExpirada;
        this.cuentaNoBloqueada = cuentaNoBloqueada;
        this.cuentaNoExpirada = cuentaNoExpirada;
        this.fechaCreacion = fechaCreacion;
        this.habilitado = habilitado;
        this.intentosFallidos = intentosFallidos;
        this.preguntaSecreta = preguntaSecreta;
        this.respuestaSecreta = respuestaSecreta;
        this.userName = userName;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getContrasenna() {
        return contrasenna;
    }

    public void setContrasenna(String contrasenna) {
        this.contrasenna = contrasenna;
    }

    public boolean getCredencialNoExpirada() {
        return credencialNoExpirada;
    }

    public void setCredencialNoExpirada(boolean credencialNoExpirada) {
        this.credencialNoExpirada = credencialNoExpirada;
    }

    public boolean getCuentaNoBloqueada() {
        return cuentaNoBloqueada;
    }

    public void setCuentaNoBloqueada(boolean cuentaNoBloqueada) {
        this.cuentaNoBloqueada = cuentaNoBloqueada;
    }

    public boolean getCuentaNoExpirada() {
        return cuentaNoExpirada;
    }

    public void setCuentaNoExpirada(boolean cuentaNoExpirada) {
        this.cuentaNoExpirada = cuentaNoExpirada;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public boolean getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }

    public short getIntentosFallidos() {
        return intentosFallidos;
    }

    public void setIntentosFallidos(short intentosFallidos) {
        this.intentosFallidos = intentosFallidos;
    }

    public String getPreguntaSecreta() {
        return preguntaSecreta;
    }

    public void setPreguntaSecreta(String preguntaSecreta) {
        this.preguntaSecreta = preguntaSecreta;
    }

    public String getRespuestaSecreta() {
        return respuestaSecreta;
    }

    public void setRespuestaSecreta(String respuestaSecreta) {
        this.respuestaSecreta = respuestaSecreta;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonalSeguridad)) {
            return false;
        }
        PersonalSeguridad other = (PersonalSeguridad) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.com.oitic.deportextil.orm.PersonalSeguridad[ idUsuario=" + idUsuario + " ]";
    }
    
}
