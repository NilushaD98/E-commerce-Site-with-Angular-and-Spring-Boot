import { coach } from "./coach";
import { cricketcoach } from "./cricketCoach";
import { golfcoach } from "./golfcoach";

let myccoach = new cricketcoach();
let mygolfcoach = new golfcoach();

let theCoaches: coach[] = [];

theCoaches.push(myccoach);
theCoaches.push(mygolfcoach);

for (let  theCoache of theCoaches) {
     
    console.log(theCoache.getDailyWorkout());
    
}