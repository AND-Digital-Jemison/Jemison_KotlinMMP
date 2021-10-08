import XCTest

class iosAppUITests: XCTestCase {
    var app: XCUIApplication!
    
    override func setUpWithError() throws {
        // Put setup code here. This method is called before the invocation of each test method in the class.

        continueAfterFailure = false

        // In UI tests it’s important to set the initial state - such as interface orientation - required for your tests before they run. The setUp method is a good place to do this.
        app = XCUIApplication()
    }

    override func tearDownWithError() throws {
        // Put teardown code here. This method is called after the invocation of each test method in the class.
    }

    func testLaunchPageInformation() throws {
        // UI tests must launch the application that they test.
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
        sleep(10)
        
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
        
        sleep(10)
        let question = app.staticTexts["How are you doing today?"]
        let answer = app.staticTexts["Doing Great!"]
        let button = app.buttons.element
        XCTAssert(question.exists)
        XCTAssert(answer.exists)
        XCTAssert(button.exists)
    }
}
