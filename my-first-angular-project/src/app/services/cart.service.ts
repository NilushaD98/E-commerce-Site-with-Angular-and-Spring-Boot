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

   computeCartTotal() {
    let totalPriceValue : number = 0;
    let totalQuantityValue: number = 0;

    for(let currentCartItem of this.cartItem){
      totalPriceValue += currentCartItem.quantity * currentCartItem.unitPrice;
      totalQuantityValue += currentCartItem.quantity;
    }
    this.totalPrice.next(totalPriceValue);
    this.totalQuantity.next(totalQuantityValue);

  }
  decrementQuantity(tempCartItem: CartItem) {
    tempCartItem.quantity --;
    if(tempCartItem.quantity ==0){
      this.remove(tempCartItem);
    }else{
      this.computeCartTotal();
    }
  }

  remove(tempCartItem: CartItem) {
    const itemIndex = this.cartItem.findIndex(temp => temp.id === tempCartItem.id);
    if(itemIndex> -1){
      this.cartItem.splice(itemIndex,1);
      this.computeCartTotal();
    }
  }
}
