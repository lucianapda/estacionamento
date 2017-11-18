import { TestBed, inject } from '@angular/core/testing';

import { ServicoEstacionamentoService } from './servico-estacionamento.service';

describe('ServicoEstacionamentoService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ServicoEstacionamentoService]
    });
  });

  it('should be created', inject([ServicoEstacionamentoService], (service: ServicoEstacionamentoService) => {
    expect(service).toBeTruthy();
  }));
});
