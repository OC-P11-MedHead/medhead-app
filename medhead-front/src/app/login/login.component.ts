import { Component, NgModule, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, FormsModule } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
    selector: 'app-login',
    templateUrl: './login.component.html',
    styleUrls: ['./login.component.css']
})

export class LoginComponent implements OnInit {
    title = 'medhead-front';
    form: FormGroup = new FormGroup({});
    error = ""

    constructor(private formBuilder: FormBuilder, private router: Router) { }

    ngOnInit() {
        this.form = this.formBuilder.group({
            id: '',
            password: ''
        })
    }

    submit(e: any) {
        e.preventDefault();
        console.log(this.form.controls['id'], this.form.controls["password"]);

        if (this.form.controls['id'].value === "medhead" && this.form.controls['password'].value === "password") {
            this.router.navigate(['/hospitals'])
        } else {
            this.error = "Identifiant ou mot de passe incorrect";
        }
    }

    login() {
        // e.preventDefault();
        console.log('bonjour ta grand mere')
    }
}
