// swiftlint:disable all
import Amplify
import Foundation

// Contains the set of classes that conforms to the `Model` protocol. 

final public class AmplifyModels: AmplifyModelRegistration {
  public let version: String = "d0406fa63da075a4e653cc27952c2717"
  
  public func registerModels(registry: ModelRegistry.Type) {
    ModelRegistry.register(modelType: Mood.self)
  }
}