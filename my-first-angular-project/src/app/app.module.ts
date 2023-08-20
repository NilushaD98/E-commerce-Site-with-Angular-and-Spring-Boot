import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { SalesPersonListComponent } from './sales-person-list/sales-person-list.component';
import { ProductListComponent } from './components/product-list/product-list.component';
import {HttpClientModule} from '@angular/common/http';
import { Routes,RouterModule } from '@angular/router';
import { ProductCategoryMenuComponent } from './components/product-category-menu/product-category-menu.component';
import { SearchComponent } from './components/search/search.component';
import { ProductDetailsComponent } from './components/product-details/product-details.component';
import {NgOptimizedImage} from "@angular/common";
import {NgbModule} from "@ng-bootstrap/ng-bootstrap";
import { CartStatusComponent } from './components/cart-status/cart-status.component';
import { CartDetailsComponent } from './components/cart-details/cart-details.component';
import { CheckoutComponent } from './components/checkout/checkout.component';
import {ReactiveFormsModule} from "@angular/forms";

const routes: Routes = [
  {path:'checkout',component:CheckoutComponent},
  {path: 'cart-details',component:CartDetailsComponent},
  {path: 'products/:id',component:ProductDetailsComponent},
  {path: 'search/:keyword',component:ProductListComponent},
  {path: 'category/:id',component:ProductListComponent},
  {path: 'category',component:ProductListComponent},
  {path: 'products',component:ProductListComponent},
  {path: '',redirectTo:'/products',pathMatch:'full'},
  {path: '**',redirectTo:'/products',pathMatch:'full'},
];

@NgModule({
  declarations: [
    AppComponent,
    SalesPersonListComponent,
    ProductListComponent,
    ProductCategoryMenuComponent,
    SearchComponent,
    ProductDetailsComponent,
    CartStatusComponent,
    CartDetailsComponent,
    CheckoutComponent
  ],
  imports: [
    RouterModule.forRoot(routes),
    BrowserModule,
    HttpClientModule,
    NgOptimizedImage,
    NgbModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
