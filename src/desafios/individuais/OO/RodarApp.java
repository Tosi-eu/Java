package desafios.individuais.OO;

class RodarApp {
  
  public static void main(String[] args) {

    Homem homem1 = new Homem();

    homem1.setarEtnia("Branco");
    homem1.setarNacionalidade("Brasileiro");
    homem1.setarHobby("Ir à academia");
    homem1.setarTrabalho("Corretor de imóveis");
    homem1.setarIdade(21);
    homem1.setarVicio(2);

    System.out.println(homem1.consolidaEtnia());
    System.out.println(homem1.consolidaNacionalidade());
    System.out.println(homem1.consolidaHobby());
    System.out.println(homem1.consolidaTrabalho());
    System.out.println(homem1.consolidaIdade());
    System.out.println(homem1.consolidaVicio());
  }
}
