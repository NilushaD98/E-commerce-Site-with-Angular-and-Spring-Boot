var sports = ["cricket", "Football", "vollyball", "rugby"];
for (var i = void 0; i < sports.length; i++) {
    console.log(sports[i]);
}
//alternative for loops for print each elemants
for (var _i = 0, sports_1 = sports; _i < sports_1.length; _i++) {
    var totalsports = sports_1[_i];
    console.log(totalsports);
}
// add elemats to the array
sports.push("hockey");
sports.push("Darts");
for (var _a = 0, sports_2 = sports; _a < sports_2.length; _a++) {
    var totalsports = sports_2[_a];
    console.log(totalsports);
}
