import SwiftUI
import shared
import Amplify

struct ContentView: View {
    @State private var selectedTab = MoodService().getMood(id: 0).moodValue
    
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
                    let mood = Mood(text: selectedTab)

                    Amplify.DataStore.save(mood) {
                        switch $0 {
                        case .success:
                            print("Created a new post successfully")
                        case .failure(let error):
                            print("Error creating post - \(error.localizedDescription)")
                        }
                    }
                }.buttonStyle(PrimaryButton())
                
                Text("This is anonymous")
                    .padding()
                    .multilineTextAlignment(.center)
                    .foregroundColor(.white)
                    .font(Font.custom("Poppins-ExtraLight", size: 16))
            }
            .padding([.bottom, .leading, .trailing], 20)
            .frame( width:UIScreen.main.bounds.width, height:UIScreen.main.bounds.height)
        }
        
    }
    
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}


