import { Component, OnInit, ViewEncapsulation, Input } from '@angular/core';
import { Image } from '../../models/image';

@Component({
  selector: 'app-image',
  templateUrl: './image.component.html',
  styles: []
})
export class ImageComponent implements OnInit {
  @Input() image: Image;
  constructor() { }

  ngOnInit() {
  }

}
