import SwiftUI
//import AppCenter
//import AppCenterAnalytics
//import AppCenterCrashes

@main
struct iOSApp: App {
    init() {
//        AppCenter.start(withAppSecret: "388e8513-eaaf-4c7d-8bca-dfcddcc20128", services: [Analytics.self, Crashes.self])
    }
    
    @UIApplicationDelegateAdaptor(AppDelegate.self) var appDelegate
    
	var body: some Scene {
		WindowGroup {
			ContentView()
		}
	}
}
