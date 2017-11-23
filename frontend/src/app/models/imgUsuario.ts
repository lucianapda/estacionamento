import {Usuario} from './usuario';

export class ImgUsuario {

  constructor(codigo: number) {
    this.usuario = new Usuario();
    this.usuario.codigo = codigo;
  }

  public codigo: number;
  public imagem: String;
  public usuario: Usuario;
}
