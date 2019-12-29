import { Component, OnInit } from '@angular/core';
import {FormBuilder, Validators, AbstractControl } from '@angular/forms';
import { User } from '../user';
import { UserService } from '../user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user-form',
  templateUrl: './user-form.component.html',
  styleUrls: ['./user-form.component.scss'],
})
export class UserFormComponent implements OnInit {

  userSign = this.fb.group({username: ['',  Validators.required],
  password: ['', Validators.required],
  city: ['', Validators.required],
  enable: ['true', Validators.required],
  role: ['User', Validators.required]
});

constructor(private fb: FormBuilder, private service: UserService, private router: Router) { }

onSubmit(): void {
  const user: User = this.userSign.value;
  this.service
  .create(user)
  .subscribe();
  console.log('submitted');
  this.router.navigate(['/login']);
}

get username(): AbstractControl { return this.userSign.get('username'); }
get password(): AbstractControl { return this.userSign.get('password'); }
get city(): AbstractControl { return this.userSign.get('city'); }
get enable(): AbstractControl { return this.userSign.get('enable'); }
get role(): AbstractControl { return this.userSign.get('role'); }

ngOnInit() {
}

}
