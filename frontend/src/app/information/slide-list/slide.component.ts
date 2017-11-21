import { Component, OnInit, ViewEncapsulation, Input } from '@angular/core';
import { Image } from '../../models/image';

@Component({
  selector: 'app-slide',
  templateUrl: './slide.component.html',
  styles: [],
  encapsulation: ViewEncapsulation.None
})
export class SlideComponent implements OnInit {
  @Input() image: Image;
  constructor() { }

  ngOnInit() {
  }

}
