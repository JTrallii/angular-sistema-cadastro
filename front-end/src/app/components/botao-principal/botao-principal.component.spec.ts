import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BotaoPrincipalComponent } from './botao-principal.component';

describe('BotaoPrincipalComponent', () => {
  let component: BotaoPrincipalComponent;
  let fixture: ComponentFixture<BotaoPrincipalComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [BotaoPrincipalComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BotaoPrincipalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
