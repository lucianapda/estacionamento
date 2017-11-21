import {Localidade} from './localidade';
import {Injectable} from '@angular/core';
import {Http} from '@angular/http';
import 'rxjs/add/operator/map';

@Injectable()
export class LocalidadeService {

  //Injeta a dependencia de um objeto Http e atribui a um atributo http privado
  constructor(private http: Http) {}

  createLocalidade(localidade: Localidade) {
    return this.http.post("http://localhost:8080/localidade", localidade).map(response => response.json());
  }
}
