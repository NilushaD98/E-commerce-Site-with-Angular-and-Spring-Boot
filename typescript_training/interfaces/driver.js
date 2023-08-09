"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var cricketCoach_1 = require("./cricketCoach");
var golfcoach_1 = require("./golfcoach");
var myccoach = new cricketCoach_1.cricketcoach();
var mygolfcoach = new golfcoach_1.golfcoach();
var theCoaches = [];
theCoaches.push(myccoach);
theCoaches.push(mygolfcoach);
for (var _i = 0, theCoaches_1 = theCoaches; _i < theCoaches_1.length; _i++) {
    var theCoache = theCoaches_1[_i];
    console.log(theCoache.getDailyWorkout());
}
