import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup} from "@angular/forms";
import {Love2ShopFormService} from "../../services/love2-shop-form.service";
import {mergeWith} from "rxjs";

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
  constructor(
    private formBuilder: FormBuilder,
    private love2ShopFormService:Love2ShopFormService
  ) {
  }

  ngOnInit(): void {
    this.checkoutGroup = this.formBuilder.group({
      customer: this.formBuilder.group({
        firstName: [''],
        lastName: [''],
        email: ['']
      }),
      shippingAddress: this.formBuilder.group({
        street: [''],
        city: [''],
        state: [''],
        country: [''],
        zipCode: [''],
      }),
      billingAddress: this.formBuilder.group({
        street: [''],
        city: [''],
        state: [''],
        country: [''],
        zipCode: [''],
      }),
      creditCard: this.formBuilder.group({
        cardType: [''],
        nameOnCard: [''],
        cardNumber: [''],
        securityCode: [''],
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

  }
  onsubmit() {
    console.log(this.checkoutGroup.get('customer')?.value)
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
}
