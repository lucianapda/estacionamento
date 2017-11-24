import {Usuario} from './usuario';

export class ImgUsuario {

  constructor(user: Usuario) {
    this.usuario = user;
  }

  public codigo: number;
  public imagem: String;
  public usuario: Usuario;
}
