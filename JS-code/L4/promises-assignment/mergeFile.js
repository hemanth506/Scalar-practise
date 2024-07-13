const fs = require("fs");
const fileName = ['/1.txt', '/2.txt', '/3.txt'];
const allNumbers = [];

fileName.forEach( async (directory) => {
    await fs.readFile(__dirname + directory, (err, data) => {
        if(err) throw err;
        console.log(data.toString());
    })
});


// let value = true;
// let i = 0;
// while (value) {
//     fs.readFile(__dirname + fileName[i], (err, data) => {
//         if(err) throw err;
//         console.log(data.toString());
//     })
//     i++;
//     if (i == 3) {
//         value = false;
//     }
// }

console.log("Hello")