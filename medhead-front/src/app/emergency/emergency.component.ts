import { HttpClient } from '@angular/common/http';
import { Component, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { environment } from 'src/environments/environment';

@Component({
  selector: 'app-emergency',
  templateUrl: './emergency.component.html',
  styleUrls: ['./emergency.component.css']
})
export class EmergencyComponent {

  public emergencies :any;
  public displayedColumns: string[] = ['speciality', 'hospitalName', 'emergencyBedrooms']
  @ViewChild(MatPaginator) paginator: MatPaginator;
  private apiUrl :string;


  constructor(private httpClient :HttpClient) {
    this.apiUrl = environment.USE_DOCKER === true
    ? 'http://ms-emergency-management:9090'
    : 'http://localhost:9090';
  }

  ngOnInit() {
    this.getEmergencies().subscribe( (data :any) => {
      this.emergencies = data;
      console.log(data);
      
      this.emergencies = new MatTableDataSource<any>(this.emergencies);
    })
  } 

  getEmergencies() {
    return this.httpClient.get(`${this.apiUrl}/emergencies`);
  }

  
}
