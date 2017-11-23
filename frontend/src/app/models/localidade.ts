import {Bairro} from '../models/bairro';
import {Cidade} from '../models/cidade';
import {Estacionamento} from './estacionamento';
import {Usuario} from './usuario';

export class Localidade {
  constructor() {
    this.bairro = new Bairro;
    this.cidade = new Cidade;
  }

  public codigo: number;
  public cep: number;
  public endereco: String;
  public numero: String;
  public bairro: Bairro;
  public cidade: Cidade;
  public usuarios: Usuario[];
  public estado: String;
}
