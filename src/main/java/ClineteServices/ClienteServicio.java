package ClineteServices;

import ClienteDTO.ClientesDto;
import ClienteEntity.Cliente;
import ClienteRepository.YRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
@Service
public class ClienteServicio {
    @Autowired
    private YRepository YRepositity;


    @Transactional(readOnly = true)
    public List<Cliente> findAll(){

        return (List<Cliente>)YRepositity.findAll();
    }

    //consulta por id
    @Transactional (readOnly = true)
    public Cliente findById(Long id){
        return (Cliente) YRepositity.findById(id).orElse(null);
    }
    //nuevo cliente
    public Cliente crearcliente(ClientesDto cliente){
        Cliente clienteEntity= new Cliente();
        clienteEntity.setNombre(cliente.getNombre());
        clienteEntity.setApellido(cliente.getApellido());
        clienteEntity.setEmail(cliente.getEmail());
        return YRepositity.save(clienteEntity);
    }
    //eliminar cliente
    public void delete(Long id){
        YRepositity.deleteById(id);
    }
}
