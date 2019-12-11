import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LogguedGuard } from './auth/loggued.guard';
import { EventListCardComponent } from './event/event-list/event-list-card/event-list-card.component';
import { UserListComponent } from './user/user-list/user-list.component';
import { UserFormLoginComponent } from './user/user-form/user-form-login/user-form-login.component';
import { UserFormComponent } from './user/user-form/user-form.component';
import { UserDisplayComponent } from './user/user-display/user-display.component';
import { EventDisplayComponent } from './event/event-display/event-display.component';
import { PagenotfoundComponent } from './error/pagenotfound/pagenotfound.component';


const routes: Routes = [
  {path: 'home', component: EventListCardComponent},
  {path: '', redirectTo: 'home', pathMatch: 'full'},
  { path: 'sign-up', component: UserFormComponent, pathMatch: 'full'},
  { path: 'login', component: UserFormLoginComponent, pathMatch: 'full'},

  {path: 'user',
  children: [
    { path: '',    component: UserListComponent, pathMatch: 'full' },
    { path: ':id', component: UserDisplayComponent},
  ]},
  {path: 'event',
    children: [
      {path: '', component: EventListCardComponent},
      {path: ':id', component: EventDisplayComponent}
    ]},
  {path: '**', component: PagenotfoundComponent}
];

@NgModule({

  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]

})

export class AppRoutingModule { }
