package CL3.LoayzaMuzanteJuan.Service;

import CL3.LoayzaMuzanteJuan.Dao.ClienteDao;
import CL3.LoayzaMuzanteJuan.Domain.Cliente;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ClienteServiceImpl implements ClienteService{
    @Autowired
    private ClienteDao clienteDao;
    
    @Override
    @Transactional(readOnly =true)
    public List<Cliente> listarClientes(){
        return (List<Cliente>) clienteDao.findAll();
    }
    
    @Override
    public void guardar(Cliente cliente){
        clienteDao.save(cliente);
    }
    
    @Override
    public void eliminar(Cliente cliente){
        clienteDao.delete(cliente);
    }
    
    @Override
    @Transactional(readOnly = true)
    public Cliente buscarCliente(Cliente cliente){
        return clienteDao.findById(cliente.getCli_id()).orElse(null);
    }
}
