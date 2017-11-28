import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { EstacionamentoService } from '../cadastro-estacionamento/estacionamento.service';
import { Estacionamento } from 'app/models/estacionamento';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-information',
  templateUrl: './information.component.html',
  styleUrls: ['./information.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class InformationComponent implements OnInit {

  private estacionamentos: Estacionamento;
  private codigoEstacionamento: number;
  
  constructor(private service: EstacionamentoService, private route: ActivatedRoute) { }

  ngOnInit() {

    this.codigoEstacionamento = this.route.snapshot.params['id'];

    this.service.getByCode(this.codigoEstacionamento)
    .subscribe(estacionamento => this.estacionamentos = estacionamento, 
      error => console.log(error),
      () => console.log("Terminou"));

      console.log(this.estacionamentos);

  }

}
