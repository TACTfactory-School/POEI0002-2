import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { ReactiveFormsModule, FormBuilder } from '@angular/forms';
import { UserFormComponent } from './user-form.component';
import { HttpClientTestingModule} from '@angular/common/http/testing';
import { By } from '@angular/platform-browser';

describe('UserFormComponent', () => {
  let component: UserFormComponent;
  let fixture: ComponentFixture<UserFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [
        UserFormComponent
      ],
      imports: [
        ReactiveFormsModule,
        HttpClientTestingModule
      ],
      providers: [
        FormBuilder
      ]
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

    component.userForm.controls[keyUsername].setValue('pingouin');
    component.userForm.controls[keyPassword].setValue('linux');
    component.userForm.controls[keyCity].setValue('Brest');
    fixture.debugElement.query(By.css('form')).triggerEventHandler('ngSubmit', null);
    fixture.detectChanges();

    expect(console.log).toHaveBeenCalled();
  });

  it('form invalid when empty', () => {
    expect(component.userForm.valid).toBeFalsy();
  });

  it('name field validity', () => {

    const keyUsername = 'username';
    const keyPassword = 'password';
    const keyCity = 'city';

    const username = component.userForm.controls[keyUsername];
    const password = component.userForm.controls[keyPassword];
    const city = component.userForm.controls[keyCity];

    expect(username.valid).toBeFalsy();

    username.setValue('');
    expect(username.hasError('required')).toBeTruthy();

    password.setValue('');
    expect(password.hasError('required')).toBeTruthy();

    city.setValue('');
    expect(city.hasError('required')).toBeTruthy();

    username.setValue('A');
    password.setValue('B');
    city.setValue('C');
    expect(component.userForm.valid).toBeTruthy();
  });
});
