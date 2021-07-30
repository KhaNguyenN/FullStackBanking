import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CheckingComponent } from './checking/checking.component';

import { CreditComponent } from './credit/credit.component';
import { HomePageComponent } from './home-page/home-page.component';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { SavingComponent } from './saving/saving.component';
import { AuthGuardService } from './services/auth-guard.service';
import { UserPageComponent } from './user-page/user-page.component';


const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'login', component: LoginComponent },
  { path: 'checking', component: CheckingComponent, canActivate:[AuthGuardService] },
  { path: 'credit', component: CreditComponent, canActivate:[AuthGuardService] },
  { path: 'login', component: LoginComponent },
  { path: 'logout', component: LogoutComponent, canActivate:[AuthGuardService]},
  { path: 'savings', component: SavingComponent, canActivate:[AuthGuardService]},
  { path: 'user', component: UserPageComponent, canActivate:[AuthGuardService]},
  { path: '', component: HomePageComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
