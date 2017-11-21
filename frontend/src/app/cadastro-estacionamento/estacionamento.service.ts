import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { Estacionamento } from '../models/estacionamento';
import 'rxjs/add/operator/map';

@Injectable()
export class EstacionamentoService {

 //Injeta a dependencia de um objeto Http e atribui a um atributo http privado
 constructor(private http: Http) { }
 
   getAll() {
     //Utiliza o atributo http para realizar a operação GET na url informada, e obtém o resultado da chamada
     return this.http.get("http://localhost:8080/estacionamento").map(response => response.json());
   }
   
   createEstacionamento(estacionamento: Estacionamento) {
     return this.http.post("http://localhost:8080/estacionamento", estacionamento).map(response => response.json());
   }

}
