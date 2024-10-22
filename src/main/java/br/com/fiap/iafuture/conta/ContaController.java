package br.com.fiap.iafuture.conta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;

import java.util.List;

@Controller
public class ContaController {

    @Autowired
    private ContaRepository contaRepository;

    @Autowired
    private ContaService contaService;

    @GetMapping("/cadastro")
    public String showCadastroForm(Model model) {
        model.addAttribute("conta", new Conta());
        return "cadastro";
    }

    @PostMapping("/cadastro")
    public String registerConta(@Valid @ModelAttribute Conta conta, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "cadastro";
        }
        contaRepository.save(conta);
        model.addAttribute("mensagem", "Conta cadastrada com sucesso!");
        return "redirect:cadastro/sucesso";
    }

    @GetMapping("/cadastro/sucesso")
    public String sucesso(Model model) {
        return "cadastro/sucesso";
    }
}
