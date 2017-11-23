import {Component, OnInit, ViewEncapsulation} from '@angular/core';
import {FormControl, FormGroupDirective, NgForm, Validators} from '@angular/forms';
import {ErrorStateMatcher} from '@angular/material/core';
import {ServicoUsuarioService} from './servico-usuario.service';
import {BairroService} from '../models/bairro.service';
import {CidadeService} from '../models/cidade.service';
import {Usuario} from '../models/usuario';
import {Bairro} from '../models/bairro';
import {Cidade} from '../models/cidade';
import {ImgUsuario} from '../models/imgUsuario';
import {ImgUsuarioService} from '../models/imgUsuario.service';
import {Localidade} from '../models/localidade';
import {LocalidadeService} from '../models/localidade.service';
import {UploadImageComponent} from '../upload-image/upload-image.component';

@Component({
  selector: 'app-cadastro-usuario',
  templateUrl: './cadastro-usuario.component.html',
  styleUrls: ['./cadastro-usuario.component.css'],
  encapsulation: ViewEncapsulation.None
})

export class CadastroUsuarioComponent implements OnInit {

  private usuario: Usuario;
  private bairros: Bairro[];
  private cidades: Cidade[];
  private imagem: FileReader;

  constructor(private service: ServicoUsuarioService, private bairroServico: BairroService, private cidadeServico: CidadeService,
    private localidadeService: LocalidadeService, private imgUsuService: ImgUsuarioService) {
    this.cidades = [
      {codigo: 75680, descricao: 'Blumenau'},
      {codigo: 55298, descricao: 'Curitiba'},
      {codigo: 71986, descricao: 'Porto Alegre'}];
    this.bairros = [];
    this.usuario = new Usuario();
  }

  ngOnInit() {
  }

  hide = true;
  hide2 = true;

  email = new FormControl('', [Validators.required, Validators.email]);
  confEmail = new FormControl('', [Validators.required, Validators.email]);

  sex = [
    {value: '1', name: 'Masculino'},
    {value: '2', name: 'Feminino'},
    {value: '3', name: 'Ignorado'}
  ];

  setImage(event) {
    this.imagem = event;
  }

  getErrorMessage() {
    return this.email.hasError('required') ? 'O email deve ser preenchido' :
      this.email.hasError('email') ? 'Email é inválido' : '';
  }

  getErrorMessageConf() {
    return this.confEmail.hasError('required') ? 'O email deve ser preenchido' :
      this.confEmail.hasError('confEmail') ? 'Email é inválido' : '';
  }

  submit() {
    var imgUsuario: ImgUsuario;

    this.localidadeService.createLocalidade(this.usuario.localidade).subscribe(localidade => this.usuario.localidade = localidade, error => console.log(error), () => console.log("Finalizou"));
    this.service.createUsuario(this.usuario).subscribe(usuario => imgUsuario.usuario = usuario, error => console.log(error), () => console.log("Finalizou"));

    if (imgUsuario != null && this.imagem != null) {
      imgUsuario.imagem = this.imagem.result;
      this.imgUsuService.newImgUsu(imgUsuario).subscribe(retornoImg => console.log(retornoImg), error => console.log(error), () => console.log("Finalizou"));
    }
  }

  carregaBairro(codigoCidade) {
    this.bairroServico.getBairrosCIdade(codigoCidade).subscribe(bairros => this.bairros = bairros, error => console.log(error), () => console.log("Pegou toda lista"));
  }

}
