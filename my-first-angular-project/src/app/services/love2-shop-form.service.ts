import { Injectable } from '@angular/core';
import {Observable, of} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class Love2ShopFormService {

  constructor() { }
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
}
