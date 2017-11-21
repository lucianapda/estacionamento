import {Injectable} from '@angular/core';
import {Http} from '@angular/http';
import 'rxjs/add/operator/map';

@Injectable()
export class BairroService {

  //Injeta a dependencia de um objeto Http e atribui a um atributo http privado
  constructor(private http: Http) {}

  getAll() {
    return this.http.get("http://localhost:8080/bairro").map(response => response.json());
  }

  getBairrosCIdade(codigoCidade) {
    return this.http.get("http://localhost:8080/bairro?codigoCidade=" + codigoCidade).map(response => response.json());
  }

}
