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
import { EventFormComponent } from './event/event-form/event-form.component';
import { EventListTableComponent } from './event/event-list/event-list-table/event-list-table.component';
import { EventEditComponent } from './event/event-edit/event-edit.component';
import { MeComponent } from './user/me/me.component';
import { UserEditComponent } from './user/user-edit/user-edit.component';


const routes: Routes = [
  { path: 'home', redirectTo: 'event' },
  { path: '', redirectTo: 'event', pathMatch: 'full' },
  { path: 'login', component: UserFormLoginComponent, pathMatch: 'full' },
  { path: 'sign-up', component: UserFormComponent, pathMatch: 'full' },
  { path: 'tab-event', component: EventListTableComponent, pathMatch: 'full' },
  {
    path: 'user',
    children: [
      { path: '', component: UserListComponent, pathMatch: 'full' },
      {
        path: 'me',
        children: [
          { path: '', component: MeComponent, pathMatch: 'full' },
          { path: 'edit', component: UserEditComponent, pathMatch: 'full' },
        ]
      },
      { path: ':id', component: UserDisplayComponent },
    ]
  },
  {
    path: 'event',
    children: [
      { path: '', component: EventListCardComponent },
      { path: 'create', component: EventFormComponent, /* canActivate: [ LogguedGuard ]*/ },
      {
        path: ':id',
        children: [
          { path: '', component: EventDisplayComponent },
          { path: 'edit', component: EventEditComponent }
        ]
      }
    ]
  },
  { path: '**', component: PagenotfoundComponent }
];

@NgModule({

  imports: [RouterModule.forRoot(routes)],

  exports: [RouterModule]

})

export class AppRoutingModule { }
