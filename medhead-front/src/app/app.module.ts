import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HospitalComponent } from './hospital/hospital.component';
import { PatientComponent } from './patient/patient.component';
import { ErmegencyComponent } from './ermegency/ermegency.component';
import { EmergencyComponent } from './emergency/emergency.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent,
    HospitalComponent,
    PatientComponent,
    ErmegencyComponent,
    EmergencyComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
