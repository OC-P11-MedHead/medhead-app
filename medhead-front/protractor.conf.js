exports.config = {
    seleniumAddress: 'http://localhost:4444/wd/hub',
    capabilities: {
        browserName: 'chrome', // Vous pouvez également utiliser 'firefox', 'safari', etc.
        // 'moz:firefoxOptions': {
        //     args : ["--headless"]
        // }
        chromeOptions: {
            args: ['--headless', '--disable-gpu', '--window-size=1920x1080'],
        },
    },
    specs: ['./e2e/*.js'],
      // Adresse de votre application Angular en cours d'exécution
}