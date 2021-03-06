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

        let greatImage = app.images["mood0-image"]
        let greatText = app.staticTexts["mood0-text"]
        XCTAssert(greatText.exists)
        XCTAssert(greatImage.exists)
        
        greatImage.swipeLeft()
        let notGreatImage = app.images["mood1-image"]
        let notGreatText = app.staticTexts["mood1-text"]
        XCTAssert(notGreatText.exists)
        XCTAssert(notGreatImage.exists)

        notGreatImage.swipeRight()
        XCTAssert(greatImage.exists)
        XCTAssert(greatText.exists)
    }
    
    func testMoodSubmitToastPopup() throws {
        app.launch()
        
        let greatImage = app.images["mood0-image"]
        let submitButton = app.buttons["SUBMIT"]
        let moodSubmittedText = app.staticTexts["Mood submitted!"]

        submitButton.tap()
        XCTAssert(moodSubmittedText.exists)

        greatImage.swipeLeft()
        submitButton.tap()
        XCTAssert(moodSubmittedText.exists)
        
    }

}
