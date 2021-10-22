// swiftlint:disable all
import Amplify
import Foundation

extension Mood {
  // MARK: - CodingKeys 
   public enum CodingKeys: String, ModelKey {
    case id
    case text
  }
  
  public static let keys = CodingKeys.self
  //  MARK: - ModelSchema 
  
  public static let schema = defineSchema { model in
    let mood = Mood.keys
    
    model.pluralName = "Moods"
    
    model.fields(
      .id(),
      .field(mood.text, is: .required, ofType: .string)
    )
    }
}