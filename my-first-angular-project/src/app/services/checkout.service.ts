import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Order} from "../common/order";
import {Observable} from "rxjs";
import {StandardResponse} from "../common/StandardResponse";

@Injectable({
  providedIn: 'root'
})
export class CheckoutService {

  private baseURL = `http://localhost:8083/api/vi/order/order_save`
  constructor(private httpClient:HttpClient) { }
  placeOrder(order : Order):Observable<StandardResponse>{
    return this.httpClient.post<StandardResponse>(this.baseURL,order);
  }
}
