let sports: string[] = ["cricket","Football","vollyball","rugby"];

for(let i ; i<sports.length;i++){
    console.log(sports[i]);
}
//alternative for loops for print each elemants
for(let totalsports of sports){
    console.log(totalsports);
}

// add elemats to the array
sports.push("hockey");
sports.push("Darts");

for(let totalsports of sports){
    console.log(totalsports);
    
}