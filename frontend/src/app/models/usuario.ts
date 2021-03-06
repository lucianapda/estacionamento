import {Estacionamento} from './estacionamento';
import {ImgUsuario} from './imgUsuario';
import {Localidade} from './localidade';

export class Usuario {

  constructor() {
    this.localidade = new Localidade();
  }

  public codigo: number;
  public cpf: String;
  public email: String;
  public telefone: String;
  public nome: String;
  public senha: String;
  public sexo: String;
  public localidade: Localidade;
  public estacionamento: Estacionamento[];
  public usuarioImgs: ImgUsuario[];

}
