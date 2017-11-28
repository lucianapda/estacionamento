import { Estacionamento } from './estacionamento';

export class ImgEstacionamento {

  constructor(estacionamento: Estacionamento) {
    this.estacionamento = estacionamento;
  }

  public codigo: number;
  public imagem: String;
  public estacionamento: Estacionamento;
}
