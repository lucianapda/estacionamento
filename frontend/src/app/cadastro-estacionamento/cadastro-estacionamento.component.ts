import {Component, OnInit, ViewEncapsulation} from '@angular/core';
import {EstacionamentoService} from './estacionamento.service';
import {Estacionamento} from '../models/estacionamento';
import {Localidade} from '../models/localidade';
import {BairroService} from '../models/bairro.service';
import {CidadeService} from '../models/cidade.service';
import {Usuario} from '../models/usuario';
import {Bairro} from '../models/bairro';
import {Cidade} from '../models/cidade';
import {LocalidadeService} from '../models/localidade.service';
import {LoginDialogComponent} from '../login-dialog/login-dialog.component';
import {ImgEstacionamento} from '../models/img-estacionamento';
import {ImgEstacionamentoService} from '../models/img-estacionamento.service';
import {Pais} from '../models/pais';
import {ActivatedRoute, Router} from '@angular/router';
import {error} from 'util';
import {UploadImageComponent} from '../upload-image/upload-image.component';

@Component({
  selector: 'app-cadastro-estacionamento',
  templateUrl: './cadastro-estacionamento.component.html',
  styleUrls: ['./cadastro-estacionamento.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class CadastroEstacionamentoComponent implements OnInit {

  private imagem: String;
  private estacionamento: Estacionamento;
  private bairros: Bairro[];
  private cidades: Cidade[];
  private codigoEstacionamento: number;
  private tipoAcao: number = 1;
  private isBtSaveCanVisible: boolean;
  private isBtEditExclVisible: boolean;
  private isReadOnly: boolean;
  private cepMask = [/\d/, /\d/, /\d/, /\d/, /\d/, '-', /\d/, /\d/, /\d/];
  private cnpjMask = [/\d/, /\d/, '.' , /\d/, /\d/, /\d/, '.', /\d/, /\d/, /\d/, "/", /\d/, /\d/, /\d/, /\d/, '-', /\d/, /\d/];

  constructor(private service: EstacionamentoService,
    private bairroServico: BairroService,
    private cidadeServico: CidadeService,
    private localidadeService: LocalidadeService,
    private route: ActivatedRoute,
    private routerPage: Router,
    private imgService: ImgEstacionamentoService) {

    this.estacionamento = new Estacionamento();

    this.cidades = [
      {codigo: 75680, descricao: 'Blumenau', uf: "SC", pais: new Pais()},
      {codigo: 55298, descricao: 'Curitiba', uf: "SC", pais: new Pais()},
      {codigo: 71986, descricao: 'Porto Alegre', uf: "SC", pais: new Pais()}];
    this.bairros = [];
    this.imagem = '';
  }

  ngOnInit() {
    this.codigoEstacionamento = this.route.snapshot.params['id'];

    if (this.codigoEstacionamento != null) {
      this.service.getByCode(this.codigoEstacionamento).subscribe(estacionamento => {
        this.estacionamento = estacionamento[0];
        this.isBtSaveCanVisible = false;
        this.isBtEditExclVisible = true;
        this.isReadOnly = true;
        this.carregaBairro(this.estacionamento.localidade.cidade.codigo);

        if (this.estacionamento.imagemEstacionamento != null && this.estacionamento.imagemEstacionamento.length > 0) {
          this.imagem = this.estacionamento.imagemEstacionamento[0].imagem;
        }
      }, error => console.log(error),
        () => console.log("editando estacionamento"));
    } else {
      this.isBtEditExclVisible = false;
      this.isBtSaveCanVisible = true;
      this.isReadOnly = false;
    }
  }

  setImage(event) {
    this.imagem = event.imgSelec;
  }

  submit() {

    switch (this.tipoAcao) {
      case 1:
        this.localidadeService.createLocalidade(this.estacionamento.localidade).subscribe(localidade => {
          this.estacionamento.localidade = localidade;

          this.service.createEstacionamento(this.estacionamento).subscribe(estacionamento => {
            this.estacionamento = estacionamento;

            this.salvarImagemBD();
            this.homePage();
          },
            error => console.log(error),
            () => "");
        }, error => console.log(error),
          () => "");
        break;

      case 2:
        this.localidadeService.editLocalidade(this.estacionamento.localidade).subscribe(localidade => {
          this.estacionamento.localidade = localidade;

          if (this.estacionamento.imagemEstacionamento != null && this.estacionamento.imagemEstacionamento.length > 0) {

            if (this.imagem != "") {
              this.estacionamento.imagemEstacionamento[0].imagem = this.imagem;
              this.estacionamento.imagemEstacionamento[0].estacionamento = new Estacionamento();
              this.estacionamento.imagemEstacionamento[0].estacionamento.codigo = this.estacionamento.codigo;

              this.imgService.editImgEst(this.estacionamento.imagemEstacionamento[0]).subscribe(retornoImg => {
                this.estacionamento.imagemEstacionamento = [retornoImg];
                this.service.editaEstaconamento(this.estacionamento).subscribe(estacionamento => {
                  this.estacionamento = estacionamento;
                  this.ajustarBotoes(true);
                },
                  error => console.log(error),
                  () => "Salvo estacionamento");
              }, error => console.log(error),
                () => console.log("Salvo Imagem"));
              return;
            } else {
              this.imgService.deleteImgEst(this.estacionamento.imagemEstacionamento[0].codigo).subscribe(retornoImg => {
                this.estacionamento.imagemEstacionamento = [];
                this.service.editaEstaconamento(this.estacionamento).subscribe(estacionamento => {
                  this.estacionamento = estacionamento;
                  this.ajustarBotoes(true);
                },
                  error => console.log(error),
                  () => "");
              },
                error => console.log(error),
                () => console.log("deletado Imagem"));
              return;
            }
          } else if (this.imagem != "") {
            this.salvarImagemBD();
            this.ajustarBotoes(true);
          }

          this.service.editaEstaconamento(this.estacionamento).subscribe(estacionamento => {
            this.estacionamento = estacionamento;
            this.ajustarBotoes(true);
          },
            error => console.log(error),
            () => "");
        }, error => console.log(error),
          () => "");
        break;

      case 3:

        if (this.estacionamento.imagemEstacionamento != null && this.estacionamento.imagemEstacionamento.length > 0) {
          this.imgService.deleteImgEst(this.estacionamento.imagemEstacionamento[0].codigo).subscribe(retornoImg => this.deletar(),
            error => console.log(error),
            () => console.log("deletado Imagem"));
        } else {
          this.deletar();
        }
        break;
    }

  }

  deletar() {
    this.service.deletaEstaconamento(this.estacionamento.codigo).subscribe(estacionamento => {
      this.localidadeService.deleteLocalidade(this.estacionamento.localidade.codigo).subscribe(localidade => {
        this.homePage();
      },
        error => console.log(error),
        () => "");
    },
      error => console.log(error),
      () => "");

  }

  editarCadastro() {
    this.tipoAcao = 2;
    this.ajustarBotoes(false);
  }

  deletarCadastro() {
    this.tipoAcao = 3;
    this.submit();
  }

  cancelar() {
    this.routerPage.navigateByUrl('');
  }

  ajustarBotoes(isTrue: boolean) {
    this.isReadOnly = isTrue;
    this.isBtEditExclVisible = isTrue;
    this.isBtSaveCanVisible = !isTrue;
  }

  salvarImagemBD() {
    if (this.imagem != "" && this.estacionamento != null && this.estacionamento.codigo > 0) {
      var img: ImgEstacionamento = new ImgEstacionamento(this.estacionamento);
      img.imagem = this.imagem;

      this.imgService.newImgEst(img).subscribe(retornoImg => {
        this.estacionamento.imagemEstacionamento.push(retornoImg);
      },
        error => console.log(error),
        () => console.log("Salvo Imagem"));
    }
  }

  homePage() {
    window.location.reload();
    this.routerPage.navigateByUrl('');
  }

  carregaBairro(codigoCidade) {
    this.bairroServico.getBairrosCIdade(codigoCidade).subscribe(bairros => this.bairros = bairros,
      error => console.log(error),
      () => console.log("Pegou toda lista"));
  }


}
