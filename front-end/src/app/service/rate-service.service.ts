import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';
import { Global } from '../entity/global';

@Injectable({
  providedIn: 'root'
})
export class RateServiceService {

  //private baseUrl ='http://localhost:8083/cus-cloud/customer';
  constructor(private http: HttpClient,private global:Global) { }


  getGetRate(shpping_method:number,item:number,weight:number,country:string): Observable<any>{
    return this.http.get(`${this.global.baseUrl+'rate'}/${shpping_method}/${item}/${weight}/${country}`); 
  }

  getGetRateForService(shpping_method:number,item:number,itemType:number,itemSubType:number): Observable<any>{
    return this.http.get(`${this.global.baseUrl+'rate/service'}/${shpping_method}/${item}/${itemType}/${itemSubType}`); 
  }
}
