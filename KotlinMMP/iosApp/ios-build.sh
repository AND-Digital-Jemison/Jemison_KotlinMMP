pod --version
pod install
gradle -v
xcodebuild -workspace iosApp.xcworkspace -scheme iosApp -destination 'platform=iOS Simulator,OS=15.0,name=iPhone 13' clean build test CODE_SIGN_IDENTITY="" CODE_SIGNING_REQUIRED=NO
