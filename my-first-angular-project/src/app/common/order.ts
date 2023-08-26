import {Customer} from "./customer";
import {Address} from "./address";
import {OrderItem} from "./order-item";

export class Order {

  constructor(
    public totalQuantity:number,
    public totalPrice:number,
    public customer:Customer,
    public shipping_address:Address,
    public billing_address:Address,
    public orderItemSaveDTOList: OrderItem []
  ) {
  }
}
