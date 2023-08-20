import { TestBed } from '@angular/core/testing';

import { Love2ShopFormService } from './love2-shop-form.service';

describe('Love2ShopFormService', () => {
  let service: Love2ShopFormService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(Love2ShopFormService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
