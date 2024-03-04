const {Builder, By, Hey, until} = require("selenium-webdriver");
 
async function testBookBed() {
    let driver = await new Builder().forBrowser('chrome').build()

    try {
        await driver.get('http://localhost:4200/')
        await driver.findElement(By.id('modal')).click()
        // await driver.wait(until.titleIs('MedheadFront'), 3000)
        await driver.sleep(500)
        await driver.findElement(By.id('select-hospital')).click()
        
        await driver.sleep(500)
        await driver.findElement(By.xpath("//span[contains(text(),'The Mall, London SW1A 2WH, Royaume-Uni')]")).click()
        await driver.sleep(500)

        await driver.findElement(By.id('select-speciality')).click()
        await driver.sleep(500)
        await driver.findElement(By.xpath("//span[contains(text(),'Cardiologie')]")).click()
        await driver.sleep(500)
        console.log("Tests e2e : success")
    } catch {
        console.log("Tests e2e : error")
    } finally {
        await driver.quit()
    }
}
testBookBed()