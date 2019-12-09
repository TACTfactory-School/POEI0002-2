import { TestBed } from '@angular/core/testing';

import { EventListService } from './event-list.service';

describe('EventListService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: EventListService = TestBed.get(EventListService);
    expect(service).toBeTruthy();
  });
});
