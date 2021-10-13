import SwiftUI

extension Color {
    
    init?(hex: String) {
        self.init(white: 0.0)
        var hexSanitized = hex.trimmingCharacters(in: .whitespacesAndNewlines)
        hexSanitized = hexSanitized.replacingOccurrences(of: "#", with: "")

        var rgb: UInt64 = 0

        var red: Double = 0.0
        var green: Double = 0.0
        var blue: Double = 0.0
        let opacity: Double = 1.0


        guard Scanner(string: hexSanitized).scanHexInt64(&rgb) else { return nil }

        let length = hexSanitized.count
        if length == 6 {
            red = extractRedFromRgb(rgb)
            green = extractGreenFromRgb(rgb)
            blue = extractBlueFromRgb(rgb)
        }

        self.init(.sRGB, red: red, green: green, blue: blue, opacity: opacity)
    }
    
    fileprivate func extractRedFromRgb(_ rgb: UInt64) -> Double {
        return Double((rgb & 0xFF0000) >> 16) / 255.0
    }
    
    fileprivate func extractGreenFromRgb(_ rgb: UInt64) -> Double {
        return Double((rgb & 0x00FF00) >> 8) / 255.0
    }
    
    fileprivate func extractBlueFromRgb(_ rgb: UInt64) -> Double {
        return Double(rgb & 0x0000FF) / 255.0
    }
}
