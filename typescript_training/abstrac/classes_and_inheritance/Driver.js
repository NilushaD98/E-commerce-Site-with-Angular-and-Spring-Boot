"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var Shapes_1 = require("./Shapes");
var Circle_1 = require("./Circle");
var myshape = new Shapes_1.shape(10, 12);
console.log(myshape.getinfo());
var mycycle = new Circle_1.Circle(5, 45, 45);
console.log(mycycle.getInfo());
