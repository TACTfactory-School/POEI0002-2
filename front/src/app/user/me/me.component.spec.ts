import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MeComponent } from './me.component';
import {PipesModule} from '../../pipes/pipes.module';
import {RouterTestingModule} from '@angular/router/testing';
import {HttpClientTestingModule} from '@angular/common/http/testing';

describe('MeComponent', () => {
  let component: MeComponent;
  let fixture: ComponentFixture<MeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MeComponent ],
      imports: [PipesModule,
                RouterTestingModule,
                HttpClientTestingModule]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
