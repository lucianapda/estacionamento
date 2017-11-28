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

  getByCode(codigo: number) {
    return this.http.get("http://localhost:8080/estacionamento?codigo="+codigo).map(response => response.json());
 }

  getByCodeUsuario() {
    return this.http.get("http://localhost:8080/estacionamento?codigousuario="+localStorage.getItem('codigoUsuLogado')).map(response => response.json());
  }

  getByName(nomePesquisa: string) {
    return this.http.get("http://localhost:8080/estacionamento?nome="+nomePesquisa).map(response => response.json());
  }
   
  createEstacionamento(estacionamento: Estacionamento) {
     return this.http.post("http://localhost:8080/estacionamento", estacionamento).map(response => response.json());
  }

  editaEstaconamento(estacionamento: Estacionamento) {
    return this.http.put("http://localhost:8080/estacionamento", estacionamento).map(response => response.json());
  }

  deletaEstaconamento(codigoEstacionamento: number) {
    return this.http.delete("http://localhost:8080/estacionamento?codigo="+codigoEstacionamento).map(response => response.text());
  }

}
