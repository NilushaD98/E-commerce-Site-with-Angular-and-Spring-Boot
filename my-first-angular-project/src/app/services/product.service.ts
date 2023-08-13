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
   getProductLit(categoryId: number): Observable<StandardResponse>{

    const searchURL = `${this.baseUrl}products/get_products_category_vice/?id=${categoryId}&page=0&size=10`
    return this.httpClient.get<StandardResponse>(searchURL);
   }

  getProductCategories() : Observable<StandardResponse>{
    const getProCategoryURL = `${this.baseUrl}product_category/get_all_categories`
    return this.httpClient.get<StandardResponse>(getProCategoryURL);

  }

  searchProducts(theKeyword: string): Observable<StandardResponse> {
    const searchProductURL = `${this.baseUrl}products/search_product_by_name/?name=${theKeyword}&page=0&size=50`
    return this.httpClient.get<StandardResponse>(searchProductURL);

  }
}


