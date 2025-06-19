package Santander.UML;

public class Main {
    public static void main(String[] args) {
        Iphone iphone = new Iphone();
        iphone.selecionarMusica("Imagine - John Lennon");
        iphone.tocar();
        iphone.pausar();

        iphone.ligar("11987654321");
        iphone.atender();
        iphone.iniciarCorreioVoz();

        iphone.exibirPagina("https://www.apple.com");
        iphone.adicionarNovaAba();
        iphone.atualizarPagina();
    }
}

