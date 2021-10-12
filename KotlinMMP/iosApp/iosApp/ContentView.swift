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
                    .font(.largeTitle)
                    .multilineTextAlignment(.center)
                    .padding(.top, 100)
                    .foregroundColor(.white)
                
                Text("(Swipe to change mood)")
                    .multilineTextAlignment(.center)
                    .foregroundColor(.white)
                
                TabView(selection: $selectedTab) {
                    VStack{
                        Image("rocket")
                            .resizable()
                            .scaledToFit()
                        Text("Doing Great")
                            .foregroundColor(.white)
                            .font(.largeTitle)
                    }.tag("great")
                    
                    VStack{
                        Image("rocket")
                            .resizable()
                            .scaledToFit()
                            .rotationEffect(.degrees(180))
                        Text("Not so great")
                            .foregroundColor(.white)
                            .font(.largeTitle)
                            
                    }.tag("not great")
                }
                .padding(.top,-100)
                .tabViewStyle( PageTabViewStyle())

                Button("SUBMIT") {
                    print("Button tapped! Response selected: ", selectedTab)
                }.buttonStyle(PrimaryButton())
//                }.padding()
//                 .frame(minWidth: 0, maxWidth: .infinity)
//                 .background(Color.gray.opacity(0.3))
//                 .border(Color.white)
//                 .cornerRadius(10)
//                 .foregroundColor(.white)
                 
                Text("This is anonymous")
                    .padding()
                    .multilineTextAlignment(.center)
                    .foregroundColor(.white)
                    
            
                   
            } .padding([.bottom, .leading, .trailing], 20)
        }

	}
        
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}


