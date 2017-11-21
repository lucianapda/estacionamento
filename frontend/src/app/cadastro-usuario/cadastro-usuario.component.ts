import {Component, OnInit, ViewEncapsulation} from '@angular/core';
import {FormControl, FormGroupDirective, NgForm, Validators} from '@angular/forms';
import {ErrorStateMatcher} from '@angular/material/core';
import {ServicoUsuarioService} from './servico-usuario.service';
import {BairroService} from '../models/bairro.service';
import {CidadeService} from '../models/cidade.service';
import {Usuario} from '../models/usuario';
import {Bairro} from '../models/bairro';
import {Cidade} from '../models/cidade';

@Component({
  selector: 'app-cadastro-usuario',
  templateUrl: './cadastro-usuario.component.html',
  styleUrls: ['./cadastro-usuario.component.css'],
  encapsulation: ViewEncapsulation.None
})

export class CadastroUsuarioComponent implements OnInit {

  private usuario: Usuario = new Usuario();
  private bairros: Bairro[] = [];
  private cidades: Cidade[] = [{codigo: 75680, descricao: 'Blumenau'},
  {codigo: 55298, descricao: 'Curitiba'},
  {codigo: 71986, descricao: 'Porto Alegre'}];

  constructor(private service: ServicoUsuarioService, private bairroServico: BairroService, private cidadeServico: CidadeService) {
    //    cidadeServico.getAll().subscribe(cidades => this.cidades = cidades, error => console.log(error), () => console.log("Pegou toda lista"));
//    bairroServico.getAll().subscribe(bairros => this.bairros = bairros, error => console.log(error), () => console.log("Pegou toda lista"));
  }

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
      this.confEmail.hasError('confEmail') ? 'Email é inválido' : '';
  }

  submit() {
    console.log(this.usuario);
    this.service.createUsuario(this.usuario).subscribe(usuario => console.log(usuario),
      error => console.log(error),
      () => console.log("Terminou cuzao")

    );
  }

  carregaBairro(codigoCidade) {
    this.bairroServico.getBairrosCIdade(codigoCidade).subscribe(bairros => this.bairros = bairros, error => console.log(error), () => console.log("Pegou toda lista"));
  }

  sex = [
    {value: '1', name: 'Masculino'},
    {value: '2', name: 'Feminino'},
    {value: '3', name: 'Ignorado'}
  ];

}
