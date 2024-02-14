import { HttpClient } from '@angular/common/http';
import { Component, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';

@Component({
  selector: 'app-emergency',
  templateUrl: './emergency.component.html',
  styleUrls: ['./emergency.component.css']
})
export class EmergencyComponent {

  public emergencies :any;
  public displayedColumns: string[] = ['speciality', 'hospitalName', 'emergencyBedrooms']
  @ViewChild(MatPaginator) paginator: MatPaginator;


  constructor(private httpClient :HttpClient) {
  }

  ngOnInit() {
    this.getEmergencies().subscribe( (data :any) => {
      this.emergencies = data;
      console.log(data);
      
      this.emergencies = new MatTableDataSource<any>(this.emergencies);
    })
  } 

  getEmergencies() {
    return this.httpClient.get("http://localhost:9090/emergencies");
  }

  
}
