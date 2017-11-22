import {TestBed, inject} from '@angular/core/testing';
import {ImgUsuarioService} from './imgUsuario.service';

describe('ImgUsuarioService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ImgUsuarioService]
    });
  });

  it('should be created', inject([ImgUsuarioService], (service: ImgUsuarioService) => {
    expect(service).toBeTruthy();
  }));
});
