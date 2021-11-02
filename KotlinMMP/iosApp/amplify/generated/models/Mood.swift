// swiftlint:disable all
import Amplify
import Foundation

public struct Mood: Model {
  public let id: String
  public var text: String?
  
  public init(id: String = UUID().uuidString,
      text: String? = nil) {
      self.id = id
      self.text = text
  }
}