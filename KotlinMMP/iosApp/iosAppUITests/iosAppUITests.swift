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
        let answer = app.staticTexts["Doing Great!"]
        let button = app.buttons.element
        XCTAssert(question.exists)
        XCTAssert(answer.exists)
        XCTAssert(button.exists)
    }
    
    func testSwipe() throws {
           app.launch()
        
           let greatText = app.staticTexts["Doing Great!"]
           XCTAssert(greatText.exists)
        
           greatText.swipeLeft()
           let notGreatText = app.staticTexts["Not So Great!"]
           XCTAssert(notGreatText.exists)
        
           notGreatText.swipeRight()
           XCTAssert(greatText.exists)
       }

}
