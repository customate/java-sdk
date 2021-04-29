const uri = process.argv.slice(3)[0];
console.log('uri passed to JS file: ' + uri);
const fs = require('fs');
fs.writeFile('Output.txt', 'Success', (err) => {
    // In case of a error throw err.
    if (err) throw err;
})