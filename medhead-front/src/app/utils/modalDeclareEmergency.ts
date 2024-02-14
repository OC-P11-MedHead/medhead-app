/// <reference types="@types/googlemaps" />
import {Component, OnInit, ViewChild, AfterViewInit, ElementRef, ChangeDetectorRef} from '@angular/core';
import { CommonModule } from '@angular/common';
import {MatDialogModule} from '@angular/material/dialog';
import {MatButtonModule} from '@angular/material/button';
import {MatInputModule} from '@angular/material/input';
import {MatSelectModule, MatSelectChange} from '@angular/material/select';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatCardModule } from '@angular/material/card';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { Observable, ObservableInput, map, switchMap } from 'rxjs';
import { Router } from '@angular/router';
import { MessageService } from '../service/message.service';

@Component({
    selector: 'app-modal-declare-emergency',
    templateUrl: 'modalDeclareEmergency.html',
    styleUrls: ['modalDeclareEmergency.css'],
    standalone: true,
    imports: [CommonModule, MatDialogModule, MatButtonModule, MatFormFieldModule, MatInputModule, MatSelectModule, MatCardModule],
  })

  export class ModalDeclareEmergency {
    form :FormGroup = new FormGroup({})
    public specialities:any
    private apiKey = "AIzaSyCPzIXSOqNF2NC5mDAKDPpFpl2OsP7F9y8"
    public searchControl: FormControl;
    public latitude: number;
    public longitude: number;
    public emergencyGpsCoordinate: string;

    constructor(
      private formBuilder: FormBuilder,
      private httpClient : HttpClient,
      private cd: ChangeDetectorRef,
      private router: Router,
      private messageService :MessageService
    ) {
      this.searchControl = new FormControl();
      this.latitude = 0;
      this.longitude = 0;
    }

    ngOnInit() {
      this.getSpecialities().subscribe( (data :any) => {
        this.specialities = data;
      })
      this.form = this.formBuilder.group({
          address: [''],
          lat: '',
          lng: '',
          speciality: ''
      })
      this.cd.detectChanges();
    } 
    
    getSpecialities() {
      return this.httpClient.get('http://localhost:9000/specialities')
    }
  
    getCurrentPos() {
      if ("geolocation" in navigator) {
        navigator.geolocation.getCurrentPosition((position) => {
          this.form.patchValue({
            lat: position.coords.latitude,
            lng: position.coords.longitude
          })
          console.log(position.coords.latitude, position.coords.longitude);
        });
      } else {
        console.log("geo not available");
      }
    }

    changeAddress(event :MatSelectChange) {
      console.log(event.value);
      this.form.get('address').setValue(event.value)
    }

    changeSpeciality(event :MatSelectChange) {
      console.log(event.value);
      this.form.get('speciality').setValue(event.value)
    }

    geocodeAddress(address:any) :any { 
      var geocoder = new google.maps.Geocoder();
      // Préparer l'objet de demande
      var request = {
        address: address
      };
      let gpsCoordinate = "";
      // Appeler le service de géocodage
      geocoder.geocode(request, function(results, status) {
        if (status == google.maps.GeocoderStatus.OK) {
          // Coordonnées de la première adresse trouvée
          var latitude = results[0].geometry.location.lat();
          var longitude = results[0].geometry.location.lng();

          console.log('Latitude:', latitude);
          console.log('Longitude:', longitude);
          gpsCoordinate = `${latitude},${longitude}`;
          
        } else {
        }
      });
    }

    getCoordinates(address: string): Observable<any> {
      const url = `https://maps.googleapis.com/maps/api/geocode/json?address=${encodeURIComponent(address)}&key=${this.apiKey}`;
      return this.httpClient.get(url);
    }

    submit(e:any) {
      e.preventDefault();
      const selectedAddress = this.form.get('address')
      
      if (selectedAddress && selectedAddress.value !== null) {
        this.getCoordinates(selectedAddress.value)
          .pipe(
              switchMap( (response) => {
                const coordinates = response.results[0].geometry.location;
                coordinates.speciality =  this.form.get('speciality').value
                console.log("id Speciality envoyé ==>" , this.form.get('speciality').value);
                console.log(coordinates)
                return  this.httpClient.post<any>("http://localhost:8080/findNearest", coordinates)
              }),
              switchMap( (response2) => {
                console.log("response2", response2);
                
                this.messageService.showMessage({message: "L'urgence a bien été déclarée.", type:"success"})
                return this.router.navigate(['/emergencies'])
              })
            )
          .subscribe (finalResponse => {
            console.log("finalresponse", finalResponse);
          }, error => {
            console.error("Une erreur s'est produite : ", error.message);
            this.messageService.showMessage({message: "Une erreur s'est produite", type:"error"})
          })
          
        // .subscribe((response: any) => {
        //   // Traitement de la réponse de l'API Google Geocode
        //   const coordinates = response.results[0].geometry.location;
        //   coordinates.speciality =  this.form.get('speciality').value
        //   console.log("id Speciality envoyé ==>" , this.form.get('speciality').value);
          
        //   console.log(coordinates)
        //   this.httpClient.post<any>(
        //     "http://localhost:8080/findNearest",
        //     coordinates
        //   ).subscribe( (res) => {
        //     console.log(res);
        //     return this.router.navigate(['/emergencies'])
        //   })
        // }, (error: any) => {
          
        //   console.error('Une erreur s\'est produite lors de l\'appel à l\'API de géocodage : ', error);
        //   return this.router.navigate(['/emergencies'])
        // });
        // this.router.navigate(['/emergencies'])

      }
    }
  }