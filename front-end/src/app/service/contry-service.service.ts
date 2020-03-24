import { Injectable } from '@angular/core';
import { Global } from '../entity/global';
import {HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ContryServiceService {

  constructor(private http: HttpClient,private global:Global) { }

  getAirMailCountry(): Observable<any>{
    return this.http.get(`${this.global.baseUrl+'country/air_mail/'}`);
  }

  getEMSCountry(): Observable<any>{
    return this.http.get(`${this.global.baseUrl+'country/ems/'}`);
  }

  getAirParcelCountry(): Observable<any>{
    return this.http.get(`${this.global.baseUrl+'country/air_parcel/'}`);
  }

  getSeaParcelCountry(): Observable<any>{
    return this.http.get(`${this.global.baseUrl+'country/sea_parcel/'}`);
  }
}
