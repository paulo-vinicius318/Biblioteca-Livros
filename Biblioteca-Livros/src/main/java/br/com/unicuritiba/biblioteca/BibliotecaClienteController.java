package br.com.unicuritiba.biblioteca;

import java.util.List;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.unicuritiba.biblioteca.models.Cliente;
import br.com.unicuritiba.biblioteca.repositories.ClienteRepository;


@Controller
public class BibliotecaClienteController {

	@Autowired
	private ClienteRepository repositorio;
	
	@GetMapping("/")
	public ModelAndView home() {
		
		List<Cliente> clientes= repositorio.findAll();
		ModelAndView view = new ModelAndView("indexCliente");
		view.addObject("clientes", clientes);

		return view;
	}
	
	@GetMapping("/cadastroCliente")
	public ModelAndView create() {
		ModelAndView view = new ModelAndView("createCliente");
		view.addObject("cliente", new Cliente());
		return view;
	}
	
	@GetMapping("/atualizarCliente/{id}")
	public ModelAndView update(
			@PathVariable("id") long id
			) {
	
		Cliente cliente= repositorio.findById(id).get();
		ModelAndView view = new ModelAndView("updateCliente");
		view.addObject("cliente",cliente);
		return view;
	}
	
	
	@PostMapping("/cadastroCliente")
	public String createCliente(
			Cliente cliente,
			Model model,
			BindingResult result) {
		repositorio.save(cliente);
		return "redirect:/";
	}
	
	@DeleteMapping("/removerCliente/{id}")
	public String removeCliente(
			@PathVariable("id") long id) {
		repositorio.deleteById(id);
		return "redirect:/";
	}
	
	@PutMapping("/atualizarCliente/{id}")
	public String updateCliente(
			@PathVariable("id") long id,
			Cliente cliente,
			Model model,
			BindingResult result) {
		
		cliente.setId(id);	
		repositorio.save(cliente);
		return "redirect:/";
	}
	
}




/* 11.06 23h24min
@Controller
@RequestMapping("/clientes")
 public class BibliotecaClienteController {

    @Autowired
    private ClienteRepository repositorio;
    
    @GetMapping("/")
    public ModelAndView home() {
        List<Cliente> clientes = repositorio.findAll();
        ModelAndView view = new ModelAndView("index");
        view.addObject("cliente", clientes);
        return view;
    }
    
    @GetMapping("/cadastroCliente")
    public ModelAndView create() {
        ModelAndView view = new ModelAndView("create");
        view.addObject("Cliente", new Cliente());
        return view;
    }
    
    @PostMapping("/cadastro")
    public String createCliente(Cliente cliente) {
        repositorio.save(cliente);
        return "redirect:/clientes/";
    }
    
    @DeleteMapping("/remover/{id}")
    public String removeCliente(@PathVariable("id") long id) {
        repositorio.deleteById(id);
        return "redirect:/clientes/";
    }
    
    @PutMapping("/atualizar/{id}")
    public String updateCliente(@PathVariable("id") long id, Cliente cliente, Model model, BindingResult result) {
        cliente.setId(id);    
        repositorio.save(cliente);
        return "redirect:/clientes/";
        	}
}
*/
