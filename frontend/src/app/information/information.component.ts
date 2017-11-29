import {Component, OnInit, ViewEncapsulation} from '@angular/core';
import {EstacionamentoService} from '../cadastro-estacionamento/estacionamento.service';
import {Estacionamento} from '../models/estacionamento';
import {ImgEstacionamento} from '../models/img-estacionamento';
import {InformationService} from './information.service';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-information',
  templateUrl: './information.component.html',
  styleUrls: ['./information.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class InformationComponent implements OnInit {

  private estacionamento: Estacionamento;
  private codigoEstacionamento: number;
  private lat: number;
  private lng: number;

  constructor(private service: EstacionamentoService, private route: ActivatedRoute, private infoService: InformationService) {
    this.estacionamento = new Estacionamento();
    this.estacionamento.imagemEstacionamento = [new ImgEstacionamento(this.estacionamento)];
  }

  ngOnInit() {

    this.codigoEstacionamento = this.route.snapshot.params['id'];

    this.service.getByCode(this.codigoEstacionamento)
      .subscribe(estacionamento => {
        this.estacionamento = estacionamento[0];

        this.infoService.getLocalidade(this.estacionamento.localidade.cep, this.estacionamento.localidade.numero).
          subscribe(retorno => {
            this.lat = retorno.results[0].geometry.location.lat;
            this.lng = retorno.results[0].geometry.location.lng;
          },
          error => console.log(error),
          () => console.log("carregou usuario edição"));
      },
      error => console.log(error),
      () => console.log("Terminou"));

  }

}

