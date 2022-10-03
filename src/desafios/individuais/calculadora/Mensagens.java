package desafios.individuais.calculadora;

public class Mensagens {
  public static void mensagemPeriodoDoDia(int hora) {

    switch (hora) {
        case 4:
        case 5:
        case 6:
        case 7:
        case 8:
        case 9:
        case 10:
        case 11:
        case 12:
            printBomDia();
            break;
        case 13:
        case 14:
        case 15:
        case 16:
        case 17:
            printBoaTarde();
            break;
        case 18:
        case 19:
        case 20:
        case 21:
        case 22:
        case 23:
        case 0:
        case 1:
        case 2:
        case 3:
            printBoaNoite();
            break;
        default:
            System.out.println("ERRO");
            break;
    }
}

public static void printBomDia() {
    System.out.println("Bom dia!");
}

public static void printBoaTarde() {
    System.out.println("Bom tarde!");
}

public static void printBoaNoite() {
    System.out.println("Bom noite!");
}
}
