import { TestBed } from '@angular/core/testing';

import { ContryServiceService } from './contry-service.service';

describe('ContryServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ContryServiceService = TestBed.get(ContryServiceService);
    expect(service).toBeTruthy();
  });
});
