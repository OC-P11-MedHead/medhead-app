import { Component } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { ModalDeclareEmergency } from './utils/modalDeclareEmergency';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent{
  
  title = 'medhead-front';
  form: FormGroup;
  currentRoot = 't'
  isAsideVisible = true

  constructor(private formBuilder : FormBuilder, private router : Router, public dialog: MatDialog) {
    this.form = this.formBuilder.group({
      id: '',
      password: ''
    })
  }

  ngOnDestroy() {
    this.isAsideVisible = true
  }

  submit() {
    if (this.form.controls['id'].value == 'medhead' && 
      this.form.controls["password"].value == 'password') {
      this.router.navigate(['/hospitals'])
    } else {
      this.router.navigate(['/'])
    }
  }

  login() {
    // e.preventDefault();
    console.log('bonjour ta grand mere')
  }

  openDialog() {
    const modal = this.dialog.open(ModalDeclareEmergency)
    modal.afterClosed().subscribe(result => {
      console.log('dialog result : ' + result)
    })
  }
}
