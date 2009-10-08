package loafers.samples

import loafers.Loafers
//import loafers.builder.LoafersBuilderimport java.awt.Color
// show all colors arranged in a grid
// TODO size of window
// TODO scroll bar
Loafers.app {
	stack {
		subtitle "Colors"
		flow {
			button("Choose color") { 
				def color = ask_color("xxx")
				if (color) {
					colorFlow.append(
						stack(width:1/6) {
							background color
							// calculate "inverse" color for the text
							Color inverse = new Color(255-color.getRed(), 255-color.getGreen(), 255-color.getBlue())
							// TODO replace empty para with a margin-top
							para ""
//							caption strong("${field.name}"), width:1.0, align:"center", stroke:inverse
							para "(${color.red}, ${color.green}, ${color.blue})", width:1.0, align:"center", stroke:inverse
							// TODO replace empty para with a margin-bottom
							para ""
					})
				}
			}
		}
		colorFlow = flow {
			
		}
		subtitle "Predefined colors:"
		flow(scroll:true) {
			LoafersBuilder.class.fields.findAll{ it.type == Color }.each{ field ->
				Color color = field.get(null)
				
				stack(width:1/6) {
					background color
					// calculate "inverse" color for the text
					Color inverse = new Color(255-color.getRed(), 255-color.getGreen(), 255-color.getBlue())
					// TODO replace empty para with a margin-top
					para ""
					caption strong("${field.name}"), width:1.0, align:"center", stroke:inverse
					para "(${color.red}, ${color.green}, ${color.blue})", width:1.0, align:"center", stroke:inverse
					// TODO replace empty para with a margin-bottom
					para ""
				}
			}
		}
	}
}