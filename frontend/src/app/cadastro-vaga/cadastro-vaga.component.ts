import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { FormControl, FormGroupDirective, NgForm, Validators } from '@angular/forms';
import { ErrorStateMatcher } from '@angular/material/core';
import { ServicoVagaService } from './servico-vaga.service';

@Component({
  selector: 'app-cadastro-vaga',
  templateUrl: './cadastro-vaga.component.html',
  styleUrls: ['./cadastro-vaga.component.css'],
  encapsulation: ViewEncapsulation.None
})

export class CadastroVagaComponent implements OnInit {

  private vaga;
  
    constructor(private service: ServicoVagaService) { 
      //Como a chamada de serviço é assincrona passamos ao subscribe 3 métodos como parâmetro:
      //O primeiro é o que ele faz se houver sucesso.(Neste caso this.exemplos = exemplos)
      //O segundo é quando ocorre erro
      //O terceiro sempre é chamado independende se deu erro ou não
      service.getAll().subscribe( vaga => this.vaga = vaga, 
        error => console.log(error),
        () => console.log("Terminou")
      );
    }

  ngOnInit() {
  }
  
  tipoVaga = [
    {value: '1', name: 'Carro hatch'},
    {value: '2', name: 'Carro sedan'},
    {value: '3', name: 'Moto'},
    {value: '4', name: 'Caminh�o'}
  ];

}
