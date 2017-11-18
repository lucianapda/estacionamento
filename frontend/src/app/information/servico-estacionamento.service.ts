import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import 'rxjs/add/operator/map';

@Injectable()
export class ServicoEstacionamentoService {

//Injeta a dependencia de um objeto Http e atribui a um atributo http privado
constructor(private http: Http) { }

  getAll() {
    //Utiliza o atributo http para realizar a operação GET na url informada, e obtém o resultado da chamada
    return this.http.get("http://localhost:8080/estacionamento").map(response => response.json());
  }

}
