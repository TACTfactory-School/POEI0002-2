import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, FormBuilder, Validators, AbstractControl } from '@angular/forms';
import { User } from '../user';
import { from } from 'rxjs';
import { UserService } from '../user.service';

@Component({
  selector: 'app-user-form',
  templateUrl: './user-form.component.html',
  styleUrls: ['./user-form.component.scss']
})
export class UserFormComponent implements OnInit {

  userForm = this.fb.group({username: ['',  Validators.required],
                            password: ['', Validators.required],
                            city: ['', Validators.required]
                          });

  constructor(private fb: FormBuilder, private service: UserService) { }

  onSubmit(): void {
    const user: User = this.userForm.value;
    this.service
        .create(user)
        .subscribe();
    console.log('submitted');

  }

  get username(): AbstractControl { return this.userForm.get('username'); }
  get password(): AbstractControl { return this.userForm.get('password'); }
  get city(): AbstractControl { return this.userForm.get('city'); }

  ngOnInit() {
  }
}
