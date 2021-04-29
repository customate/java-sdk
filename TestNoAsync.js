const uri = process.argv.slice(3)[0];
console.log('uri passed to JS file: ' + uri);
const fs = require('fs');
fs.writeFile('Output.txt', 'Success')