import { TestBed } from '@angular/core/testing';

import { Produtoservice } from '../../service/produto/produto.service';

describe('ProdutoserviceService', () => {
  let service: Produtoservice;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(Produtoservice);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
