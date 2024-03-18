package se.emanuel.guessthenumbergame;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GameController {
    @Autowired
    GameService service;


    @GetMapping("game")
    public String startGame(Model model) {
        model.addAttribute("game", "");
        return "gamepage";
    }

    @PostMapping("gamea")
    public String guess(@RequestParam int input, Model model) {
        String resultGame = service.makeGuess(input);
        model.addAttribute("guess", service.getCount());
        model.addAttribute("result", resultGame);
        return "gamepage";
    }
}
