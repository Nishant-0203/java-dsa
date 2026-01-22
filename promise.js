function sum(a,b){
    return new Promise((resolve,reject)=>{
        resolve(a+b);
    });
}
function sub(a,b){
    return new Promise((resolve,reject)=>{
        resolve(a-b);
    });
}

sum(7,8).then((result)=>{
    return sub(result,3);
}).then((finalResult)=>{
    console.log(finalResult);
});