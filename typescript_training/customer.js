var Customer = /** @class */ (function () {
    function Customer(firstName, lastName) {
        this.firstname = firstName;
        this.lastName = lastName;
    }
    return Customer;
}());
var myCustomer1 = new Customer("Nilusha ", "Dissanayaka");
console.log(myCustomer1.firstname);
console.log(myCustomer1.lastName);
// or can we use this type
var Customer2 = /** @class */ (function () {
    function Customer2() {
    }
    return Customer2;
}());
var myCustomer2 = new Customer2();
myCustomer2.firstname = "Pathum";
myCustomer2.lastName = "Dissanayaka";
console.log(myCustomer2.firstname);
console.log(myCustomer2.lastName);
// use tsc --noEmitOnError customer.ts for not generate 
