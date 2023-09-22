import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { SignupComponent } from './signup/signup.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { NameComponent } from './name/name.component';

const routes: Routes = [
  { path: 'login-component', component: LoginComponent },
  {path:'signup-component', component: SignupComponent},
  {path:'', component:HomeComponent},
  {path:'showName', component:NameComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
