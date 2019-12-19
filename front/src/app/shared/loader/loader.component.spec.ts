import { async, ComponentFixture, TestBed, tick, fakeAsync } from '@angular/core/testing';

import { LoaderComponent } from './loader.component';
import { EventEmitter } from 'events';
import { Observable } from 'rxjs';

function expectAnimationDuration(
    comp: {animationDuration: number, animationFinished: Observable<void>},
    fixture: ComponentFixture<LoaderComponent>,
    duration: number|null,
    expectedValue: boolean) {
  comp.animationDuration = duration;
  fixture.detectChanges();
  let received = false;

  comp
      .animationFinished
      .subscribe(() => received = true);

  tick(duration || 0 + 100);
  fixture.detectChanges();

  fixture
      .whenStable()
      .then(() => expect(received).toBe(expectedValue));
}


describe('LoaderComponent', () => {
  let component: LoaderComponent;
  let fixture: ComponentFixture<LoaderComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LoaderComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LoaderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => expect(component).toBeTruthy());

  it('should have default message', () => expect(component.text).toEqual('Chargement...'));

  it('should accept other message', () => {
    (component as {text: string}).text = 'Custom message!';
    fixture.detectChanges();
    expect(component.text).toEqual('Custom message!');
  });

  it('should accept animation duration', fakeAsync(() => {
    expectAnimationDuration(component as any, fixture, 20, true);
  }));

  it('should not crash if given animation duration is falsy', fakeAsync(() => {
    expectAnimationDuration(component as any, fixture, null, false);
  }))
});
