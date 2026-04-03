package br.com.dimdim.controller;

import br.com.dimdim.model.Livro;
import br.com.dimdim.repository.LivroRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/livros")
public class LivroController {

    private final LivroRepository repository;

    public LivroController(LivroRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("livros", repository.findAll());
        return "livro";
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("livro", new Livro());
        return "livro-form";
    }

    @PostMapping
    public String salvar(Livro livro) {
        repository.save(livro);
        return "redirect:/livros";
    }
}