package loafers.text

public class PlainFragment extends TextFragment {
    private String text
    private static List safeCharacters = [',' as char, '.' as char]

    public PlainFragment(Object object) {
        this.text = object?.toString()
    }
    
    public PlainFragment(String text) {
        this.text = text
    }
    
    /**
     * Encodes the given text using html entities. This is needed so the text will always be shown
     * <p>
     * Letters, digits and whitespace is kept, all other characters are converted into a html entity as <code>&amp;#&lt;character as int&gt;;</code>
     */
    public static String HTMLEntityEncode( String text ) {
        return text.toCharArray().inject("") { encoded, c ->
            if ( c.isWhitespace() || c.isLetterOrDigit() || safeCharacters.contains(c) ) {
                encoded += c;
            }
            else {
                encoded += "&#" + (int)c + ";";
            }
            
            return encoded
        }
    }
    
    public String getHtmlFragment() {
        def matcher = (HTMLEntityEncode(text) =~ /\n/);
        String result = matcher.replaceAll("<br>");
        
        // TODO use regexp
        if(result.endsWith(' ')){
            if(result.length() == 1) {
                result = "&nbsp;"
            }else {
                result = result[0..-2] + "&nbsp;"
            }
        }
        if(result.startsWith(' ')){
            result = "&nbsp;"+result[1..-1] 
        }
        
        return result
    }
    
    public String getText() {
        return text
    }
    
    protected void doSetText(String text) {
        this.text = text
    }

    @Override
    public String toString() {
        return "Plain($text)"
    }
}