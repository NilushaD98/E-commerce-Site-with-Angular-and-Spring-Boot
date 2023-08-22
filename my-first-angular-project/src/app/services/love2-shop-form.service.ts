import { Injectable } from '@angular/core';
import {Observable, of} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {StandardResponse} from "../common/StandardResponse";

@Injectable({
  providedIn: 'root'
})
export class Love2ShopFormService {

  private baseURL: string = 'http://localhost:8083/api/v1/country/';
//country/get_all_states_by_code?code=US

  constructor( private httpClient: HttpClient) { }
  getCreditCardMonth(startMonth:number):Observable<number[]>{
    let data: number [] = [];
    for(let theMonth = startMonth; theMonth <=12 ; theMonth++){
      data.push(theMonth);
    }
    return of(data);
  }
  getCrediCardyears():Observable<number[]>{
    let data: number[]= [];
    const startYear: number = new Date().getFullYear();
    const endYear = startYear +10;
    for(let theYear = startYear;theYear<=endYear;theYear++){
      data.push(theYear);
    }
    return of(data);
  }

  getAllCountries():Observable<StandardResponse>{
    const getAllCountriesURL:string = `${this.baseURL}get_all_countries`;
    return this.httpClient.get<StandardResponse>(getAllCountriesURL);
  }

  getStatesByCode(code:string):Observable<StandardResponse>{
    const getAllStatesURL: string = `${this.baseURL}get_all_states_by_code?code=${code}`;
    return this.httpClient.get<StandardResponse>(getAllStatesURL);
  }
}
