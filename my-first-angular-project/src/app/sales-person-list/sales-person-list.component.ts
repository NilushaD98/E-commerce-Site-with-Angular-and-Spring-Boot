import { Component, OnInit } from '@angular/core';
import { SalesPerson } from './sales-person';

@Component({
  selector: 'app-sales-person-list',
  templateUrl: './sales-person-list-bootstrap.component.html',
  styleUrls: ['./sales-person-list.component.css']
})
export class SalesPersonListComponent implements OnInit {

  // create an array of objects
  salesPersonList: SalesPerson [] = [
    new SalesPerson("Nilusha","Dissanayaka","nilusha@gmail.com",200000),
    new SalesPerson("prabodha","Dissanayaka","prabodha@gmail.com",45000),
    new SalesPerson("Siripala","Dissanayaka","siripala@gmail.com",45873),
    new SalesPerson("Ghanawathi","Rathnayaka","ghanawathi@gmail.com",4567876)
  ];
  constructor() { }

  ngOnInit(): void {
  }

}
