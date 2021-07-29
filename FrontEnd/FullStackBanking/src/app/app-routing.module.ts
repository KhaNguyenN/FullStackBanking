import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CheckingComponent } from './checking/checking.component';

import { CreditComponent } from './credit/credit.component';
import { LoginComponent } from './login/login.component';
import { SavingComponent } from './saving/saving.component';


const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'login', component: LoginComponent },
  { path: 'checking', component: CheckingComponent },
  { path: 'credit', component: CreditComponent },
  { path: 'login', component: LoginComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
