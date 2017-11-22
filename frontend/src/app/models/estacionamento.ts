import {Localidade} from './localidade';

export class Estacionamento {

  constructor(codioUsuario: number) {
    this.localidade = new Localidade;
    this.codusu_est = codioUsuario;
  }

  private codigo_est: number;
  private cnpj_est: String;
  private datcri_est: Date;
  private nome_est: String;
  private tmpres_est: number;
  private valres_est: number;
  public localidade: Localidade;
  private codusu_est: number;
}
