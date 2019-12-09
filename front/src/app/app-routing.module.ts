import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PagenotfoundComponent } from './error/pagenotfound/pagenotfound.component';
import { EventListCardComponent } from './event/event-list/event-list-card/event-list-card.component';
import { UserListComponent } from './user/user-list/user-list.component';
import { UserDisplayComponent } from './user/user-display/user-display.component';
import { UserFormComponent } from './user/user-form/user-form.component';
import { LogguedGuard } from './auth/loggued.guard';
import { UserFormLoginComponent } from './user/user-form/user-form-login/user-form-login.component';

const routes: Routes = [
  {path: 'accueil', component: EventListCardComponent},
  {path: '', redirectTo: 'accueil', pathMatch: 'full'},
  {path: 'user',
  children: [
    { path: '',    component: UserListComponent, pathMatch: 'full' },
    { path: 'sign-up', component: UserFormComponent, pathMatch: 'full'},
    { path: 'login', component: UserFormLoginComponent, pathMatch: 'full'},

    { path: ':id', component: UserDisplayComponent},
  ]},
  {path: 'event', component: EventListCardComponent},
  {path: '**', component: PagenotfoundComponent}
];

@NgModule({

  imports: [RouterModule.forRoot(routes)],

  exports: [RouterModule]

})

export class AppRoutingModule { }
