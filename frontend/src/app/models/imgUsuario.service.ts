import {ImgUsuario} from './imgUsuario';
import {Injectable} from '@angular/core';
import {Http} from '@angular/http';
import 'rxjs/add/operator/map';

@Injectable()
export class ImgUsuarioService {

  //Injeta a dependencia de um objeto Http e atribui a um atributo http privado
  constructor(private http: Http) {}

  getImg(codigo: number) {
    //Utiliza o atributo http para realizar a operação GET na url informada, e obtém o resultado da chamada
    return this.http.get("http://localhost:8080/usuarioimg?codigo=" + codigo).map(response => response.json());
  }

  newImgUsu(imgUsu: ImgUsuario) {
    return this.http.post("http://localhost:8080/usuarioimg", imgUsu).map(response => response.json());
  }

  editImgUsu(imgUsu: ImgUsuario) {
    return this.http.put("http://localhost:8080/usuarioimg", imgUsu).map(response => response.json());
  }

  deleteImgUsu(codigo: number) {
    return this.http.delete("http://localhost:8080/usuarioimg?codigo=" + codigo).map(response => response.json());
  }

}
