import {Product} from "./product";

export class CartItem {
  id:number;
  name:string;
  imageURL:string;
  unitPrice: number;
  quantity: number;

  constructor(product: Product) {
    this.id = product.productID;
    this.name = product.name;
    this.imageURL = product.imageURL;
    this.unitPrice = product.unitPrice;
    this.quantity = 1
  }
}
