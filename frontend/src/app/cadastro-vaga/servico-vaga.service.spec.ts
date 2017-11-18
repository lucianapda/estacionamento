import { TestBed, inject } from '@angular/core/testing';

import { ServicoVagaService } from './servico-vaga.service';

describe('ServicoVagaService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ServicoVagaService]
    });
  });

  it('should be created', inject([ServicoVagaService], (service: ServicoVagaService) => {
    expect(service).toBeTruthy();
  }));
});
