import {Usuario} from './usuario';

export class ImgUsuario {

  constructor(usuario: Usuario) {
    this.usuario = usuario;
  }

  public codigo: number;
  public imagem: Blob[];
  public usuario: Usuario;
}
