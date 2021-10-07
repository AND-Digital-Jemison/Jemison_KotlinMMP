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
       
        ZStack{
            TabView(selection: $selectedTab) {
                    Text("I'm Great!")
                        .foregroundColor(.green)
                        .bold()
                        .tag("great")

                    Text("I'm not Well")
                        .foregroundColor(.red)
                        .bold()
                        .tag("not well")
                      
            
                 }
            .padding(.top,-100)
            .tabViewStyle( PageTabViewStyle())
         
        }
     
        Button("Submit") {
            print("Button tapped!", selectedTab)
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


