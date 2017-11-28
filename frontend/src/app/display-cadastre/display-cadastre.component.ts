import { Component, OnInit, Input} from '@angular/core';
import { EstacionamentoService } from '../cadastro-estacionamento/estacionamento.service';
import { Estacionamento } from '../models/estacionamento';
import { parse } from 'path';
import { RouterLink } from '@angular/router/src/directives/router_link';
import { Router} from '@angular/router';

@Component({
  selector: 'app-display-cadastre',
  templateUrl: './display-cadastre.component.html',
  styleUrls: ['./display-cadastre.component.css']
})
export class DisplayCadastreComponent implements OnInit {

  @Input() estacionamento : Estacionamento;

  constructor(private service: EstacionamentoService, private router: Router) { }

  ngOnInit() {
  }

  editaEstacionamento(codigo: number) {
    this.router.navigateByUrl('/parking/'+codigo);
  }

  deletaEstacionamento(codigoEstacionamento: number) {
    this.service.deletaEstaconamento(codigoEstacionamento).subscribe(error => console.log(error),
        () => console.log("deletou"));
  }
}
