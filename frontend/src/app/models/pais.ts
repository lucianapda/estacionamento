import {Bairro} from './bairro';
import {Localidade} from './localidade';
export class Pais {
  public codigo: number = 1;
  public localidade: Localidade[];
  public bairro: Bairro[];
}
