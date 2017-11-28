import {Component, OnInit, Input} from '@angular/core';
import {EstacionamentoService} from '../cadastro-estacionamento/estacionamento.service';
import {Estacionamento} from '../models/estacionamento';
import {ImgEstacionamentoService} from '../models/img-estacionamento.service';
import {LocalidadeService} from '../models/localidade.service';
import {parse} from 'path';
import {RouterLink} from '@angular/router/src/directives/router_link';
import {Router} from '@angular/router';

@Component({
  selector: 'app-display-cadastre',
  templateUrl: './display-cadastre.component.html',
  styleUrls: ['./display-cadastre.component.css']
})
export class DisplayCadastreComponent implements OnInit {

  @Input() estacionamento: Estacionamento;

  constructor(private service: EstacionamentoService,
    private localidadeService: LocalidadeService,
    private imgService: ImgEstacionamentoService,
    private router: Router) {}

  ngOnInit() {
  }

  editaEstacionamento(codigo: number) {
    this.router.navigateByUrl('/parking/' + codigo);
  }

  deletaEstacionamento(codigoEstacionamento: number) {
    if (this.estacionamento.imagemEstacionamento != null && this.estacionamento.imagemEstacionamento.length > 0) {
      this.imgService.deleteImgEst(this.estacionamento.imagemEstacionamento[0].codigo).subscribe(retornoImg => this.deletar(),
        error => console.log(error),
        () => console.log("deletado Imagem"));
    } else {
      this.deletar();
    }
  }

  deletar() {
    this.service.deletaEstaconamento(this.estacionamento.codigo).subscribe(estacionamento => {
      this.localidadeService.deleteLocalidade(this.estacionamento.localidade.codigo).subscribe(localidade => {
        window.location.reload();
      },
        error => console.log(error),
        () => "");
    },
      error => console.log(error),
      () => "");
  }
}
