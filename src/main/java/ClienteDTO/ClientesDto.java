package ClienteDTO;

import java.io.Serializable;
import java.util.Date;

public class ClientesDto implements Serializable {
    private static  final long serialVersionUID = 1L;
    private String nombre;
    private String apellido;
    private String email;
    private Date createAt;

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

}

