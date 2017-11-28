import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { FormControl, FormGroupDirective, NgForm, Validators } from '@angular/forms';
import { ErrorStateMatcher } from '@angular/material/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-cadastro-vaga',
  templateUrl: './cadastro-vaga.component.html',
  styleUrls: ['./cadastro-vaga.component.css'],
  encapsulation: ViewEncapsulation.None
})

export class CadastroVagaComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  tipoVaga = [
    {value: '1', name: 'Carro hatch'},
    {value: '2', name: 'Carro sedan'},
    {value: '3', name: 'Moto'},
    {value: '4', name: 'Caminhão'}
  ];

}
