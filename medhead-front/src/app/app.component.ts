import { Component } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent{
  
  title = 'medhead-front';
  form: FormGroup;

  constructor(private formBuilder : FormBuilder, private router : Router) {
    this.form = this.formBuilder.group({
      id: '',
      password: ''
    })
  }
  
  submit() {
    if (this.form.controls['id'].value == 'medhead' && 
      this.form.controls["password"].value == 'password') {
      this.router.navigate(['/home'])
    } else {
      this.router.navigate(['/homed'])
    }
  }

  login() {
    // e.preventDefault();
    console.log('bonjour ta grand mere')
  }
}
