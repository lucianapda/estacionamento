import { Localidade } from './localidade';
import { Usuario } from './usuario';

export class Estacionamento {

  constructor() {
    this.localidade = new Localidade;
    this.usuario = new Usuario;
    this.dataCriacao = "00000000";
    this.tempoReserva = 0;
    this.valorReserva = 0;

    if (localStorage.getItem('codigoUsuLogado')) {
      this.usuario.codigo = parseInt(localStorage.getItem('codigoUsuLogado'));      
    } else {
      this.usuario.codigo = null;
    }        
  }

  private codigo: number;
  private cnpj: String;
  private nome: String;
  private dataCriacao: String;
  private valorReserva: number;
  private tempoReserva: number; 
  public localidade: Localidade;
  private usuario: Usuario;
}
