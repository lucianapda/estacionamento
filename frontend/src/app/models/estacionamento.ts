import {Usuario} from './usuario';
import {Localidade} from './localidade';

export class Estacionamento {
  private codigo_est: number;
  private cnpj_est: String;
  private datcri_est: Date;
  private nome_est: String;
  private tmpres_est: number;
  private valres_est: number;
  private codloc_est: Localidade;
  private codusu_est: Usuario;
}
