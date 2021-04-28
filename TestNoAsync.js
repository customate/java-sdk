const playwright = require('playwright');
console.log('No async JS here');
const browser = await playwright['chromium'].launch();