import SwiftUI
import shared

struct PrimaryButton: ButtonStyle {
    @Environment(\.isEnabled) private var isEnabled

    func makeBody(configuration: Configuration) -> some View {
        configuration
            .label
            .foregroundColor(configuration.isPressed ? .gray : .white)
            .padding()
            .frame(minWidth: 0, maxWidth: .infinity)
            .background(Color.gray.opacity(0.3))
            .border(Color.white)
            .font(Font.custom("Poppins-ExtraLight", size: 20))
    }
}
