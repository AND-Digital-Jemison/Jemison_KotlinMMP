import SwiftUI
import shared

struct ContentView: View {
    @State private var selectedTab = "Doing Great"

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
                    MoodTab(moodId:  MoodService.Companion().GOOD_MOOD)
                    MoodTab(moodId: MoodService.Companion().BAD_MOOD)
                }
                .padding()
                .tabViewStyle( PageTabViewStyle())

                Button("SUBMIT") {
                    print("Button tapped! Response selected: ", selectedTab)
                }.buttonStyle(PrimaryButton())

                Text("This is anonymous")
                    .padding()
                    .multilineTextAlignment(.center)
                    .foregroundColor(.white)
                    .font(Font.custom("Poppins-ExtraLight", size: 16))
            }
            .padding([.bottom, .leading, .trailing], 20)
            .frame(
               width:UIScreen.main.bounds.width,
               height:UIScreen.main.bounds.height
            )
            
            
            
            
        }
	}
        
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
        ContentView()
                    .previewDevice(PreviewDevice(rawValue: "iPhone 12"))
                    .previewDisplayName("iPhone 12")
        ContentView()
                    .previewDevice(PreviewDevice(rawValue: "iPhone 8 plus"))
                    .previewDisplayName("iPhone 8 plus")
	}
}


