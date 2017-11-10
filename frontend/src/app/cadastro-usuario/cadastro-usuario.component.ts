import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { FormControl, FormGroupDirective, NgForm, Validators } from '@angular/forms';
import { ErrorStateMatcher } from '@angular/material/core';

@Component({
  selector: 'app-cadastro-usuario',
  templateUrl: './cadastro-usuario.component.html',
  styleUrls: ['./cadastro-usuario.component.css'],
  encapsulation: ViewEncapsulation.None
})

export class CadastroUsuarioComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }
  
  hide = true;
  hide2 = true;

  email = new FormControl('', [Validators.required, Validators.email]);
  confEmail = new FormControl('', [Validators.required, Validators.email]);  
  
  getErrorMessage() {
    return this.email.hasError('required') ? 'O email deve ser preenchido' :
      this.email.hasError('email') ? 'Email é inválido' : '';
  }

  getErrorMessageConf() {
    return this.confEmail.hasError('required') ? 'O email deve ser preenchido' :
      this.confEmail.hasError('email') ? 'Email é inválido' : '';
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
