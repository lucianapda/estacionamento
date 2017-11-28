import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { ServicoEstacionamentoService } from './servico-estacionamento.service';

@Component({
  selector: 'app-information',
  templateUrl: './information.component.html',
  styleUrls: ['./information.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class InformationComponent implements OnInit {

  private estacionamento;
  private vaga;
  
  constructor(private service: ServicoEstacionamentoService) {
    //Como a chamada de serviço é assincrona passamos ao subscribe 3 métodos como parâmetro:
    //O primeiro é o que ele faz se houver sucesso.(Neste caso this.exemplos = exemplos)
    //O segundo é quando ocorre erro
    //O terceiro sempre é chamado independende se deu erro ou não
    service.getAll().subscribe(estacionamento => this.estacionamento = estacionamento, 
                                error => console.log(error),
                                () => console.log("Terminou")
      );
  }

  ngOnInit() {
  }

}
