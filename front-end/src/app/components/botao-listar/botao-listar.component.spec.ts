import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BotaoListarComponent } from './botao-listar.component';

describe('BotaoListarComponent', () => {
  let component: BotaoListarComponent;
  let fixture: ComponentFixture<BotaoListarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [BotaoListarComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BotaoListarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
