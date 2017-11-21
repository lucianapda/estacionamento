import {Localidade} from './localidade';

export class Usuario {

  constructor() {
    this.localidade = new Localidade;
  }

  private codigo: number;
  private cpf: String;
  private email: String;
  private telefone: String;
  private nome: String;
  private senha: String;
  private sexo: String;
  public localidade: Localidade;
}
