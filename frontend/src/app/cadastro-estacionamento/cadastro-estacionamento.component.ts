import { Component, OnInit, ViewEncapsulation } from '@angular/core';

@Component({
  selector: 'app-cadastro-estacionamento',
  templateUrl: './cadastro-estacionamento.component.html',
  styleUrls: ['./cadastro-estacionamento.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class CadastroEstacionamentoComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  sex = [
    {value: '1', name: 'Masculino'},
    {value: '2', name: 'Feminino'},
    {value: '3', name: 'Ignorado'}
  ];

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
