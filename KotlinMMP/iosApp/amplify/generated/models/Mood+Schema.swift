// swiftlint:disable all
import Amplify
import Foundation

extension Mood {
  // MARK: - CodingKeys 
   public enum CodingKeys: String, ModelKey {
    case id
    case text
    case createdAt
    case updatedAt
  }
  
  public static let keys = CodingKeys.self
  //  MARK: - ModelSchema 
  
  public static let schema = defineSchema { model in
    let mood = Mood.keys
    
    model.authRules = [
      rule(allow: .public, operations: [.create, .update, .delete, .read])
    ]
    
    model.pluralName = "Moods"
    
    model.fields(
      .id(),
      .field(mood.text, is: .optional, ofType: .string),
      .field(mood.createdAt, is: .optional, isReadOnly: true, ofType: .dateTime),
      .field(mood.updatedAt, is: .optional, isReadOnly: true, ofType: .dateTime)
    )
    }
}