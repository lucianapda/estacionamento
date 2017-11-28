import {Localidade} from './localidade';
import {Injectable} from '@angular/core';
import {Http} from '@angular/http';
import 'rxjs/add/operator/map';

@Injectable()
export class LocalidadeService {

  //Injeta a dependencia de um objeto Http e atribui a um atributo http privado
  constructor(private http: Http) {}

  getLocalidade(codigo: number) {
    //Utiliza o atributo http para realizar a operação GET na url informada, e obtém o resultado da chamada
    return this.http.get("http://localhost:8080/localidade?codigo=" + codigo).map(response => response.json());
  }

  createLocalidade(localidade: Localidade) {
    return this.http.post("http://localhost:8080/localidade", localidade).map(response => response.json());
  }

  editLocalidade(localidade: Localidade) {
    console.log(localidade);
    return this.http.put("http://localhost:8080/localidade", localidade).map(response => response.json());
  }

  deleteLocalidade(codigo: number) {
    return this.http.delete("http://localhost:8080/localidade?codigo=" + codigo).map(response => response.text());
  }
}
