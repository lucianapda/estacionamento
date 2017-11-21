import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { EstacionamentoService } from './estacionamento.service';
import { Estacionamento } from '../models/estacionamento';
import { Localidade } from '../models/localidade';

@Component({
  selector: 'app-cadastro-estacionamento',
  templateUrl: './cadastro-estacionamento.component.html',
  styleUrls: ['./cadastro-estacionamento.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class CadastroEstacionamentoComponent implements OnInit {

  private estacionamento: Estacionamento = new Estacionamento();
  private localidade: Localidade = new Localidade();

  constructor(private service: EstacionamentoService) {
    service.getAll().subscribe(estacionamento => console.log(estacionamento), error => console.log(error), () => console.log("Pegou toda lista"));
  }

  ngOnInit() {
  }

  submit() {
    console.log(this.estacionamento);
    this.service.createEstacionamento(this.estacionamento).subscribe(usuario => console.log(usuario),
      error => console.log(error),
      () => console.log("inseriu")
    );
  }

  state = [
    {value: '1', name: 'Curitiba'},
    {value: '2', name: 'Santa Catarina'},
    {value: '3', name: 'Rio Grande do Sul'}
  ];

  bairro = [
    {value: '1', name: 'Centro'},
    {value: '2', name: 'Vila nova'},
    {value: '3', name: 'Velha'}
  ];

  city = [
    {value: '1', name: 'Blumenal'},
    {value: '2', name: 'Curitiba'},
    {value: '3', name: 'Porto Alegre'}
  ];


}
