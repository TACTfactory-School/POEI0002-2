import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators, AbstractControl, FormGroup } from '@angular/forms';
import { User } from '../../user';
import { AuthApiService } from '../../../auth/auth-api.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user-form-login',
  templateUrl: './user-form-login.component.html',
  styleUrls: ['./user-form-login.component.scss']
})
export class UserFormLoginComponent implements OnInit {

  userLogin = this.fb.group({
    username: ['', Validators.required],
    password: ['', Validators.required]
  });

  constructor(private fb: FormBuilder, private service: AuthApiService, private readonly router: Router) { }

  onSubmit() {
    const { username, password } = this.userLogin.value;
    this.service
      .login(username, password)
      .subscribe(() => this.loginSuccess());
  }

  get username(): AbstractControl { return this.userLogin.get('username'); }
  get password(): AbstractControl { return this.userLogin.get('password'); }

  ngOnInit() {
    this.service.logout();
  }

  private loginSuccess() {
    this.router.navigate(['event']);
  }
}
