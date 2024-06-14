package br.com.unicuritiba.biblioteca;

import java.util.List;

import org.springframework.stereotype.Controller;
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
		
		List<Cliente> clientes = repositorio.findAll();
		
		ModelAndView view = new ModelAndView("index");
		view.addObject("cliente", clientes);

		return view;
	}
	
	@GetMapping("/cadastro2")
	public ModelAndView create() {
		ModelAndView view = new ModelAndView("create");
		view.addObject("Cliente", new Cliente());
		return view;
	}
	
	@PostMapping("/cadastro/cliente")
	public String createCliente(
			Cliente cliente
			) {
		repositorio.save(cliente);
		return "redirect:/";
	}
	
	@DeleteMapping("/remover/cliente/{id}")
	public String removeCliente(
			@PathVariable("id") long id) {
		repositorio.deleteById(id);
		return "redirect:/";
	}
	
	@PutMapping("/atualizar/cliente/{id}")
	public String updateCliente(
			@PathVariable("id") long id,
			Cliente cliente) {
		
		cliente.setId(id);	
		repositorio.save(cliente);
		return "redirect:/";
	}
}
