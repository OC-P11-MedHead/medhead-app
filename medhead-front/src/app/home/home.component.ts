import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ModalDeclareEmergency } from '../utils/modalDeclareEmergency';
import { MatDialog, MatDialogModule } from '@angular/material/dialog';
import { MatButtonModule } from '@angular/material/button';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})

export class HomeComponent {

  public hospitals:any
  public displayedColumns: string[] = ['organisationName', 'latitude', 'longitude']

  constructor( public dialog: MatDialog, private httpClient : HttpClient) { }

  ngOnInit() {
    this.getHospitals().subscribe( (data :any) => {
      this.hospitals = data;
    })
  }

  getHospitals() {
    return this.httpClient.get('http://localhost:9000/hospitals')
  }

  openDialog() {
    const modal = this.dialog.open(ModalDeclareEmergency, {
      width:'800px !important'
    })
    modal.afterClosed().subscribe(result => {
      console.log('dialog result : ' + result)
    })
  }
}
