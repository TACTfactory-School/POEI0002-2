import { Component, OnInit } from '@angular/core';
import {FormBuilder, Validators, AbstractControl } from '@angular/forms';
import { User } from '../../user';
import { AuthApiService } from '../../../auth/auth-api.service';

@Component({
  selector: 'app-user-form-login',
  templateUrl: './user-form-login.component.html',
  styleUrls: ['./user-form-login.component.scss']
})
export class UserFormLoginComponent implements OnInit {

  userLogin = this.fb.group({username: ['',  Validators.required],
                            password: ['', Validators.required]
                          });

  constructor(private fb: FormBuilder, private service: AuthApiService) {}

  onSubmit() {
    const user: User = this.userLogin.value;
    this.service
        .login(user.username, user.password)
        .subscribe();
    console.log('submitted');
  }

  get username(): AbstractControl { return this.userLogin.get('username'); }
  get password(): AbstractControl { return this.userLogin.get('password'); }

  ngOnInit() {
  }
}
