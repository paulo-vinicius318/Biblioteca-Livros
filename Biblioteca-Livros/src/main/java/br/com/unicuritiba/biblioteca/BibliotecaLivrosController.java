package br.com.unicuritiba.biblioteca;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.unicuritiba.biblioteca.models.Livro;
import br.com.unicuritiba.biblioteca.repositories.LivroRepository;

@Controller
public class BibliotecaLivrosController {

	@Autowired
	private LivroRepository repositorio;
	
	@GetMapping("/2")
	public ModelAndView home() {
		
		List<Livro> livros = repositorio.findAll();
		ModelAndView view = new ModelAndView("indexLivro");
		view.addObject("livros", livros);

		return view;
	}
	
	@GetMapping("/cadastroLivro")
	public ModelAndView create() {
		ModelAndView view = new ModelAndView("createLivro");
		view.addObject("livro", new Livro());
		return view;
	}
	
	@GetMapping("/atualizarLivro/{id}")
	public ModelAndView update(
			@PathVariable("id") long id
			) {
	
		Livro livro= repositorio.findById(id).get();
		ModelAndView view = new ModelAndView("updateLivro");
		view.addObject("livro",livro);
		return view;
	}
	
	
	@PostMapping("/cadastroLivro")
	public String createLivro(
			Livro livro,
			Model model,
			BindingResult result) {
		repositorio.save(livro);
		return "redirect:/2";
	}
	
	@DeleteMapping("/removerLivro/{id}")
	public String removeLivro(
			@PathVariable("id") long id) {
		repositorio.deleteById(id);
		return "redirect:/2";
	}
	
	@PutMapping("/atualizarLivro/{id}")
	public String updateLivro(
			@PathVariable("id") long id,
			Livro livro,
			Model model,
			BindingResult result) {
		
		livro.setId(id);	
		repositorio.save(livro);
		return "redirect:/2";
	}
	
}


/* 11.06 22h19min
@Controller
@RequestMapping("/livros")
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
    
    @GetMapping("/cadastroLivro")
    public ModelAndView create() {
        ModelAndView view = new ModelAndView("create");
        view.addObject("livro", new Livro());
        return view;
    }
    
    @PostMapping("/cadastro")
    public String createLivros(Livro livro, Model model, BindingResult result) {
        repositorio.save(livro);
        return "redirect:/livros/";
    }
    
    @DeleteMapping("/remover/{id}")
    public String removeLivros(@PathVariable("id") long id) {
        repositorio.deleteById(id);
        return "redirect:/livros/";
    }
    
    @PutMapping("/atualizar/{id}")
    public String updateLivros(@PathVariable("id") long id, Livro livro) {
        livro.setId(id);    
        repositorio.save(livro);
        return "redirect:/livros/";
    }
}
*/