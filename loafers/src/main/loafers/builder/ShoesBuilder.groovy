package loafers.builder

import java.awt.Color
import javax.swing.JOptionPaneimport javax.swing.JColorChooserimport javax.swing.JFileChooserimport loafers.builder.events.ClickFactory
import loafers.builder.events.ReleaseFactory
import loafers.builder.timer.AnimationFactoryimport loafers.builder.timer.EveryFactoryimport loafers.builder.timer.TimerFactoryimport java.awt.Toolkitimport java.awt.datatransfer.Clipboardimport java.awt.datatransfer.DataFlavorimport loafers.text.TextFragmentimport loafers.text.PlainFragmentimport loafers.text.CompositeFragmentimport loafers.text.Codeimport loafers.text.Subimport loafers.text.Supimport loafers.text.Delimport loafers.text.Emimport loafers.text.Insimport loafers.text.Strongimport loafers.text.Linkimport java.awt.datatransfer.StringSelection
/**
 * @author Peter De Bruycker
 */
public class ShoesBuilder extends FactoryBuilderSupport {
	private Clipboard clipboard
	
	public ShoesBuilder() {
		// app and window
		registerFactory("app", new AppFactory())
		registerFactory("window", new WindowFactory())
		
		// slot elements
		registerFactory("flow", new FlowFactory())
		registerFactory("stack", new StackFactory())
		
		// elements
		registerFactory("button", new ButtonFactory())
		registerFactory("edit_line", new EditLineFactory())
		registerFactory("edit_box", new EditBoxFactory())
		registerFactory("list_box", new ListBoxFactory())
		registerFactory("check", new CheckFactory())
		registerFactory("progress", new ProgressFactory())
		registerFactory("image", new ImageFactory())
		registerFactory("swing", new SwingFactory())
		
		// background and fill
		registerFactory("background", new BackgroundFactory())
		
		// textblock elements
		registerFactory("banner", new TextBlockFactory(48))
		registerFactory("title", new TextBlockFactory(34))
		registerFactory("subtitle", new TextBlockFactory(26))
		registerFactory("tagline", new TextBlockFactory(18))
		registerFactory("caption", new TextBlockFactory(14))
		registerFactory("para", new TextBlockFactory(12))
		registerFactory("inscription", new TextBlockFactory(10))
		
		// animation stuff (replace with methods on ShoesBuilder?)
		registerFactory("animate", new AnimationFactory())
		registerFactory("every", new EveryFactory())
		registerFactory("timer", new TimerFactory())
		
		// events
		registerFactory("click", new ClickFactory());
		registerFactory("release", new ReleaseFactory());
	}
	
	private TextFragment asTextFragment(Object[] text) {
		assert text != null, "text cannot be null"
		
		if(text.length == 1) {
			return asTextFragment(text[0])
		}
		
		return new CompositeFragment(text.collect({ asTextFragment(it) }))
	}
	
	private TextFragment asTextFragment(Object text) {
		assert text != null, "text cannot be null"
		
		return text instanceof TextFragment ? text : new PlainFragment(text.toString())
	}
	
	// start text fragments
	public TextFragment code(Object... text) {
		return new Code(asTextFragment(text))
	}
	
	public TextFragment code(Object text) {
		return new Code(asTextFragment(text))
	}
	
	public TextFragment sub(Object... text) {
		return new Sub(asTextFragment(text))
	}
	
	public TextFragment sub(Object text) {
		return new Sub(asTextFragment(text))
	}
	
	public TextFragment sup(Object... text) {
		return new Sup(asTextFragment(text))
	}
	
	public TextFragment sup(Object text) {
		return new Sup(asTextFragment(text))
	}
	
	public TextFragment del(Object... text) {
		return new Del(asTextFragment(text))
	}
	
	public TextFragment del(Object text) {
		return new Del(asTextFragment(text))
	}
	
