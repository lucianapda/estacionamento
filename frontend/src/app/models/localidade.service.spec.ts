import {TestBed, inject} from '@angular/core/testing';
import {LocalidadeService} from './localidade.service';

describe('LocalidadeService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [LocalidadeService]
    });
  });

  it('should be created', inject([LocalidadeService], (service: LocalidadeService) => {
    expect(service).toBeTruthy();
  }));
});
