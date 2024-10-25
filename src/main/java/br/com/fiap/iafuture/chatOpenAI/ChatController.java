package br.com.fiap.iafuture.chatOpenAI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ChatController {

    @Autowired
    private ChatService chatService;

    @GetMapping("/openai")
    public String openai(@RequestParam(value = "prompt", required = false, defaultValue = "Hello, world!") String prompt, Model model) {
        String response = chatService.getCompletion(prompt);
        model.addAttribute("response", response);
        return "openai";
    }
}
