import {ImgUsuario} from './imgUsuario';
import {Injectable} from '@angular/core';
import {Http} from '@angular/http';
import 'rxjs/add/operator/map';

@Injectable()
export class ImgUsuarioService {

  //Injeta a dependencia de um objeto Http e atribui a um atributo http privado
  constructor(private http: Http) {}

  newImgUsu(imgUsu: ImgUsuario) {
    return this.http.post("http://localhost:8080/usuarioimg", ImgUsuario).map(response => response.json());
  }

}
