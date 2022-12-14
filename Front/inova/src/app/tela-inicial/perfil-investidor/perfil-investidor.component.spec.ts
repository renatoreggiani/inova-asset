import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PerfilInvestidorComponent } from './perfil-investidor.component';

describe('PerfilInvestidorComponent', () => {
  let component: PerfilInvestidorComponent;
  let fixture: ComponentFixture<PerfilInvestidorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PerfilInvestidorComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PerfilInvestidorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
