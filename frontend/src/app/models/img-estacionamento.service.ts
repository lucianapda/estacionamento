import { ImgUsuario } from './imgUsuario';
import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { ImgEstacionamento } from 'app/models/img-estacionamento';
import 'rxjs/add/operator/map';

@Injectable()
export class ImgEstacionamentoService {

  //Injeta a dependencia de um objeto Http e atribui a um atributo http privado
  constructor(private http: Http) {}

  getImg(codigo: number) {
    //Utiliza o atributo http para realizar a operação GET na url informada, e obtém o resultado da chamada
    return this.http.get("http://localhost:8080/estacionamentoimg?codigo=" + codigo).map(response => response.json());
  }

  newImgEst(imgEst: ImgEstacionamento) {
    return this.http.post("http://localhost:8080/estacionamentoimg", imgEst).map(response => response.json());
  }

  editImgEst(imgEst: ImgEstacionamento) {
    return this.http.put("http://localhost:8080/estacionamentoimg", imgEst).map(response => response.json());
  }

  deleteImgEst(codigo: number) {
    return this.http.delete("http://localhost:8080/estacionamentoimg?codigo=" + codigo).map(response => response.text());
  }

}
