import { TestBed, inject } from '@angular/core/testing';

import { ImgEstacionamentoService } from './img-estacionamento.service';

describe('ImgEstacionamentoService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ImgEstacionamentoService]
    });
  });

  it('should be created', inject([ImgEstacionamentoService], (service: ImgEstacionamentoService) => {
    expect(service).toBeTruthy();
  }));
});
