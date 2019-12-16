import { Component, OnInit } from '@angular/core';
import {AbstractControl, FormBuilder, Validators} from '@angular/forms';
import {Observable} from 'rxjs';
import {ActivatedRoute} from '@angular/router';
import { User } from '../user';
import { UserService } from '../user.service';

@Component({
  selector: 'app-user-edit',
  templateUrl: './user-edit.component.html',
  styleUrls: ['./user-edit.component.scss']
})
export class UserEditComponent implements OnInit {

  private user: Observable<User>;

  userEdit = this.fb.group({username: ['',  Validators.required],
                            city: ['',  Validators.required],
                            id: ['',  Validators.required],
                            profession: [''],
                            birthdate: [''],
                            enable: ['true', Validators.required],
                            mail: [''],
                            password: ['', Validators.required]
  });

  constructor(private fb: FormBuilder, private service: UserService, private readonly route: ActivatedRoute, ) { }

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
  get birthdate(): AbstractControl { return this.userEdit.get('birthdate'); }
  get enable(): AbstractControl { return this.userEdit.get('enable'); }
  get mail(): AbstractControl { return this.userEdit.get('mail'); }
  get password(): AbstractControl { return this.userEdit.get('password'); }

  ngOnInit() {
    this.route
      .params
      .subscribe(params => {
        if (params.id) {
          this.user = this.service.getOne(params.id);
        }
      });
  }
}
