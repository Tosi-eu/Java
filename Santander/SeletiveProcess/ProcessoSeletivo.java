package Santander.SeletiveProcess;

import java.util.Random;

public class ProcessoSeletivo {
    private static final double SALARIO_BASE = 2000.0;

    public static void main(String[] args) {
        Candidato[] candidatos = {
            new Candidato("João", 1800),
            new Candidato("Maria", 2000),
            new Candidato("Carlos", 2500)
        };

        for (Candidato candidato : candidatos) {
            analisarCandidato(candidato);
            chamarCandidato(candidato);
            System.out.println("-----------------------");
        }
    }

    static void analisarCandidato(Candidato candidato) {
        double salarioPretendido = candidato.getSalarioPretendido();
        String nome = candidato.getNome();

        System.out.println("Analisando candidato: " + nome);

        if (salarioPretendido < SALARIO_BASE) {
            System.out.println("Ligar para " + nome + " (aceitou menos)");
        } else if (salarioPretendido == SALARIO_BASE) {
            System.out.println("Ligar para " + nome + " com contraproposta");
        } else {
            System.out.println("Aguardando outros candidatos");
        }
    }

    static void chamarCandidato(Candidato candidato) {
        double salarioPretendido = candidato.getSalarioPretendido();
        String nome = candidato.getNome();

        if (salarioPretendido <= SALARIO_BASE) {
            tentarLigar(nome);
        }
    }

    static void tentarLigar(String nome) {
        int tentativas = 0;
        boolean atendeu = false;

        while (tentativas < 3 && !atendeu) {
            tentativas++;
            System.out.println("Tentativa " + tentativas + " de ligação para " + nome);
            atendeu = simulaLigacao();
        }

        if (atendeu) {
            System.out.println(nome + " atendeu à ligação!");
        } else {
            try {
                throw new LigacaoException("Não foi possível contato com " + nome + " após 3 tentativas.");
            } catch (LigacaoException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    static boolean simulaLigacao() {
        return new Random().nextInt(3) == 1; // 1 em 3 chances de atender
    }
}