export class Customer{

    firstname: string;
    lastName: string;

    constructor(firstName: string , lastName: string){
        this.firstname = firstName;
        this.lastName = lastName;
    }
}

let myCustomer1 = new Customer("Nilusha ","Dissanayaka");
console.log(myCustomer1.firstname);
console.log(myCustomer1.lastName);


// or can we use this type
class Customer2{
    firstname: string;
    lastName: string;

}

let myCustomer2 = new Customer2();
myCustomer2.firstname = "Pathum";
myCustomer2.lastName = "Dissanayaka";

console.log(myCustomer2.firstname);
console.log(myCustomer2.lastName);

// use tsc --noEmitOnError customer.ts for not generate 