	public TextFragment em(Object... text) {
		return new Em(asTextFragment(text))
	}
	
	public TextFragment em(Object text) {
		return new Em(asTextFragment(text))
	}
	
	public TextFragment ins(Object... text) {
		return new Ins(asTextFragment(text))
	}
	
	public TextFragment ins(Object text) {
		return new Ins(asTextFragment(text))
	}
	
	public TextFragment strong(Object... text) {
		return new Strong(asTextFragment(text))
	}
	
	public TextFragment strong(Object text) {
		return new Strong(asTextFragment(text))
	}
	
	public TextFragment link(Object text, Closure click) {
		return new Link(asTextFragment(text), click)
	}
	
	public TextFragment link(Object[] text, Closure click) {
		return new Link(asTextFragment(text), click)
	}
	
	// end text fragments
	
	public void alert(String message) {
		// TODO set the current jframe as parent
		JOptionPane.showMessageDialog(null, message)
	}
	
	public String ask(String message, String value = ""){
		// TODO set the current jframe as parent
		return JOptionPane.showInputDialog(null, message, value)
	}
	
	public Color ask_color(String title, Color defaultColor = null) {
		// TODO set the current jframe as parent
		return JColorChooser.showDialog(null, title, defaultColor);
	}
	
	public File ask_save_file() {
		JFileChooser chooser = new JFileChooser();
		
		if(JFileChooser.APPROVE_OPTION == chooser.showSaveDialog(null)) {
			return chooser.getSelectedFile()
		}
	}
	
	public static File ask_open_file() {
		JFileChooser chooser = new JFileChooser();
		
		if(JFileChooser.APPROVE_OPTION == chooser.showOpenDialog(null)) {
			return chooser.getSelectedFile()
		}
	}
	
	public static File ask_open_folder() {
		JFileChooser chooser = new JFileChooser();
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY)
		
