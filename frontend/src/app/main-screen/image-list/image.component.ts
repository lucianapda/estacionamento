import {Estacionamento} from '../../models/estacionamento';
import {Component, OnInit, ViewEncapsulation, Input} from '@angular/core';
import {Image} from '../../models/image';
import {Router} from '@angular/router';

@Component({
  selector: 'app-image',
  templateUrl: './image.component.html',
  styleUrls: ['./image.component.css']
})
export class ImageComponent implements OnInit {
  @Input() image: Estacionamento;

  constructor(private router: Router) {}

  ngOnInit() {
  }

  callInformation(codigo: number) {
    this.router.navigateByUrl('/information/' + codigo);
  }

}