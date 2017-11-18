import { TestBed, inject } from '@angular/core/testing';

import { ServicoTransacaoService } from './servico-transacao.service';

describe('ServicoTransacaoService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ServicoTransacaoService]
    });
  });

  it('should be created', inject([ServicoTransacaoService], (service: ServicoTransacaoService) => {
    expect(service).toBeTruthy();
  }));
});
