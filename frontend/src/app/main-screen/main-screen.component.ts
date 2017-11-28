import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { EstacionamentoService } from '../cadastro-estacionamento/estacionamento.service';
import { Estacionamento } from 'app/models/estacionamento';

@Component({
  selector: 'app-main-screen',
  templateUrl: './main-screen.component.html',
  styleUrls: ['./main-screen.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class MainScreenComponent implements OnInit {

  private nomePesquisa: string;
  private estacionamento: Estacionamento;

  constructor(private service: EstacionamentoService, private route: ActivatedRoute) { }

  ngOnInit() {
    this.nomePesquisa = this.route.snapshot.params['nome'];
    console.log(this.nomePesquisa);
    if(this.nomePesquisa != ''){
      this.service.getByName(this.nomePesquisa).subscribe(
        estacionamento => this.estacionamento = estacionamento, 
        error => console.log(error), 
        () => console.log("pesquisando estacionamento"));
        console.log(this.estacionamento);
      } else {
        console.log('erro ao editar');
    }
  }

}
