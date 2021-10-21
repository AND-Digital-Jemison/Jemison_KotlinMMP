import SwiftUI
import shared

struct MoodTab : View{
    var mood: Mood
    init(moodId: Int32) {
        mood =  MoodService().getMood(id: moodId)
        
    }
    
    var body: some View {
        VStack{
            Image(mood.image)
                .resizable()
                .scaledToFit()
            Text(mood.text)
                .foregroundColor(Color(hex: mood.textColour))
                .font(Font.custom("Tahu!", size: 40))
        }.tag(mood.text)
    }
}
