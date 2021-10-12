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
    
    func testSwipeRightToLeft() throws {
           app.launch()
           app.swipeLeft()
           
           let question = app.staticTexts["How are you doing today?"]
           let answer = app.staticTexts["Not so great"]
           let button = app.buttons.element
           XCTAssert(question.exists)
           XCTAssert(answer.exists)
           XCTAssert(button.exists)
       }
       
       func testSwipeLeftToRight() throws {
           app.launch()
           app.swipeLeft()
           app.swipeRight()
           
           let question = app.staticTexts["How are you doing today?"]
           let answer = app.staticTexts["Doing Great!"]
           let button = app.buttons.element
           XCTAssert(question.exists)
           XCTAssert(answer.exists)
           XCTAssert(button.exists)
       }
}
