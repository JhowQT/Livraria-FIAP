package br.com.dimdim.controller;

import br.com.dimdim.model.Jogo;
import br.com.dimdim.repository.JogoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/jogos")
public class JogoController {

    private final JogoRepository repository;

    public JogoController(JogoRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("jogos", repository.findAll());
        return "jogo";
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("jogo", new Jogo());
        return "jogo-form";
    }

    @PostMapping
    public String salvar(Jogo jogo) {
        repository.save(jogo);
        return "redirect:/jogos";
    }
}