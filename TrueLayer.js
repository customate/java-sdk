// This script tests confirming an open banking payment.
// It uses TrueLayer's and NatWest's sandbox and expects a (pending) payment to have been created beforehand.
// Create an open banking payment, setting the redirect_url to "https://gocustomate.com/".
// Call this script with the uri in double quotes and either confirm or cancel as the third argument,
// i.e.   node .\TrueLayer.js confirm "<URI>"   or   node .\TrueLayer.js cancel "<URI>"

const playwright = require('playwright');
const uri = process.argv.slice(3)[0];
console.log("uri: " + uri);

(async () => {
  try {
    for (const browserType of ['chromium']) {
      // Start the browser
      const browser = await playwright[browserType].launch();
      //const browser = await playwright[browserType].launch({headless: false}); // Un-comment to see the browser
      const context = await browser.newContext();

      // Go to Natwest's sandbox page using the URI supplied as an argument
      const page = await context.newPage();
      await page.goto(uri);

      // Enter the customer number and continue
      await page.waitForSelector('#customer-number');
      await page.fill('#customer-number', '123456789012');
      await page.waitForSelector('.panel-group #customer-number-login');
      await page.$eval('#customer-number-login', e => e.removeAttribute('disabled'));
      await page.click('.panel-group #customer-number-login');

      // Enter the PIN and password and log in
      await page.waitForSelector('#pin-1');
      await page.fill('#pin-1', '5');
      await page.fill('#pin-2', '7');
      await page.fill('#pin-3', '2');
      await page.fill('#password-1', '4');
      await page.fill('#password-2', '3');
      await page.fill('#password-3', '6');
      await page.$eval('button#login-button.primary', e => e.removeAttribute('disabled'));
      await page.focus('#pin-1'); // Changing focus is required to enable the button
      await page.click('button#login-button.primary');

      // Select an account
      await page.waitForSelector('#account-list > .row-element:nth-child(1) > dl > .action > button');
      await page.click('#account-list > .row-element:nth-child(1) > dl > .action > button');

      // Click the confirm or cancel payment button
      await page.waitForSelector('#app #approveButton');
      if (process.argv.slice(2)[0] === 'confirm') {
        await page.click('#app #approveButton');
        await page.screenshot({ path: `payment-confirmed.png` });
      } else {
        await page.click('#app #declineButton');
        await page.screenshot({ path: `payment-cancelled.png` });
      }

      // Check the redirect to Customate's homepage
      await page.waitForSelector('#logo');
      await page.screenshot({ path: `redirect.png` });

      // Close the browser
      await browser.close();
    }
  } catch(e) {
    console.log('Caught an error: ', e)
  }
})();