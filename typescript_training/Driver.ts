import { Customer } from "./customer";

 let customer = new Customer("nilusha ","Dissanayaka");

 console.log(customer.firstname);
 console.log(customer.lastName);
 
 

export class Driver{
    private firstName: string;
    private lastName: string;
    private _address: string;

    public get address(): string {
        return this._address;
    }
    public set address(value: string) {
        this._address = value;
    }

    constructor(firstName: string, lastName: string,address: string){
        this.firstName = firstName;
        this.lastName = lastName;
        this._address = address;

    }
    // setters
    public set setFirstName(setFirstName: string){
        this.firstName = setFirstName;
    }
    public set setLastName(setLastName:string){
        this.lastName = setLastName;
    }
    //getters
    public get getFirstName():string  {
        return this.firstName;
    }
    public get getLastName():string{
        return this.lastName
    }

}





