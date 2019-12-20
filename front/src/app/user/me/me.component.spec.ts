import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MeComponent } from './me.component';
import {PipesModule} from '../../pipes/pipes.module';
import {RouterTestingModule} from '@angular/router/testing';
import {HttpClientTestingModule} from '@angular/common/http/testing';
import {LoaderComponent} from '../../shared/loader/loader.component';
import {MatProgressSpinnerModule} from '@angular/material';

describe('MeComponent', () => {
  let component: MeComponent;
  let fixture: ComponentFixture<MeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [
        MeComponent,
        LoaderComponent],
      imports: [
        PipesModule,
        RouterTestingModule,
        HttpClientTestingModule,
        MatProgressSpinnerModule]
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
