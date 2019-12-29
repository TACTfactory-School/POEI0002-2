import { Component, OnInit } from '@angular/core';
import {FormBuilder, Validators, AbstractControl } from '@angular/forms';
import { User } from '../user';
import { UserService } from '../user.service';
import {MAT_TOOLTIP_DEFAULT_OPTIONS, MatTooltipDefaultOptions} from '@angular/material/tooltip';
export const myCustomTooltipDefaults: MatTooltipDefaultOptions = {
  showDelay: 1000,
  hideDelay: 1000,
  touchendHideDelay: 1000,
};
@Component({
  selector: 'app-user-form',
  templateUrl: './user-form.component.html',
  styleUrls: ['./user-form.component.scss'],
  providers: [
    {provide: MAT_TOOLTIP_DEFAULT_OPTIONS, useValue: myCustomTooltipDefaults}
  ],
})
export class UserFormComponent implements OnInit {

  userSign = this.fb.group({username: ['',  Validators.required],
  password: ['', Validators.required],
  city: ['', Validators.required],
  enable: ['true', Validators.required],
  role: ['User', Validators.required]
});

constructor(private fb: FormBuilder, private service: UserService) { }

onSubmit(): void {
  const user: User = this.userSign.value;
  this.service
  .create(user)
  .subscribe();
  console.log('submitted');
}

get username(): AbstractControl { return this.userSign.get('username'); }
get password(): AbstractControl { return this.userSign.get('password'); }
get city(): AbstractControl { return this.userSign.get('city'); }
get enable(): AbstractControl { return this.userSign.get('enable'); }
get role(): AbstractControl { return this.userSign.get('role'); }

ngOnInit() {
}
}
