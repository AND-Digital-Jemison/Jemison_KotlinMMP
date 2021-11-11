import SwiftUI
import shared
import Amplify
import SSToastMessage

struct ContentView: View {
    @State private var selectedTab = MoodService().getMood(id: 0).moodValue
    @State var showToast = false
    
//    let moodSubmitToastColor: UIColor = UIColor(named: "MoodSubmitToastColor")!
    
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
                            showToast = true
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
            .present(isPresented: self.$showToast, type: .toast, position: .bottom, autohideDuration: 2) {
                       self.createMoodSubmitToastView()
            }
            
            
        }
        
    }
    
    
    
    func createMoodSubmitToastView() -> some View {
        VStack(alignment: .leading, spacing: 2) {
            Text("Mood submitted!")
                .lineLimit(2)
                .frame(minWidth: 0, maxWidth: .infinity)
                .font(Font.custom("Poppins-ExtraLight", size: 20))
                .foregroundColor(.white)
            }.padding()
             .background(Color.purple)

        }
    
    

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}


}
