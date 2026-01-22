console.log("START");
async function task (){
    console.log("1");
    Promise.resolve("ok").then((d)=>console.log(d));
    console.log("2");
}
task();
console.log("end");