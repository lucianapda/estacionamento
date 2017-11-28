import { Component, OnInit } from '@angular/core';
import {Estacionamento} from '../models/estacionamento';
import {EstacionamentoService} from '../cadastro-estacionamento/estacionamento.service';

@Component({
  selector: 'app-my-parking',
  templateUrl: './my-parking.component.html',
  styleUrls: ['./my-parking.component.css']
})
export class MyParkingComponent implements OnInit {

  private estacionamentos: Estacionamento;

  constructor(private service: EstacionamentoService) { 
    this.service.getByCodeUsuario().subscribe(estacionamento => this.estacionamentos = estacionamento,
    error => console.log(error),
    () => console.log("carregou estacionamentos"));
    
    console.log(this.estacionamentos);
  }

  ngOnInit() {
  }

}
