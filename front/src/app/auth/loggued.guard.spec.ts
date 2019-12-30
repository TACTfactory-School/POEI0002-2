import { TestBed, async, inject } from '@angular/core/testing';
import { HttpClientTestingModule} from '@angular/common/http/testing';
import { LogguedGuard } from './loggued.guard';

describe('LogguedGuard', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [LogguedGuard]
    });
  });

  it('should ...', inject([LogguedGuard], (guard: LogguedGuard) => {
    expect(guard).toBeTruthy();
  }));
});
