import SwiftUI
import shared

struct MoodTab : View{
    var mood: Mood
    init(moodId: Int32) {
        mood =  MoodService().getMood(id: moodId)
        
    }
    
    var body: some View {
        Text(mood.text)
            .foregroundColor(Color(hex: mood.colour))
            .bold()
            .tag("great")
        }
}