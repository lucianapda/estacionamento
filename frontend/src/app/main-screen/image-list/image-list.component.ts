import { EstacionamentoService } from '../../cadastro-estacionamento/estacionamento.service';
import { Estacionamento } from '../../models/estacionamento';
import {Component, OnInit, ViewEncapsulation, Input} from '@angular/core';
import {Image} from '../../models/image';

@Component({
  selector: 'app-image-list',
  templateUrl: './image-list.component.html',
  styleUrls: ['./image-list.component.css'],
  encapsulation: ViewEncapsulation.None
})

export class ImageListComponent implements OnInit {

  private estacionamentos: Estacionamento[];

  constructor(private servicoEstacionamento: EstacionamentoService) {
    this.servicoEstacionamento.getAll().subscribe(estacionamentos => this.estacionamentos = estacionamentos, error => console.log(error),
      () => console.log("Carregado tela inicial"));
  }

  ngOnInit() {
  }

}