		if(JFileChooser.APPROVE_OPTION == chooser.showOpenDialog(null)) {
			return chooser.getSelectedFile()
		}
	}
	
	
	
	public static File ask_save_folder() {
		JFileChooser chooser = new JFileChooser();
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY)
		
		if(JFileChooser.APPROVE_OPTION == chooser.showSaveDialog(null)) {
			return chooser.getSelectedFile()
		}
	}
	
	public static boolean confirm(String message) {
		return JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null, message, "Confirm", JOptionPane.YES_NO_OPTION)
	}
	
	public void clipboard(String text) {
		if(clipboard == null) {
			Toolkit tk = Toolkit.getDefaultToolkit()
			clipboard = tk.systemClipboard
		}
		
		clipboard.setContents(new StringSelection(text))
	}
	
	public String clipboard() {
		if(clipboard == null) {
			Toolkit tk = Toolkit.getDefaultToolkit()
			clipboard = tk.systemClipboard
		}
		
		if(clipboard.isDataFlavorAvailable(DataFlavor.stringFlavor)) {
			return clipboard.getData(DataFlavor.stringFlavor)
		}
		
		return null
	}
	
	// colors
	public static final Color aliceblue = rgb(240, 248, 255)
	public static final Color antiquewhite = rgb(250, 235, 215)
	public static final Color aqua = rgb(0, 255, 255)
	public static final Color aquamarine = rgb(127, 255, 212)
	public static final Color azure = rgb(240, 255, 255)
	public static final Color beige = rgb(245, 245, 220)
	public static final Color bisque = rgb(255, 228, 196)
	public static final Color black = rgb(0, 0, 0)
	public static final Color blanchedalmond = rgb(255, 235, 205)
	public static final Color blue = rgb(0, 0, 255)
	public static final Color blueviolet = rgb(138, 43, 226)
	public static final Color brown = rgb(165, 42, 42)
	public static final Color burlywood = rgb(222, 184, 135)
	public static final Color cadetblue = rgb(95, 158, 160)
	public static final Color chartreuse = rgb(127, 255, 0)
	public static final Color chocolate = rgb(210, 105, 30)
	public static final Color coral = rgb(255, 127, 80)
	public static final Color cornflowerblue = rgb(100, 149, 237)
	public static final Color cornsilk = rgb(255, 248, 220)
	public static final Color crimson = rgb(220, 20, 60)
	public static final Color cyan = rgb(0, 255, 255)
	public static final Color darkblue = rgb(0, 0, 139)
	public static final Color darkcyan = rgb(0, 139, 139)
	public static final Color darkgoldenrod = rgb(184, 134, 11)
	public static final Color darkgray = rgb(169, 169, 169)
	public static final Color darkgreen = rgb(0, 100, 0)
	public static final Color darkkhaki = rgb(189, 183, 107)
	public static final Color darkmagenta = rgb(139, 0, 139)
	public static final Color darkolivegreen = rgb(85, 107, 47)
	public static final Color darkorange = rgb(255, 140, 0)
	public static final Color darkorchid = rgb(153, 50, 204)
	public static final Color darkred = rgb(139, 0, 0)
	public static final Color darksalmon = rgb(233, 150, 122)
	public static final Color darkseagreen = rgb(143, 188, 143)
	public static final Color darkslateblue = rgb(72, 61, 139)
	public static final Color darkslategray = rgb(47, 79, 79)
	public static final Color darkturquoise = rgb(0, 206, 209)
	public static final Color darkviolet = rgb(148, 0, 211)
	public static final Color deeppink = rgb(255, 20, 147)
	public static final Color deepskyblue = rgb(0, 191, 255)
	public static final Color dimgray = rgb(105, 105, 105)
	public static final Color dodgerblue = rgb(30, 144, 255)
	public static final Color firebrick = rgb(178, 34, 34)
	public static final Color floralwhite = rgb(255, 250, 240)
	public static final Color forestgreen = rgb(34, 139, 34)
	public static final Color fuchsia = rgb(255, 0, 255)
	public static final Color gainsboro = rgb(220, 220, 220)
	public static final Color ghostwhite = rgb(248, 248, 255)
	public static final Color gold = rgb(255, 215, 0)
	public static final Color goldenrod = rgb(218, 165, 32)
	public static final Color gray = rgb(128, 128, 128)
	public static final Color green = rgb(0, 128, 0)
	public static final Color greenyellow = rgb(173, 255, 47)
	public static final Color honeydew = rgb(240, 255, 240)
	public static final Color hotpink = rgb(255, 105, 180)
	public static final Color indianred = rgb(205, 92, 92)
	public static final Color indigo = rgb(75, 0, 130)
	public static final Color ivory = rgb(255, 255, 240)
	public static final Color khaki = rgb(240, 230, 140)
	public static final Color lavender = rgb(230, 230, 250)
	public static final Color lavenderblush = rgb(255, 240, 245)
	public static final Color lawngreen = rgb(124, 252, 0)
	public static final Color lemonchiffon = rgb(255, 250, 205)
	public static final Color lightblue = rgb(173, 216, 230)
	public static final Color lightcoral = rgb(240, 128, 128)
	public static final Color lightcyan = rgb(224, 255, 255)
	public static final Color lightgoldenrodyellow = rgb(250, 250, 210)
	public static final Color lightgreen = rgb(144, 238, 144)
	public static final Color lightgrey = rgb(211, 211, 211)
	public static final Color lightpink = rgb(255, 182, 193)
	public static final Color lightsalmon = rgb(255, 160, 122)
	public static final Color lightseagreen = rgb(32, 178, 170)
	public static final Color lightskyblue = rgb(135, 206, 250)
	public static final Color lightslategray = rgb(119, 136, 153)
	public static final Color lightsteelblue = rgb(176, 196, 222)
	public static final Color lightyellow = rgb(255, 255, 224)
	public static final Color lime = rgb(0, 255, 0)
	public static final Color limegreen = rgb(50, 205, 50)
	public static final Color linen = rgb(250, 240, 230)
	public static final Color magenta = rgb(255, 0, 255)
	public static final Color maroon = rgb(128, 0, 0)
	public static final Color mediumaquamarine = rgb(102, 205, 170)
	public static final Color mediumblue = rgb(0, 0, 205)
	public static final Color mediumorchid = rgb(186, 85, 211)
	public static final Color mediumpurple = rgb(147, 112, 219)
	public static final Color mediumseagreen = rgb(60, 179, 113)
	public static final Color mediumslateblue = rgb(123, 104, 238)
	public static final Color mediumspringgreen = rgb(0, 250, 154)
	public static final Color mediumturquoise = rgb(72, 209, 204)
	public static final Color mediumvioletred = rgb(199, 21, 133)
	public static final Color midnightblue = rgb(25, 25, 112)
	public static final Color mintcream = rgb(245, 255, 250)
	public static final Color mistyrose = rgb(255, 228, 225)
	public static final Color moccasin = rgb(255, 228, 181)
	public static final Color navajowhite = rgb(255, 222, 173)
	public static final Color navy = rgb(0, 0, 128)
	public static final Color oldlace = rgb(253, 245, 230)
	public static final Color olive = rgb(128, 128, 0)
	public static final Color olivedrab = rgb(107, 142, 35)
	public static final Color orange = rgb(255, 165, 0)
	public static final Color orangered = rgb(255, 69, 0)
	public static final Color orchid = rgb(218, 112, 214)
	public static final Color palegoldenrod = rgb(238, 232, 170)
	public static final Color palegreen = rgb(152, 251, 152)
	public static final Color paleturquoise = rgb(175, 238, 238)
	public static final Color palevioletred = rgb(219, 112, 147)
	public static final Color papayawhip = rgb(255, 239, 213)
	public static final Color peachpuff = rgb(255, 218, 185)
	public static final Color peru = rgb(205, 133, 63)
	public static final Color pink = rgb(255, 192, 203)
	public static final Color plum = rgb(221, 160, 221)
	public static final Color powderblue = rgb(176, 224, 230)
	public static final Color purple = rgb(128, 0, 128)
	public static final Color red = rgb(255, 0, 0)
	public static final Color rosybrown = rgb(188, 143, 143)
	public static final Color royalblue = rgb(65, 105, 225)
	public static final Color saddlebrown = rgb(139, 69, 19)
	public static final Color salmon = rgb(250, 128, 114)
	public static final Color sandybrown = rgb(244, 164, 96)
	public static final Color seagreen = rgb(46, 139, 87)
	public static final Color seashell = rgb(255, 245, 238)
	public static final Color sienna = rgb(160, 82, 45)
	public static final Color silver = rgb(192, 192, 192)
	public static final Color skyblue = rgb(135, 206, 235)
	public static final Color slateblue = rgb(106, 90, 205)
	public static final Color slategray = rgb(112, 128, 144)
	public static final Color snow = rgb(255, 250, 250)
	public static final Color springgreen = rgb(0, 255, 127)
	public static final Color steelblue = rgb(70, 130, 180)
	public static final Color tan = rgb(210, 180, 140)
	public static final Color teal = rgb(0, 128, 128)
	public static final Color thistle = rgb(216, 191, 216)
	public static final Color tomato = rgb(255, 99, 71)
	public static final Color turquoise = rgb(64, 224, 208)
	public static final Color violet = rgb(238, 130, 238)
	public static final Color wheat = rgb(245, 222, 179)
	public static final Color white = rgb(255, 255, 255)
	public static final Color whitesmoke = rgb(245, 245, 245)
	public static final Color yellow = rgb(255, 255, 0)
	public static final Color yellowgreen = rgb(154, 205, 50)
	
	public static Color rgb(int r, int g, int b) {
		return new Color(r, g, b)
	}
}