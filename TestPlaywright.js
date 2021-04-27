const playwright = require('playwright');

(async () => {
  for (const browserType of ['chromium']) {
    const browser = await playwright[browserType].launch();
    //const browser = await playwright[browserType].launch({headless: false, slowMo: 50, dumpio: true});
    const context = await browser.newContext();
    const page = await context.newPage();
    await page.goto('http://whatsmyuseragent.org/');
    await page.screenshot({ path: `example-${browserType}.png` });
    await browser.close();
  }
})();