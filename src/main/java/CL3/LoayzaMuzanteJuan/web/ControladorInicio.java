package CL3.LoayzaMuzanteJuan.web;

import CL3.LoayzaMuzanteJuan.Domain.Cliente;
import CL3.LoayzaMuzanteJuan.Service.ClienteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class ControladorInicio {
    @Autowired
    private ClienteService clienteService;
    
    @GetMapping("/")
    public String inicio(Model model){
        var clientes =clienteService.listarClientes();
        model.addAttribute("Clientes", clientes);
        return "index";
    }
    
    @GetMapping("/agregar")
    public String agregar(Cliente cliente){
        return "modificar";
    }
    
    @PostMapping("/guardar")
    public String guardar(Cliente cliente){
        clienteService.guardar(cliente);
        return "redirect:/";
    }
    
    @GetMapping("/editar/{cli_id}")
    public String editar(Cliente cliente, Model model){
        cliente = clienteService.buscarCliente(cliente);
        model.addAttribute("cliente", cliente);
        return "modificar";
    }
    
    @GetMapping("/eliminar/{cli_id}")
    public String eliminar(Cliente cliente){
        clienteService.eliminar(cliente);
        return "redirect:/";
    }
}
