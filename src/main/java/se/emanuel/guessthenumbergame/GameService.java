package se.emanuel.guessthenumbergame;


import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;


@Service
public class GameService {

    private int secretNumber;
    private int count;

    @PostConstruct
    public void newGame() {
        secretNumber = (int) (Math.random() * 100) + 1;
        count = 0;
    }

    public int getCount() {
        return count;
    }

    public int getSecretNumber() {
        return secretNumber;
    }

    public String makeGuess(int nGuess) {
        count++;
        if (nGuess < secretNumber) {
            return "too small";
        }
        else if (nGuess > secretNumber) {
            return "too big";
        }
        else {
            newGame();
            return "Correct!, new game initialized continue playing";
        }
    }
}
