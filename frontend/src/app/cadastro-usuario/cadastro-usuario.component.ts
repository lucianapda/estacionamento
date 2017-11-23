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
import {Router} from '@angular/router';

@Component({
  selector: 'app-cadastro-usuario',
  templateUrl: './cadastro-usuario.component.html',
  styleUrls: ['./cadastro-usuario.component.css'],
  encapsulation: ViewEncapsulation.None
})

export class CadastroUsuarioComponent implements OnInit {

  private usuario: Usuario = new Usuario();
  private bairros: Bairro[];
  private cidades: Cidade[];
  private imagem: String;
  private imgUsuario: ImgUsuario;

  constructor(private service: ServicoUsuarioService, private bairroServico: BairroService, private cidadeServico: CidadeService,
    private localidadeService: LocalidadeService, private imgUsuService: ImgUsuarioService, private router: Router) {
    this.cidades = [
      {codigo: 75680, descricao: 'Blumenau'},
      {codigo: 55298, descricao: 'Curitiba'},
      {codigo: 71986, descricao: 'Porto Alegre'}];
    this.bairros = [];
    this.imagem = '/assets/imagens/user.png';

    if (localStorage.getItem('codigoUsuLogado') != null) {
      this.service.getUsuario(parseInt(localStorage.getItem('codigoUsuLogado'))).subscribe(user => this.carregaUsuEdicao(user[0]), error => console.log(error), () => console.log("carregou usuario edi��o"));
    }
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

  carregaUsuEdicao(user: Usuario) {
    this.usuario.setIfo(user);
    if (user.localidade != null) {
      this.carregaBairro(user.localidade.cidade.codigo);
    }

    this.imgUsuService.getImg(user.codigo).subscribe(imgCarregada => this.imagem = imgCarregada[0].imagem, error => console.log(error), () => console.log("carregou imagens salvas"));
  }

  setImage(event) {
    this.imagem = event.imgSelec;
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
    var userAux = this.usuario;
    this.service.createUsuario(userAux).subscribe(user => this.salvarImagemBD(user), error => console.log(error), () => console.log("Finalizou usuario"));
  }

  salvarImagemBD(user: Usuario) {
    if (this.imagem != null && user != null) {
      this.imgUsuario = new ImgUsuario(user.codigo);

      this.imgUsuario.imagem = this.imagem;
      this.imgUsuService.newImgUsu(this.imgUsuario).subscribe(retornoImg => this.homePage(String(user.codigo)), error => console.log(error), () => console.log("Salvo Imagem"));
    }
  }

  homePage(codigo: string) {
    localStorage.setItem('codigoUsuLogado', codigo);
    this.router.navigateByUrl('');
  }

  carregaBairro(codigoCidade) {
    this.bairroServico.getBairrosCIdade(codigoCidade).subscribe(bairros => this.bairros = bairros, error => console.log(error), () => console.log("Pegou toda lista"));
  }

}
