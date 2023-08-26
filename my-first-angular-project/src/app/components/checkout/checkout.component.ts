import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Love2ShopFormService} from "../../services/love2-shop-form.service";
import {mergeWith} from "rxjs";
import {Country} from "../../common/country";
import {State} from "../../common/state";
import {StandardResponse} from "../../common/StandardResponse";
import {Luv2shopValidators} from "../../validators/luv2shop-validators";
import {CartService} from "../../services/cart.service";
import {Order} from "../../common/order";
import {OrderItem} from "../../common/order-item";
import {Address} from "../../common/address";
import {Customer} from "../../common/customer";
import {CheckoutService} from "../../services/checkout.service";

@Component({
  selector: 'app-checkout',
  templateUrl: './checkout.component.html',
  styleUrls: ['./checkout.component.css']
})
export class CheckoutComponent implements OnInit {


  checkoutGroup: FormGroup = new FormGroup({});
  totalPrice: number =0;
  totalQuantity: number =0;
  creditCardYears: number[] = [];
  creditCardMonths: number[] =[];
  countries: Country[] = [];
  states: State[] =[];
  constructor(
    private formBuilder: FormBuilder,
    private love2ShopFormService:Love2ShopFormService,
    private cartService: CartService,
    private checkOutService:CheckoutService
  ) {
  }

  ngOnInit(): void {
    this.reviewCartDetails();
    this.checkoutGroup = this.formBuilder.group({
      customer: this.formBuilder.group({
        firstName: ['', [Validators.required, Validators.minLength(2),Luv2shopValidators.notOnlyWhiteSpace]],
        lastName: ['',[Validators.required,Validators.minLength(2),Luv2shopValidators.notOnlyWhiteSpace]],
        email: ['',
            [Validators.required,Validators.pattern('^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$'),Luv2shopValidators.notOnlyWhiteSpace]
          ]
      }),
      shippingAddress: this.formBuilder.group({
        street:['', [Validators.required,Luv2shopValidators.notOnlyWhiteSpace]],
        city: ['', [Validators.required,Luv2shopValidators.notOnlyWhiteSpace]],
        state: [''],
        country: [''],
        zipCode: ['', [Validators.required,Validators.pattern('^[0-9]*$'),Luv2shopValidators.notOnlyWhiteSpace]],
      }),
      billingAddress: this.formBuilder.group({
        street:['', [Validators.required,Luv2shopValidators.notOnlyWhiteSpace]],
        city: ['', [Validators.required,Luv2shopValidators.notOnlyWhiteSpace]],
        state: [''],
        country: [''],
        zipCode: ['', [Validators.required,Validators.pattern('^[0-9]*$'),Luv2shopValidators.notOnlyWhiteSpace]],
      }),
      creditCard: this.formBuilder.group({
        cardType: [''],
        nameOnCard: ['', [Validators.required,Luv2shopValidators.notOnlyWhiteSpace]],
        cardNumber: ['', [Validators.required,Validators.minLength(16),Luv2shopValidators.notOnlyWhiteSpace]],
        securityCode:['', [Validators.required,Validators.minLength(3),Validators.maxLength(3),Luv2shopValidators.notOnlyWhiteSpace]],
        expirationMonth: [''],
        expirationYear: [''],
      })
    });

    const startMonth:number = new Date().getMonth() +1;
    console.log(startMonth);
    this.love2ShopFormService.getCreditCardMonth(startMonth).subscribe(
      data =>{
        console.log(data);
        JSON.stringify(data);
        this.creditCardMonths = data;
      }
    )
    this.love2ShopFormService.getCrediCardyears().subscribe(
      data=>{
        this.creditCardYears = data;
      }
    )
    this.love2ShopFormService.getAllCountries().subscribe(
      (response:StandardResponse)=>{
        if(response.code ===200){
          this.countries = response.data as Country[];
        }
      }
    );
  }
  onsubmit() {
    if(this.checkoutGroup.invalid){
      this.checkoutGroup.markAllAsTouched();
    }
    const cartItems = this.cartService.cartItem;
    let orderItems: OrderItem[] = [];
    for (let i = 0; i < cartItems.length; i++) {
      const cartItem = cartItems[i];
      const orderItem: OrderItem = new OrderItem(
        cartItem.id,
        cartItem.imageURL,
        cartItem.unitPrice,
        cartItem.quantity
      );
      orderItems.push(orderItem);
    }
    const customer = this.checkoutGroup.get('customer') as FormGroup;
    const customer1 = new Customer(
      customer.value.firstName,
      customer.value.lastName,
      customer.value.email
    );
    const shipping_address = this.checkoutGroup.get('shippingAddress') as FormGroup;
    const ship_address = new Address(
      shipping_address.value.street,
      shipping_address.value.city,
      shipping_address.value.state.name,
      shipping_address.value.country.name,
      shipping_address.value.zipCode
    );
    const billing_address = this.checkoutGroup.get('billingAddress')as FormGroup;
    const bill_address = new Address(
      billing_address.value.street,
      billing_address.value.city,
      billing_address.value.state.name,
      billing_address.value.country.name,
      billing_address.value.zipCode
    );

    const order = new Order(
      this.totalQuantity,
      this.totalPrice,
      customer1,
      ship_address,
      bill_address,
      orderItems
    );
    this.checkOutService.placeOrder(order).subscribe(
      (response:StandardResponse)=>{
        if(response.code === 200){
          console.log(response.data);
        }
      }
    );

  }
  copyShippingAddressToBillingAddress($event: Event) {
    if ($event.target instanceof HTMLInputElement) {
      if ($event.target.checked) {
        const shippingAddress = this.checkoutGroup.get('shippingAddress') as FormGroup;
        const billingAddress = this.checkoutGroup.get('billingAddress') as FormGroup;
        billingAddress.patchValue(shippingAddress.value);

      } else {
        const billingAddress = this.checkoutGroup.get('billingAddress') as FormGroup;
        billingAddress.reset();
      }
    }
  }
  handleMonthsAndYears() {
   const  creditCardFromGroup = this.checkoutGroup.get('creditCard');
   const  currentYear:number = new Date().getFullYear();
   const selectedYear: number = Number(creditCardFromGroup?.value.expirationYear);

   let startMonth:number;
   if(currentYear === selectedYear){
     startMonth = new Date().getMonth() +1;
   }
   else {
     startMonth = 1;
   }
   this.love2ShopFormService.getCreditCardMonth(startMonth).subscribe(
     data =>{
       this.creditCardMonths =data;
     }
   );
  }
  getStates(formGroupName: string) {
    console.log(formGroupName);
    const formGroup = this.checkoutGroup.get('shippingAddress') as FormGroup;
    const countryCode = formGroup.value.country.code;
    this.love2ShopFormService.getStatesByCode(countryCode).subscribe(
      (response: StandardResponse)=>{
        if(response.code === 200){
          this.states = response.data as State[];
        }
      }
    );
  }
  protected readonly State = State;

  private reviewCartDetails() {
    this.cartService.totalQuantity.subscribe(
      totalQuantity => this.totalQuantity = totalQuantity
    );
    this.cartService.totalPrice.subscribe(
      totalPrice => this.totalPrice = totalPrice
    );
  }
}
