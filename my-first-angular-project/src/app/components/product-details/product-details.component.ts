import { Component, OnInit } from '@angular/core';
import {Product} from "../../common/product";
import {ProductService} from "../../services/product.service";
import {ActivatedRoute} from "@angular/router";
import {StandardResponse} from "../../common/StandardResponse";
import {CartItem} from "../../common/cart-item";
import {CartService} from "../../services/cart.service";

@Component({
  selector: 'app-product-details',
  templateUrl: './product-details.component.html',
  styleUrls: ['./product-details.component.css']
})
export class ProductDetailsComponent implements OnInit {
  product!: Product;

  constructor(private cartService: CartService,
              private productService: ProductService,
              private route: ActivatedRoute) { }
  ngOnInit(): void {
    this.route.paramMap.subscribe(
      ()=> {
        this.handleProductDetails();
      }
    );
  }
  private handleProductDetails() {
    const productId: string | null = this.route.snapshot.paramMap.get('id');
    if( productId !== null) {
      const producId = parseInt(productId, 10);
      this.productService.getProduct(producId).subscribe(
        (response: StandardResponse) => {
            if (response.code === 200){
              this.product = response.data as Product;
            }
        })
    }
  }
  addToCart() {
    const theCartItem = new CartItem(this.product);
    this.cartService.addToCart(theCartItem);
  }
}
