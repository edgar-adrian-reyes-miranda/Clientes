package ClienteEntity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;


import java.util.Date;

@Entity
@Table(name="clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private Date createAt;
    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name= "tipoCliente_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private TipoCliente tipoCliente;

    public Cliente(){}

    public Cliente(String nombre, String apellido, String email, Date createAt) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.createAt = createAt;
    }

    public TipoCliente getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(TipoCliente tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    @Column (name = "Fecha_creacion")


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }

}
