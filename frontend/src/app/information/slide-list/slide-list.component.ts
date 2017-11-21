import {Component, OnInit, ViewEncapsulation} from '@angular/core';
import {Image} from '../../models/image';

@Component({
  selector: 'app-slide-list',
  templateUrl: './slide-list.component.html',
  styleUrls: ['./slide-list.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class SlideListComponent implements OnInit {

  images: Image[] = [
    new Image('1', 'Primera Imagem', 'Descripcion primera imagen', 'https://videotutoriales.com/maspa/maspa1.jpg', 'https://videotutoriales.com/maspa/maspa1-1.jpg'),
    new Image('2', 'Segunda Imagem', 'Descripcion primera imagen', 'https://videotutoriales.com/maspa/maspa2.jpg', 'https://videotutoriales.com/maspa/maspa2-1.jpg'),
    new Image('3', 'Terceira Imagem', 'Descripcion primera imagen', 'https://videotutoriales.com/maspa/maspa3.jpg', 'https://videotutoriales.com/maspa/maspa3-1.jpg'),
    new Image('4', 'Quarta Imagem', 'Descripcion primera imagen', 'https://videotutoriales.com/maspa/maspa4.jpg', 'https://videotutoriales.com/maspa/maspa4-1.jpg'),
    new Image('5', 'Quinta Imagem', 'Descripcion primera imagen', 'https://videotutoriales.com/maspa/maspa5.jpg', 'https://videotutoriales.com/maspa/maspa5-1.jpg'),
    new Image('6', 'Sexta Imagem', 'Descripcion primera imagen', 'https://videotutoriales.com/maspa/maspa6.jpg', 'https://videotutoriales.com/maspa/maspa6-1.jpg'),
    new Image('7', 'Setima Imagem', 'Descripcion primera imagen', 'https://videotutoriales.com/maspa/maspa7.jpg', 'https://videotutoriales.com/maspa/maspa7-1.jpg'),
    new Image('8', 'Oitava Imagem', 'Descripcion primera imagen', 'https://videotutoriales.com/maspa/maspa8.jpg', 'https://videotutoriales.com/maspa/maspa8-1.jpg')
  ]

  constructor() {
  }

  ngOnInit() {
  }


}
