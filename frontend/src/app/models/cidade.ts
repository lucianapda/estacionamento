import {Pais} from './pais';

export class Cidade {

  constructor() {
    this.pais = new Pais;
  }

  public codigo: number;
  public descricao: String;
  public  uf: String;
  public pais: Pais;
}
