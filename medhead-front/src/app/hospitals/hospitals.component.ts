import { HttpClient } from '@angular/common/http';
import { AfterViewInit, Component, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { Hospital } from '../models/hospital.model';
import { Observable } from 'rxjs';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';

@Component({
  selector: 'app-hospitals',
  templateUrl: './hospitals.component.html',
  styleUrls: ['./hospitals.component.css']
})
export class HospitalsComponent {

  public hospitals:any
  public displayedColumns: string[] = ['organisationName', 'emergencyBedrooms', 'specialities']
  @ViewChild(MatPaginator) paginator: MatPaginator;

  constructor( public dialog: MatDialog, private httpClient : HttpClient) { }
  
  
  ngOnInit() {
    this.getHospitals().subscribe( (data :any) => {
      this.hospitals = data;
      this.hospitals = new MatTableDataSource<any>(this.hospitals);
      this.hospitals.paginator = this.paginator;
    })
  }

  getHospitals() {
    return this.httpClient.get('http://localhost:9000/hospitals')
  }

  concatNameSpecialities(specialities: any[]): string {
    return specialities.map(speciality => speciality.libelle).join(', ');
  }
}
