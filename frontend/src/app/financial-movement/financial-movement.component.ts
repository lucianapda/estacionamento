import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { ServicoTransacaoService } from './servico-transacao.service';

@Component({
  selector: 'app-financial-movement',
  templateUrl: './financial-movement.component.html',
  styleUrls: ['./financial-movement.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class FinancialMovementComponent implements OnInit {

  private transacao

  constructor(private service: ServicoTransacaoService) {
    //Como a chamada de serviço é assincrona passamos ao subscribe 3 métodos como parâmetro:
    //O primeiro é o que ele faz se houver sucesso.(Neste caso this.exemplos = exemplos)
    //O segundo é quando ocorre erro
    //O terceiro sempre é chamado independende se deu erro ou não
    service.getAll().subscribe( transacao => this.transacao = transacao, 
                                error => console.log(error),
                                () => console.log("Terminou")
      );
  }

  ngOnInit() {
  }

  attendant = [
    {value: '1', name: 'João'},
    {value: '2', name: 'José'},
    {value: '3', name: 'Maria'}
  ];

  payment = [
    {value: '1', name: 'Dinheiro'},
    {value: '2', name: 'Cartão crédito'},
    {value: '3', name: 'Débito automático'}
  ];

}
