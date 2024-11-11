import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ModalLoginUsuarioComponent } from './modal-login-usuario.component';

describe('ModalLoginUsuarioComponent', () => {
  let component: ModalLoginUsuarioComponent;
  let fixture: ComponentFixture<ModalLoginUsuarioComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ModalLoginUsuarioComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ModalLoginUsuarioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
