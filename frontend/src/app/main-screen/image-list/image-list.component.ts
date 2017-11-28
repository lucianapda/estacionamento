import {EstacionamentoService} from '../../cadastro-estacionamento/estacionamento.service';
import {Estacionamento} from '../../models/estacionamento';
import {Component, OnInit, ViewEncapsulation, Input} from '@angular/core';
import {Image} from '../../models/image';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-image-list',
  templateUrl: './image-list.component.html',
  styleUrls: ['./image-list.component.css'],
  encapsulation: ViewEncapsulation.None
})

export class ImageListComponent implements OnInit {

  private estacionamentos: Estacionamento[];

  constructor(private servicoEstacionamento: EstacionamentoService, private route: ActivatedRoute) {
  }

  ngOnInit() {
    var infoPesquisa: String = this.route.snapshot.params['nome'];
    
    if (infoPesquisa != null && infoPesquisa != "") {
      this.servicoEstacionamento.getByName(infoPesquisa).subscribe(estacionamentos =>
        this.estacionamentos = estacionamentos, error => console.log(error),
        () => console.log("Carregado tela inicial"));
    } else {
      this.servicoEstacionamento.getAll().subscribe(estacionamentos =>
        this.estacionamentos = estacionamentos, error => console.log(error),
        () => console.log("Carregado tela inicial"));
    }

  }

}