import { Component, OnInit } from '@angular/core';
import {ProductCategory} from "../../common/product-category";
import {ProductService} from "../../services/product.service";
import {StandardResponse} from "../../common/StandardResponse";

@Component({
  selector: 'app-product-category-menu',
  templateUrl: './product-category-menu.component.html',
  styleUrls: ['./product-category-menu.component.css']
})
export class ProductCategoryMenuComponent implements OnInit {

  productCategories : ProductCategory[]=[];
  constructor(private productService: ProductService) { }

  ngOnInit(): void {
    this.listProductCategories();
  }
  private listProductCategories() {
      this.productService.getProductCategories().subscribe(
        (response: StandardResponse) => {
          if(response.code === 200){
            this.productCategories = response.data as ProductCategory[];
          }
        }
      );
  }

  protected readonly ProductCategory = ProductCategory;
}
