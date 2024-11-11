import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListaVendasProdutosComponent } from './lista-vendas-produtos.component';

describe('ListaVendasProdutosComponent', () => {
  let component: ListaVendasProdutosComponent;
  let fixture: ComponentFixture<ListaVendasProdutosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ListaVendasProdutosComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListaVendasProdutosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
