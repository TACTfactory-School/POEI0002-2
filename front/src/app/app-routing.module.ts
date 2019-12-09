import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PagenotfoundComponent } from './error/pagenotfound/pagenotfound.component';
import { EventListCardComponent } from './event/event-list/event-list-card/event-list-card.component';
import { UserListComponent } from './user/user-list/user-list.component';
import { UserDisplayComponent } from './user/user-display/user-display.component';
import { UserFormComponent } from './user/user-form/user-form.component';
import { LogguedGuard } from './auth/loggued.guard';

const routes: Routes = [
  {path: 'home', component: EventListCardComponent},
  {path: '', redirectTo: 'home', pathMatch: 'full'},
  {path: 'user',
  children: [
    { path: '',    component: UserListComponent, pathMatch: 'full' },
    { path: 'createreactive', component: UserFormComponent, pathMatch: 'full'},
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
