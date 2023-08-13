import { Component, OnInit } from '@angular/core';
import { Product } from 'src/app/common/product';
import { ProductService } from 'src/app/services/product.service';
import { StandardResponse } from 'src/app/common/StandardResponse';
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list-grid.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {

  products: Product[] = [];
  currenCategoryID : number =4;
  searchMode: boolean = false;
  constructor(
              private productService: ProductService,
              private route: ActivatedRoute
    ) {
  }

  ngOnInit(): void {
    this.route.paramMap.subscribe(
      ()=> {
        this.listProducts();
      }
  );

  }
  listProducts() {
    this.searchMode = this.route.snapshot.paramMap.has('keyword');
    if(this.searchMode){
      this.handleSearchProducts();
    }else {
      this.handleListProduct();
    }
  }
   handleListProduct(){
     const hasCategory: boolean = this.route.snapshot.paramMap.has('id');
     const id: string | null = this.route.snapshot.paramMap.get('id');
     if(hasCategory && id !== null){
       this.currenCategoryID = parseInt(id,10);
     }else {
       this.currenCategoryID = 1;
     }
     this.productService.getProductLit(this.currenCategoryID).subscribe(
       (response: StandardResponse) => {
         if (response.code === 200) {
           console.log(response.data);

           this.products = response.data as Product[];
         } else {
           // Handle error if needed
           console.error('Error fetching products:', response.message);
         }
       },
       (error) => {
         // Handle error if the HTTP request fails
         console.error('Error fetching products:', error);
       }
     );
   }

  private handleSearchProducts() {
    const  theKeyword : string = this.route.snapshot.paramMap.get('keyword')!;
    this.productService.searchProducts(theKeyword).subscribe(
      (response: StandardResponse) =>{
        if (response.code === 200) {
          console.log(response.data);

          this.products = response.data as Product[];
        }
      }
    );
  }
}
