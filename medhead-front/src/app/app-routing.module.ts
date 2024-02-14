import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { HospitalsComponent } from './hospitals/hospitals.component';
import { EmergencyComponent } from './emergency/emergency.component';

const routes: Routes = [
  { path : '', component: LoginComponent},
  { path: 'home', component : HomeComponent},
  { path: 'hospitals', component : HospitalsComponent},
  { path: 'emergencies', component : EmergencyComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
