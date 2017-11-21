import {Bairro} from '../models/bairro';
import {Cidade} from '../models/cidade';
import {Estacionamento} from './estacionamento';
import {Usuario} from './usuario';

export class Localidade {
  constructor() {
    this.bairro = new Bairro;
    this.cidade = new Cidade;
  }

  private codigo: number;
  private cep: number;
  private endereco: String;
  private numero: String;
  private bairro: Bairro;
  private cidade: Cidade;
  private usuarios: Usuario[];
  private estado: String;
}
