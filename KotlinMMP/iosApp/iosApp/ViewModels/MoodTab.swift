import SwiftUI
import shared

struct MoodTab : View{
    var mood: MoodInfo
    var identifier: String
    init(moodId: Int32) {
        mood =  MoodService().getMood(id: moodId)
        identifier = "mood" + String(moodId)
    }
    
    var body: some View {
        VStack {
            Image(mood.image)
                .resizable()
                .scaledToFit()
                .accessibilityIdentifier(identifier+"-image")
            Text(mood.text)
                .foregroundColor(Color(hex: mood.textColour))
                .font(Font.custom("Tahu!", size: 40))
                .accessibilityIdentifier(identifier+"-text")
        }.tag(mood.moodValue)
    }
}
