import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import 'rxjs/add/operator/map';

@Injectable()
export class CidadeService {

  //Injeta a dependencia de um objeto Http e atribui a um atributo http privado
  constructor(private http: Http) { }

  getAll() {
    return this.http.get("http://localhost:8080/cidade").map(response => response.json());
  }

}
