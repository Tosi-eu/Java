package desafios.individuais.OO;

class Homem {
  String etnia;
  String nacionalidade;
  String trabalho;
  String hobby;
  int idade;
  int litrosDeCafe;

  Homem(){

  }

  Homem(String etnia, String nacionalidade, String hobby, String trabalho, int idade, int litrosDeCafe){
    this.etnia = etnia;
    this.nacionalidade = nacionalidade;
    this.hobby = hobby;
    this.trabalho = trabalho;
    this.idade = idade;
    this.litrosDeCafe = litrosDeCafe;
  }

  void setarEtnia(String etnia){
    this.etnia = etnia;
  }

  void setarNacionalidade(String nacionalidade){
    this.nacionalidade = nacionalidade;
  }

  void setarTrabalho(String trabalho){
    this.trabalho = trabalho;
  }

  void setarHobby(String hobby){
    this.hobby = hobby;
  }

  void setarIdade(int idade){
    this.idade = idade;
  }

  void setarVicio(int litrosDeCafe){
    this.litrosDeCafe = litrosDeCafe;
  }

  String consolidaEtnia(){
    return etnia;
  }

  String consolidaNacionalidade(){
    return nacionalidade;
  }

  String consolidaTrabalho(){
    return trabalho;
  }

  String consolidaHobby(){
    return hobby;
  }

  int consolidaIdade(){
    return idade;
  }
  
  int consolidaVicio(){
    return litrosDeCafe;
  }

}
