// swiftlint:disable all
import Amplify
import Foundation

// Contains the set of classes that conforms to the `Model` protocol. 

final public class AmplifyModels: AmplifyModelRegistration {
  public let version: String = "9b63692d9fb44e62575f5586c0401f63"
  
  public func registerModels(registry: ModelRegistry.Type) {
    ModelRegistry.register(modelType: Mood.self)
  }
}