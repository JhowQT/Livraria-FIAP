package br.com.dimdim.controller;

import br.com.dimdim.repository.JogoRepository;
import br.com.dimdim.repository.LivroRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final JogoRepository jogoRepository;
    private final LivroRepository livroRepository;

    public HomeController(JogoRepository jogoRepository, LivroRepository livroRepository) {
        this.jogoRepository = jogoRepository;
        this.livroRepository = livroRepository;
    }

    @GetMapping("/")
    public String home(Model model) {

        model.addAttribute("qtdJogos", jogoRepository.count());
        model.addAttribute("qtdLivros", livroRepository.count());

        return "index";
    }
}