package ClienteEntity;
import jakarta.persistence.*;


@Entity
@Table(name= "tipo_cliente")
public class TipoCliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private  Long id;
    @Column(name="tipo_cliente")
    private String tipoCliente;



    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
