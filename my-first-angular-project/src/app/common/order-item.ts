import {Product} from "./product";

export class OrderItem {
  constructor(
    public id:number,
    public imageURL:string,
    public unitPrice:number,
    public quantity:number
  ) {
  }
}
