import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { EstacionamentoService } from '../cadastro-estacionamento/estacionamento.service';
import { Estacionamento } from 'app/models/estacionamento';

@Component({
  selector: 'app-main-screen',
  templateUrl: './main-screen.component.html',
  styleUrls: ['./main-screen.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class MainScreenComponent implements OnInit {

  constructor() { }

  ngOnInit() { }

}
