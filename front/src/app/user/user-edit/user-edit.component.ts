import { Component, OnInit } from '@angular/core';
import {AbstractControl, FormBuilder, Validators} from '@angular/forms';
import {ActivatedRoute} from '@angular/router';
import { User } from '../user';
import { UserService } from '../user.service';
import { AuthApiService } from '../../auth/auth-api.service';

@Component({
  selector: 'app-user-edit',
  templateUrl: './user-edit.component.html',
  styleUrls: ['./user-edit.component.scss']
})
export class UserEditComponent implements OnInit {

  userEdit = this.fb.group({username: ['',  Validators.required],
                            city: ['',  Validators.required],
                            id: ['',  Validators.required],
                            profession: [''],
                            description: [''],
                            birthDate: [''],
                            enable: ['true', Validators.required],
                            mail: [''],
                            password: ['', Validators.required]
  });

  constructor(private fb: FormBuilder, private service: UserService, private readonly route: ActivatedRoute,
              private apiservice: AuthApiService) { }

  onSubmit(): void {
    const user: User = this.userEdit.value;
    this.service
      .update(user)
      .subscribe();
    console.log('submitted');
  }

  get username(): AbstractControl { return this.userEdit.get('username'); }
  get city(): AbstractControl { return this.userEdit.get('city'); }
  get id(): AbstractControl { return this.userEdit.get('id'); }
  get profession(): AbstractControl { return this.userEdit.get('profession'); }
  get description(): AbstractControl { return this.userEdit.get('description'); }
  get birthdate(): AbstractControl { return this.userEdit.get('birthDate'); }
  get enable(): AbstractControl { return this.userEdit.get('enable'); }
  get mail(): AbstractControl { return this.userEdit.get('mail'); }
  get password(): AbstractControl { return this.userEdit.get('password'); }

  ngOnInit() {
    this.route.url
      .subscribe(() => {
          this.apiservice.me().subscribe( u => this.userEdit.patchValue(u));
      });
  }
}
