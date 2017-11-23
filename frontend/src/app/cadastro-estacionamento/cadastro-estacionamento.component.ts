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
import { Pais } from '../models/pais';

@Component({
  selector: 'app-cadastro-estacionamento',
  templateUrl: './cadastro-estacionamento.component.html',
  styleUrls: ['./cadastro-estacionamento.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class CadastroEstacionamentoComponent implements OnInit {

  private estacionamento: Estacionamento;
  private bairros: Bairro[] = [];
  private cidades: Cidade[] = [{codigo: 75680, descricao: 'Blumenau', pais: new Pais()},
  {codigo: 55298, descricao: 'Curitiba', pais: new Pais()},
  {codigo: 71986, descricao: 'Porto Alegre', pais: new Pais()}];

  constructor(private service: EstacionamentoService, private bairroServico: BairroService, private cidadeServico: CidadeService,
    private localidadeService: LocalidadeService) {
    this.estacionamento = new Estacionamento();
  }

  ngOnInit() {
  }

  submit() {
    //    this.localidadeService.createLocalidade(this.estacionamento.localidade).subscribe(localidade => this.estacionamento.localidade = localidade, error => console.log(error), () => console.log("Finalizou"));
    //    console.log(this.estacionamento.localidade);
    //    console.log(this.estacionamento);    
    this.service.createEstacionamento(this.estacionamento).subscribe(estacionamento => console.log(estacionamento), error => console.log(error), () => console.log("Finalizou"));
  }

  carregaBairro(codigoCidade) {
    this.bairroServico.getBairrosCIdade(codigoCidade).subscribe(bairros => this.bairros = bairros, error => console.log(error), () => console.log("Pegou toda lista"));
  }


}
