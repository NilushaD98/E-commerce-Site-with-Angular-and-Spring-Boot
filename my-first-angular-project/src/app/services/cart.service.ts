import { Injectable } from '@angular/core';
import {CartItem} from "../common/cart-item";
import {Subject} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class CartService {

  cartItem: CartItem[] = [];
  totalPrice: Subject<number> = new Subject<number>();
  totalQuantity: Subject<number> = new Subject<number>();
  constructor() {

  }

  addToCart(theCartItem: CartItem){
    let alreadyExistInCart : boolean = false;
    let existingCartItem : CartItem|undefined;

    if(this.cartItem.length>0) {

      // for (let tempCartItem of this.cartItem) {
      //   if (tempCartItem.id === theCartItem.id) {
      //     existingCartItem = tempCartItem;
      //     break;
      //   }
      // }

      existingCartItem = this.cartItem.find(tempCartItem => tempCartItem.id === theCartItem.id);
      alreadyExistInCart = (existingCartItem != undefined);
    }
      if (alreadyExistInCart) {
        existingCartItem!.quantity++;
      } else {
        this.cartItem.push(theCartItem);
      }
      this.computeCartTotal();

  }

  private computeCartTotal() {
    let totalPriceValue : number = 0;
    let toatalQuantityValue: number = 0;

    for(let curentCartItem of this.cartItem){
      totalPriceValue += curentCartItem.quantity * curentCartItem.unitPrice;
      toatalQuantityValue += curentCartItem.quantity;
    }
    this.totalPrice.next(totalPriceValue);
    this.totalQuantity.next(toatalQuantityValue);

    for (let temp of this.cartItem){
      console.log(temp)
    }

  }
}
