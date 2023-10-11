package ClienteController;
import ClienteDTO.ClientesDto;
import ClienteEntity.Cliente;
import ClineteServices.ClienteServicio;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RequestMapping("/api")
@RestController
public class Clientes_controller {

    private ClienteServicio clienteServicio;

    //consulta  el Cliente por id especifico

    @GetMapping("/clientes")
    @ResponseStatus(HttpStatus.OK)
    public List<Cliente> consulta(){

        return clienteServicio.findAll();
    }

    @GetMapping("/clientes/{id}")
    public ResponseEntity<?> consultaPorID(@PathVariable Long id){
        Cliente cliente=null;
        String response="";

        try {
            cliente= clienteServicio.findById(id);
        }catch (DataAccessException e){
            response="error en la consulta";
            response= response.concat(e.getMessage().concat(e.getMostSpecificCause().toString()));
            return new ResponseEntity<String>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if (cliente== null){
            response = "El Cliente con el id: ".concat(id.toString()).concat("No existe en la base de datos");
            return new ResponseEntity<String>(response, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
    }

    ///elimina el clienete id especifico
    @DeleteMapping("/cliente/{id}")
    public ResponseEntity<?>delete(@PathVariable Long id){

        Map<String, Object> response= new HashMap<>();
        try{
            Cliente clienteDelete= this.clienteServicio.findById(id);
            if (clienteDelete==null){
                response.put("mensjae", "error al eliminar. El Cliente no existe en la base de datos ");
                return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
            clienteServicio.delete(id);
        }catch (DataAccessException e){
            response.put("mensaje","error al eliminarlo en la base de datos");
            response.put("error", e.getMessage().concat(e.getMostSpecificCause().getLocalizedMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
        }
        response.put("mensjae", "Cliente eliminado con exito");
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }


    ///insertar id

    @GetMapping("/clientes")
    public ResponseEntity<?> create(@RequestBody ClientesDto clientes){
        Cliente clientenew=null;
        Map<String, Object> response= new HashMap<>();

        try {
            clientenew = this.clienteServicio.crearcliente(clientes);
        }catch (DataAccessException e){
            response.put("mensaje","error en la inserccion");
            response.put("error", e.getMessage().concat(e.getMostSpecificCause().toString()));
            return new ResponseEntity<Map<String, Object> >(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "Cliente insertado con exito, con el id");
        response.put("cliente", clientenew);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);

    }

}