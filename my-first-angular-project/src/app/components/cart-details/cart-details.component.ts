import { Component, OnInit } from '@angular/core';
import {CartItem} from "../../common/cart-item";
import {CartService} from "../../services/cart.service";
import {dateComparator} from "@ng-bootstrap/ng-bootstrap/datepicker/datepicker-tools";

@Component({
  selector: 'app-cart-details',
  templateUrl: './cart-details.component.html',
  styleUrls: ['./cart-details.component.css']
})
export class CartDetailsComponent implements OnInit {

  cartItem: CartItem [] = [];
  totalPrice: number = 0;
  totalQuantity: number = 0;

  constructor(private cartService: CartService) { }

  ngOnInit(): void {
    this.listCartDetails();
  }

  private listCartDetails() {
    this.cartItem = this.cartService.cartItem;

    this.cartService.totalPrice.subscribe(
      data =>this.totalPrice = data
    );
    this.cartService.totalQuantity.subscribe(
      data=>this.totalQuantity =data
    );
    this.cartService.computeCartTotal();
  }

  incrementQuantity(tempCartItem: CartItem) {
    this.cartService.addToCart(tempCartItem);
  }

  decrementQuantity(tempCartItem: CartItem) {
      this.cartService.decrementQuantity(tempCartItem);
  }

  removeCartItem(tempCartItem: CartItem) {
    this.cartService.remove(tempCartItem);
  }
}
