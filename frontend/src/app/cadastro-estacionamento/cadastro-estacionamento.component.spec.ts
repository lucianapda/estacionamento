import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CadastroEstacionamentoComponent } from './cadastro-estacionamento.component';

describe('CadastroEstacionamentoComponent', () => {
  let component: CadastroEstacionamentoComponent;
  let fixture: ComponentFixture<CadastroEstacionamentoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CadastroEstacionamentoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CadastroEstacionamentoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
