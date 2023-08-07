"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.Driver = void 0;
var Driver = /** @class */ (function () {
    function Driver() {
    }
    Object.defineProperty(Driver.prototype, "address", {
        get: function () {
            return this._address;
        },
        set: function (value) {
            this._address = value;
        },
        enumerable: false,
        configurable: true
    });
    Object.defineProperty(Driver.prototype, "setFirstName", {
        // constructor(firstName: string, lastName: string,address: string){
        //     this.firstName = firstName;
        //     this.lastName = lastName;
        //     this._address = address;
        // }
        // setters
        set: function (setFirstName) {
            this.firstName = setFirstName;
        },
        enumerable: false,
        configurable: true
    });
    Object.defineProperty(Driver.prototype, "setLastName", {
        set: function (setLastName) {
            this.lastName = setLastName;
        },
        enumerable: false,
        configurable: true
    });
    Object.defineProperty(Driver.prototype, "getFirstName", {
        //getters
        get: function () {
            return this.firstName;
        },
        enumerable: false,
        configurable: true
    });
    Object.defineProperty(Driver.prototype, "getLastName", {
        get: function () {
            return this.lastName;
        },
        enumerable: false,
        configurable: true
    });
    return Driver;
}());
exports.Driver = Driver;
var myDriver = new Driver();
myDriver.setFirstName = "Nilusha";
myDriver.setLastName = "Dissanayaka";
console.log(myDriver.getFirstName);
console.log(myDriver.getLastName);
