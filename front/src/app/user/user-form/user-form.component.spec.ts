import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import {ReactiveFormsModule, FormBuilder, FormsModule} from '@angular/forms';
import { UserFormComponent } from './user-form.component';
import { HttpClientTestingModule} from '@angular/common/http/testing';
import { By } from '@angular/platform-browser';
import {RouterTestingModule} from '@angular/router/testing';
import {MatFormFieldModule, MatInputModule, MatProgressSpinnerModule, MatSelectModule} from '@angular/material';
import {BrowserAnimationsModule, NoopAnimationsModule} from '@angular/platform-browser/animations';
import {LoaderComponent} from '../../shared/loader/loader.component';

describe('UserFormComponent', () => {
  let component: UserFormComponent;
  let fixture: ComponentFixture<UserFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [
        UserFormComponent,
        LoaderComponent
       ],
       imports: [
         HttpClientTestingModule,
         RouterTestingModule,
         MatInputModule,
         MatSelectModule,
         MatFormFieldModule,
         ReactiveFormsModule,
         MatProgressSpinnerModule
         ],
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it(`should notify in console on form submit`, () => {
    spyOn(console, 'log');

    const keyUsername = 'username';
    const keyPassword = 'password';
    const keyCity = 'city';
    const keyEnable = 'enable';
    const keyRole = 'role';

    component.userSign.controls[keyUsername].setValue('pingouin');
    component.userSign.controls[keyPassword].setValue('linux');
    component.userSign.controls[keyCity].setValue('Brest');
    component.userSign.controls[keyEnable].setValue('true');
    component.userSign.controls[keyRole].setValue('USER');
    fixture.debugElement.query(By.css('form')).triggerEventHandler('ngSubmit', null);
    fixture.detectChanges();

    expect(console.log).toHaveBeenCalled();
  });

  it('form invalid when empty', () => {
  expect(component.userSign.valid).toBeFalsy();
});

  it('name field validity', () => {

  const keyUsername = 'username';
  const keyPassword = 'password';
  const keyCity = 'city';
  const keyEnable = 'enable';
  const keyRole = 'role';

  const username = component.userSign.controls[keyUsername];
  const password = component.userSign.controls[keyPassword];
  const city = component.userSign.controls[keyCity];
  const enable = component.userSign.controls[keyEnable];
  const role = component.userSign.controls[keyRole];

  expect(username.valid).toBeFalsy();

  username.setValue('');
  expect(username.hasError('required')).toBeTruthy();

  password.setValue('');
  expect(password.hasError('required')).toBeTruthy();

  city.setValue('');
  expect(city.hasError('required')).toBeTruthy();

  enable.setValue('');
  expect(enable.hasError('required')).toBeTruthy();

  role.setValue('');
  expect(role.hasError('required')).toBeTruthy();

  username.setValue('A');
  password.setValue('B');
  city.setValue('C');
  enable.setValue('true');
  role.setValue('USER');
  expect(component.userSign.valid).toBeTruthy();
});

});
