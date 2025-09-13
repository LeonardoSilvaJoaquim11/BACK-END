package lista006.GeradorJogador;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service
public class JogadorService {

    private final List<String> nomes = Arrays.asList("Ronaldo", "Pelé", "Zico", "Romário", "Neymar");
    private final List<String> sobrenomes = Arrays.asList("Fenômeno", "Rei", "Galo", "Baixinho", "Jr");
    private final Random random = new Random();

    public Jogador gerarJogador(String time, String posicao) {
        Jogador jogador = new Jogador();
        jogador.setNome(nomes.get(random.nextInt(nomes.size())));
        jogador.setSobrenome(sobrenomes.get(random.nextInt(sobrenomes.size())));
        jogador.setIdade(18 + random.nextInt(23)); // idade entre 18 e 40
        jogador.setTime(capitalize(time));
        jogador.setPosicao(capitalize(posicao));
        return jogador;
    }

    private String capitalize(String texto) {
        return texto.substring(0, 1).toUpperCase() + texto.substring(1).toLowerCase();
    }
}
