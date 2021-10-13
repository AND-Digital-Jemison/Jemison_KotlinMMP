import SwiftUI
import shared

struct ContentView: View {
    @State private var selectedTab = "great"

	var body: some View {
        ZStack() {
            Image("background-purple")
                .resizable()
                .scaledToFill()
                .edgesIgnoringSafeArea(.all)
            VStack{
                Text("How are you doing today?")
                    .font(Font.custom("Poppins-Bold", size: 30))
                    .multilineTextAlignment(.center)
                    .padding(.top, 100)
                    .foregroundColor(.white)
                
                TabView(selection: $selectedTab) {
                    VStack{
                        Image("rocket-up")
                            .resizable()
                            .scaledToFit()
                        Text("Doing Great")
                            .foregroundColor(.white)
                            .font(Font.custom("Tahu!", size: 40))
                    }.tag("great")
                    
                    VStack{
                        Image("rocket-down")
                            .resizable()
                            .scaledToFit()
                        Text("Not so great")
                            .foregroundColor(.white)
                            .font(Font.custom("Tahu!", size: 40))
                            
                    }.tag("not great")
                }
                .padding(.top,-100)
                .tabViewStyle( PageTabViewStyle())

                Button("SUBMIT") {
                    print("Button tapped! Response selected: ", selectedTab)
                }.buttonStyle(PrimaryButton())
                 
                Text("This is anonymous")
                    .padding()
                    .multilineTextAlignment(.center)
                    .foregroundColor(.white)
                    .font(Font.custom("Poppins-ExtraLight", size: 16))
                    
            
                   
            } .padding([.bottom, .leading, .trailing], 20)
        }

	}
        
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}


