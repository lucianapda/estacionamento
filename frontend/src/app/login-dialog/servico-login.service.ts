import {Injectable} from '@angular/core';
import {Http} from '@angular/http';
import 'rxjs/add/operator/map';

@Injectable()
export class ServicoLoginService {

  //Injeta a dependencia de um objeto Http e atribui a um atributo http privado
  constructor(private http: Http) {}

  loginUser(email: String, senha: String) {
    return this.http.get("http://localhost:8080/login?email=" + email + "&senha=" + senha).map(response => response.json());
  }

}
