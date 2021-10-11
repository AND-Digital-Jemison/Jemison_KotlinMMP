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
        
        let doingGreat = app.staticTexts["Doing Great!"]
        XCTAssert(doingGreat.exists)
        
        app.swipeLeft()
        
        let notSoGreat = app.staticTexts["Not so great"]
        XCTAssert(notSoGreat.exists)
        XCTAssert(!doingGreat.exists)
        
        app.swipeRight()
        
        XCTAssert(doingGreat.exists)
        XCTAssert(!notSoGreat.exists)
    }
}
