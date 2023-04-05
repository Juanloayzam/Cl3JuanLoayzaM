package CL3.LoayzaMuzanteJuan.Service;

import CL3.LoayzaMuzanteJuan.Domain.Cliente;
import java.util.List;

/**
 *
 * @author JLOAYZA
 */

public interface ClienteService {
    
    public List<Cliente> listarClientes();
    
    public void guardar(Cliente cliente);
    
    public void eliminar(Cliente cliente);
    
    public Cliente buscarCliente(Cliente cliente);
    
}
