import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';
import { UserDisplayComponent } from './user-display.component';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { DebugElement } from '@angular/core';
import { By } from '@angular/platform-browser';
import {PipesModule} from '../../pipes/pipes.module';
import {LoaderComponent} from '../../shared/loader/loader.component';
import {MatProgressSpinnerModule} from '@angular/material';

describe('UserDisplayComponent', () => {
  let component: UserDisplayComponent;
  let fixture: ComponentFixture<UserDisplayComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [
        UserDisplayComponent,
        LoaderComponent
      ],
      imports: [
        RouterTestingModule,
        HttpClientTestingModule,
        PipesModule,
        MatProgressSpinnerModule
      ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserDisplayComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
