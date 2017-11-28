import {ImgEstacionamento} from './img-estacionamento';
import {Localidade} from './localidade';
import {Usuario} from './usuario';

export class Estacionamento {

  constructor() {
    this.localidade = new Localidade;
    this.usuario = new Usuario;
    this.dataCriacao = "20171122";
    this.tempoReserva = 0;
    this.valorReserva = 0;

    if (localStorage.getItem('codigoUsuLogado')) {
      this.usuario.codigo = parseInt(localStorage.getItem('codigoUsuLogado'));
    } else {
      this.usuario.codigo = null;
    }
  }

  public codigo: number;
  public cnpj: String;
  public nome: String;
  public telefone: String;
  public dataCriacao: String;
  public valorReserva: number;
  public tempoReserva: number;
  public localidade: Localidade;
  public usuario: Usuario;
  public imagemEstacionamento: ImgEstacionamento[];
}
