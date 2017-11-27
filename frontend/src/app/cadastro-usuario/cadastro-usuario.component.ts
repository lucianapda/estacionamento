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
import {Pais} from '../models/pais';
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
  private tipoAcao: number = 1;
  private isBtSaveCanVisible: boolean;
  private isBtEditExclVisible: boolean;
  private isReadOnly: boolean;
  private cepMask = [/\d/, /\d/, /\d/, /\d/, /\d/, '-', /\d/, /\d/, /\d/];
  private telMask = ['(', /\d/, /\d/, ')', ' ', /\d/, /\d/, /\d/, /\d/, /\d/, '-', /\d/, /\d/, /\d/, /\d/];

  constructor(private service: ServicoUsuarioService, private bairroServico: BairroService, private cidadeServico: CidadeService,
    private localidadeService: LocalidadeService, private imgUsuService: ImgUsuarioService, private router: Router) {
    this.cidades = [
      {codigo: 75680, descricao: 'Blumenau', pais: new Pais()},
      {codigo: 55298, descricao: 'Curitiba', pais: new Pais()},
      {codigo: 71986, descricao: 'Porto Alegre', pais: new Pais()}];
    this.bairros = [];
    this.imagem = '';

    if (localStorage.getItem('codigoUsuLogado') != null) {
      console.log(localStorage.getItem('codigoUsuLogado'));
      this.isBtSaveCanVisible = false;
      this.isBtEditExclVisible = true;
      this.isReadOnly = false;

      this.service.getUsuario(parseInt(localStorage.getItem('codigoUsuLogado'))).subscribe(user => this.carregaUsuEdicao(user[0]),
        error => console.log(error),
        () => console.log("carregou usuario edi��o"));

    } else {
      this.isBtEditExclVisible = false;
      this.isBtSaveCanVisible = true;
      this.isReadOnly = false;
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

    this.localidadeService.getLocalidade(this.usuario.localidade.codigo).subscribe(localidade => this.usuario.localidade = localidade[0],
      error => console.log(error),
      () => console.log("carregou localidade"));

    this.usuario.setIfo(user);
    if (user.localidade != null) {
      this.carregaBairro(user.localidade.cidade.codigo);
    }

    this.imgUsuService.getImg(user.codigo).subscribe(imgCarregada => this.usuario.usuarioImgs = imgCarregada,
      error => console.log(error),
      () => console.log("carregou imagens salvas"));

    this.imagem = this.usuario.usuarioImgs[0].imagem;
  }

  setImage(event) {
    this.imagem = event.imgSelec;
  }

  cancelar() {
    this.router.navigateByUrl('');
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

    switch (this.tipoAcao) {
      case 1:
        this.localidadeService.createLocalidade(this.usuario.localidade).subscribe(localidade => {
          this.usuario.localidade = localidade;
          this.service.createUsuario(this.usuario).subscribe(user => {
            this.usuario.setIfo(user);
            this.salvarImagemBD();
            this.homePage();
          },
            error => console.log(error),
            () => "");
        }, error => console.log(error),
          () => "");

        break;

      case 2:
        this.localidadeService.editLocalidade(this.usuario.localidade).subscribe(localidade => {
          this.usuario.localidade = localidade;

          if (this.usuario.usuarioImgs != null && this.usuario.usuarioImgs.length > 0) {

            if (this.imagem != "") {
              this.usuario.usuarioImgs[0].imagem = this.imagem;
              this.imgUsuService.editImgUsu(this.usuario.usuarioImgs[0]).subscribe(retornoImg => {
                this.service.editUsuario(this.usuario).subscribe(user => {
                  this.usuario.setIfo(user);
                  this.ajustarBotoes(true);
                },
                  error => console.log(error),
                  () => "");
              }, error => console.log(error),
                () => console.log("Salvo Imagem"));
            } else {
              this.imgUsuService.deleteImgUsu(this.usuario.usuarioImgs[0].codigo).subscribe(retornoImg => {
                this.service.editUsuario(this.usuario).subscribe(user => {
                  this.usuario.setIfo(user);
                  this.ajustarBotoes(true);
                },
                  error => console.log(error),
                  () => "");
              },
                error => console.log(error),
                () => console.log("deletado Imagem"));
            }
          } else if (this.imagem != "") {
            this.salvarImagemBD();
          }
        }, error => console.log(error),
          () => "");
        break;

      case 3:

        if (this.usuario.usuarioImgs != null && this.usuario.usuarioImgs.length > 0) {
          this.imgUsuService.deleteImgUsu(this.usuario.usuarioImgs[0].codigo).subscribe(retornoImg => this.deletar(),
            error => console.log(error),
            () => console.log("deletado Imagem"));
        } else {
          this.deletar();
        }


        break;
    }

  }

  deletar() {
    this.localidadeService.deleteLocalidade(this.usuario.localidade.codigo).subscribe(localidade => console.log(localidade),
      error => console.log(error),
      () => "");

    this.service.deleteUsuario(this.usuario.codigo).subscribe(user => console.log(user),
      error => console.log(error),
      () => "");

    localStorage.removeItem('codigoUsuLogado');

    this.homePage();
  }

  editarCadastr() {
    this.tipoAcao = 2;
    this.ajustarBotoes(false);
  }

  deletarCadastro() {
    this.tipoAcao = 3;
    this.ajustarBotoes(false);
    this.submit();
  }

  ajustarBotoes(isTrue: boolean) {
    this.isReadOnly = isTrue;
    this.isBtEditExclVisible = isTrue;
    this.isBtSaveCanVisible = !isTrue;
  }

  salvarImagemBD() {
    if (this.imagem != "" && this.usuario != null && this.usuario.codigo > 0) {
      var img = new ImgUsuario(this.usuario);
      img.imagem = this.imagem;
      img.usuario = this.usuario;

      console.log(img);
      this.imgUsuService.newImgUsu(img).subscribe(retornoImg => "Salvo img",
        error => console.log(error),
        () => console.log("Salvo Imagem"));
    }
  }

  homePage() {
    localStorage.setItem('codigoUsuLogado', String(this.usuario.codigo));
    this.router.navigateByUrl('');
    window.location.reload();
  }

  carregaBairro(codigoCidade) {
    this.bairroServico.getBairrosCIdade(codigoCidade).subscribe(bairros => this.bairros = bairros,
      error => console.log(error),
      () => console.log("Pegou toda lista"));
  }

}
