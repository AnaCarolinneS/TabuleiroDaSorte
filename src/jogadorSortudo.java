
import java.awt.Color;
import javax.swing.JOptionPane;

public class jogadorSortudo extends jogador {

    public jogadorSortudo(String nome, Color cor) {
        super(nome, cor);
    }

    @Override
    public void mover(int casas, tabuleiro jogo) {
        if (!podeJogar) return;

        int novaPosicao = this.posicao + casas;
        if (novaPosicao >= 40) {
            novaPosicao = 39;
        }
        this.posicao = novaPosicao;

        verificarCasaEspecial(jogo);
        this.incrementarJogadas();
    }

    private void verificarCasaEspecial(tabuleiro jogo) {
        if (posicao == 13) {
            cartaAleatoria carta = cartaAleatoria.sortearCarta();
            JOptionPane.showMessageDialog(jogo.getFrame(), "Você tirou a carta: " + carta);
            if (carta.getTipo() == cartaAleatoria.Tipo.CARTA_AZARADO) {
                jogo.alterarTipoJogador(this, new jogadorAzarado(this.nome, this.cor));
            }
        } else if (posicao == 5 || posicao == 15 || posicao == 30) {
           // if (this instanceof jogadorAzarado) {
              //   JOptionPane.showMessageDialog(jogo.getFrame(), "Você é um jogador azarado e não pode avançar.");
            // } else
            {
                this.posicao += 3;
                if (this.posicao >= 40) this.posicao = 39;
            }
        } else if (posicao == 20 || posicao == 35) {
            jogo.trocarPosicaoJogadores(this);
        }
    }
}