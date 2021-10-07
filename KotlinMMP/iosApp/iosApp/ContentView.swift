import SwiftUI
import shared

struct ContentView: View {
	let greet = Greeting().greeting()

	var body: some View {
        Text("How are you doing today?")
            .font(.largeTitle)
            .multilineTextAlignment(.center)
            .padding(.top, 100)
            .lineSpacing(10)
       
        ZStack{
            TabView {
                    Text("I'm Great!")
                        .foregroundColor(.green)
                        .bold()
        
                    Text("I'm not Well")
                        .foregroundColor(.red)
                        .bold()
            
                 }
            .padding(.top,-100)
            .tabViewStyle( PageTabViewStyle())
         
        }
     
        Button("Submit") {
            print("Button tapped!")
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


