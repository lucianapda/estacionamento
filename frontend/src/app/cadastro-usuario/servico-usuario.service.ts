import {Injectable} from '@angular/core';
import {Http} from '@angular/http';
import {Usuario} from '../models/usuario';
import 'rxjs/add/operator/map';

@Injectable()
export class ServicoUsuarioService {

  //Injeta a dependencia de um objeto Http e atribui a um atributo http privado
  constructor(private http: Http) {}

  getUsuario(codigo: number) {
    //Utiliza o atributo http para realizar a operação GET na url informada, e obtém o resultado da chamada
    return this.http.get("http://localhost:8080/usuario?codigo=" + codigo).map(response => response.json());
  }

  createUsuario(usuario: Usuario) {
    return this.http.post("http://localhost:8080/usuario", usuario).map(response => response.json());
  }

}
