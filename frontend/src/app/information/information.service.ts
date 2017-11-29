import {Injectable} from '@angular/core';
import {Http} from '@angular/http';
import {Usuario} from '../models/usuario';
import 'rxjs/add/operator/map';

@Injectable()
export class InformationService {

  //Injeta a dependencia de um objeto Http e atribui a um atributo http privado
  constructor(private http: Http) {}

  getLocalidade(cep: String, numeroCasa: String) {
    return this.http.get("https://maps.googleapis.com/maps/api/geocode/json?address=" + cep + "&" + numeroCasa + "&key=AIzaSyCogHRSH3rJOK7nqcvRx88N2zvF0zb6GqA").map(response => response.json());
  }

}
