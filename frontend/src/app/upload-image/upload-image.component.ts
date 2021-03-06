import {Component, OnInit, ViewEncapsulation, Output, EventEmitter, Input} from '@angular/core';

@Component({
  selector: 'app-upload-image',
  templateUrl: './upload-image.component.html',
  styleUrls: ['./upload-image.component.css'],
  inputs: ['activeColor', 'baseColor', 'overlayColor'],
  encapsulation: ViewEncapsulation.None
})
export class UploadImageComponent {

  activeColor: string = 'green';
  baseColor: string = '#ccc';
  overlayColor: string = 'rgba(255,255,255,0.5)';
  borderColor: String;
  iconColor: String;
  dragging: boolean = false;
  loaded: boolean = false;
  imageLoaded: boolean = false;

  @Input() imageSrc: string = '/assets/imagens/user.png';
  @Input() height: string = "";
  @Input() widht: string = "";
  @Output() returnImage = new EventEmitter();

  constructor() {
  }

  handleDragEnter() {
    this.dragging = true;
  }

  handleDragLeave() {
    this.dragging = false;
  }

  handleDrop(e) {
    console.log(1);
    e.preventDefault();
    this.dragging = false;
    this.handleInputChange(e);
  }

  handleImageLoad() {
    this.imageLoaded = true;
    this.iconColor = this.overlayColor;
  }

  removerImg() {
    this.imageSrc = "";
    this.returnImage.emit({imgSelec: ""});
  }

  handleInputChange(e) {
    var file = e.dataTransfer ? e.dataTransfer.files[0] : e.target.files[0];
    var reader = new FileReader();
    var pattern = /image-*/;

    if (!file.type.match(pattern)) {
      alert('imagem do tipo errado');
      return;
    }
    this.loaded = false;

    reader.onload = this._handleReaderLoaded.bind(this);
    reader.readAsDataURL(file);
  }

  _handleReaderLoaded(e) {
    var reader = e.target;
    this.imageSrc = reader.result;
    this.loaded = true;
    this.returnImage.emit({imgSelec: this.imageSrc});
  }

  _setActive() {
    this.borderColor = this.activeColor;
    if (this.imageSrc.length === 0) {
      this.iconColor = this.activeColor;
    }
  }

  _setInactive() {
    this.borderColor = this.baseColor;
    if (this.imageSrc.length === 0) {
      this.iconColor = this.baseColor;
    }
  }


}
