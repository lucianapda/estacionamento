import { TestBed, inject } from '@angular/core/testing';

import { EstacionamentoService } from './estacionamento.service';

describe('EstacionamentoService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [EstacionamentoService]
    });
  });

  it('should be created', inject([EstacionamentoService], (service: EstacionamentoService) => {
    expect(service).toBeTruthy();
  }));
});
