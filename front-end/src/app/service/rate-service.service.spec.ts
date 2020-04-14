import { TestBed } from '@angular/core/testing';

import { RateServiceService } from './rate-service.service';

describe('RateServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: RateServiceService = TestBed.get(RateServiceService);
    expect(service).toBeTruthy();
  });
});
