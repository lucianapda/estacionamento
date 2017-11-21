import { TestBed, inject } from '@angular/core/testing';

import { ServicoLoginService } from './servico-login.service';

describe('ServicoLoginService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ServicoLoginService]
    });
  });

  it('should be created', inject([ServicoLoginService], (service: ServicoLoginService) => {
    expect(service).toBeTruthy();
  }));
});
