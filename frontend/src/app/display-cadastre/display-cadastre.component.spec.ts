import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DisplayCadastreComponent } from './display-cadastre.component';

describe('DisplayCadastreComponent', () => {
  let component: DisplayCadastreComponent;
  let fixture: ComponentFixture<DisplayCadastreComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DisplayCadastreComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DisplayCadastreComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
