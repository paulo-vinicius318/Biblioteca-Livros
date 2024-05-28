package br.com.unicuritiba.biblioteca;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.unicuritiba.biblioteca.models.Livro;
import br.com.unicuritiba.biblioteca.repositories.LivroRepository;

@Controller
public class BibliotecaLivrosController {

	@Autowired
	private LivroRepository repositorio;
	
	@GetMapping("/")
	public ModelAndView home() {
		
		List<Livro> livros = repositorio.findAll();
		
		ModelAndView view = new ModelAndView("index");
		view.addObject("livros", livros);

		return view;
	}
	
	@GetMapping("/cadastro")
	public ModelAndView create() {
		ModelAndView view = new ModelAndView("create");
		view.addObject("livro", new Livro());
		return view;
	}
	
	
	@PostMapping("/cadastro")
	public String createFighter(
			Livro livro,
			Model model,
			BindingResult result) {
		repositorio.save(livro);
		return "redirect:/";
	}
	
}
