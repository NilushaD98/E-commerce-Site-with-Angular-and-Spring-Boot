import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { StandardResponse } from '../common/StandardResponse';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private baseUrl = 'http://localhost:8083/api/v1/'
  constructor(private httpClient: HttpClient) {

   }
   getProductLit(page:number,size:number,categoryId: number): Observable<StandardResponse>{

    const searchURL = `${this.baseUrl}products/get_products_category_vice/?id=${categoryId}&page=${page}&size=${size}`
    return this.httpClient.get<StandardResponse>(searchURL);
   }

  getProductCategories() : Observable<StandardResponse>{
    const getProCategoryURL = `${this.baseUrl}product_category/get_all_categories`
    return this.httpClient.get<StandardResponse>(getProCategoryURL);

  }

  searchProducts(page:number,size:number,theKeyword: string): Observable<StandardResponse> {
    const searchProductURL = `${this.baseUrl}products/search_product_by_name/?name=${theKeyword}&page=${page}&size=${size}`
    return this.httpClient.get<StandardResponse>(searchProductURL);

  }

  getProduct(producId: number):Observable<StandardResponse> {
    const getProductDetailsURL = `${this.baseUrl}products/get_product_by_id/?id=${producId}`
    return this.httpClient.get<StandardResponse>(getProductDetailsURL);

  }
}


