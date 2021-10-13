import XCTest
@testable import iosApp
import SwiftUI

class ColorTests: XCTestCase {

    func testColors() throws {
        XCTAssert(Color(hex: "#FFFFFF") == Color(red: 1.0, green: 1.0, blue: 1.0, opacity: 1.0))
        XCTAssert(Color(hex: "#FF0000") == Color(red: 1.0, green: 0.0, blue: 0.0, opacity: 1.0))
        XCTAssert(Color(hex: "#00FF00") == Color(red: 0.0, green: 1.0, blue: 0.0, opacity: 1.0))
        XCTAssert(Color(hex: "#0000FF") == Color(red: 0.0, green: 0.0, blue: 1.0, opacity: 1.0))
    }

}
