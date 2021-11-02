// swiftlint:disable all
import Amplify
import Foundation

public struct Mood: Model {
  public let id: String
  public var text: String?
  public var createdAt: Temporal.DateTime?
  public var updatedAt: Temporal.DateTime?
  
  public init(id: String = UUID().uuidString,
      text: String? = nil) {
    self.init(id: id,
      text: text,
      createdAt: nil,
      updatedAt: nil)
  }
  internal init(id: String = UUID().uuidString,
      text: String? = nil,
      createdAt: Temporal.DateTime? = nil,
      updatedAt: Temporal.DateTime? = nil) {
      self.id = id
      self.text = text
      self.createdAt = createdAt
      self.updatedAt = updatedAt
  }
}