import XCTest

class iosAppUITests: XCTestCase {
    var app: XCUIApplication!
    
    override func setUpWithError() throws {
        continueAfterFailure = false
        app = XCUIApplication()
    }

    func testLaunchPageInformation() throws {
        app.launch()
        let question = app.staticTexts["How are you doing today?"]
        let answer = app.staticTexts["Doing Great"]
        let button = app.buttons.element
        XCTAssert(question.exists)
        XCTAssert(answer.exists)
        XCTAssert(button.exists)
    }
    
    func testSwipe() throws {
        app.launch()
        
        let greatImage = app.images.element(matching: .image, identifier: "rocket-up")
        let greatText = app.staticTexts["Doing Great"]
        XCTAssert(greatText.exists)
        XCTAssert(greatImage.exists)

        greatImage.swipeLeft()
        
//        let notGreatImage = app.images.element(matching: .image, identifier: "rocket-down")
//        let notGreatText = app.staticTexts["Not So Great"]
//        XCTAssert(notGreatText.exists)
//        XCTAssert(notGreatImage.exists)
//
//        notGreatImage.swipeRight()
//        XCTAssert(greatImage.exists)
//        XCTAssert(greatText.exists)
       }

}
