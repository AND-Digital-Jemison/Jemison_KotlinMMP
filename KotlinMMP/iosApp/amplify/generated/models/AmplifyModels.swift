// swiftlint:disable all
import Amplify
import Foundation

// Contains the set of classes that conforms to the `Model` protocol. 

final public class AmplifyModels: AmplifyModelRegistration {
  public let version: String = "05216a74bfbe320620be35a2560499cd"
  
  public func registerModels(registry: ModelRegistry.Type) {
    ModelRegistry.register(modelType: Mood.self)
  }
}