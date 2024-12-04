import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MensagemErroValidacaoComponent } from './mensagem-erro-validacao.component';

describe('MensagemErroValidacaoComponent', () => {
  let component: MensagemErroValidacaoComponent;
  let fixture: ComponentFixture<MensagemErroValidacaoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [MensagemErroValidacaoComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MensagemErroValidacaoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
