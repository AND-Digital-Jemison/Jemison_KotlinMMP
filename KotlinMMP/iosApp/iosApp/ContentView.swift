import SwiftUI
import shared

struct ContentView: View {
    @State private var selectedTab = "great"

	var body: some View {
        Text("How are you doing today?")
            .font(.largeTitle)
            .multilineTextAlignment(.center)
            .padding(.top, 100)
            .lineSpacing(10)
        Text("(Swipe to change mood)")
            .multilineTextAlignment(.center)
       
        TabView(selection: $selectedTab) {
                Text("Doing Great!")
                    .foregroundColor(.green)
                    .bold()
                    .tag("great")

                Text("Not so great")
                    .foregroundColor(.red)
                    .bold()
                    .tag("not great")


        }
        .padding(.top,-100)
        .tabViewStyle( PageTabViewStyle())

        Text("This is anonymous")
            .multilineTextAlignment(.center)

        Button("Submit") {
            print("Button tapped! Response selected: ", selectedTab)
        }
            .padding()
            .background(Color.black)
            .foregroundColor(.white)
            .cornerRadius(20)
	}
        
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}


