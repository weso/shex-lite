package es.weso.shexl.parser;

/**
 * The Class LexerHelper.
 *
 * @author Guillermo Facundo Colunga
 * @version 201806081225
 */
public class LexerHelper {

    /**
     * From a given string returns the integer that it represents.
     *
     * @param str to parse.
     * @return the integer represented by the string.
     */
    public static int lexemeToInt( String str ) {
        try {
            return Integer.parseInt( str );
        } catch (NumberFormatException e) {
            System.out.println( e );
        }
        return -1;
    }

    /**
     * From a given string returns the char that matches the given string.
     *
     * @param str to parse.
     * @return the character represented by the string.
     */
    public static char lexemeToChar( String str ) {
        if (str.contains( "\\" )) {
            if (str.contains( "n" )) {
                return '\n';
            } else if (str.contains( "t" )) {
                return '\t';
            }
            str = str.replaceAll( "\\D+", "" );
            return (char) Integer.parseInt( str );

        } else {
            return str.charAt( 1 );
        }
    }

    /**
     * From a given string returns the double that matches the given string.
     *
     * @param srt to parse.
     * @return the double represented by the string.
     */
    public static double lexemeToReal( String srt ) {
        try {
            return Double.parseDouble( srt );
        } catch (NumberFormatException e) {
            System.out.println( e );
        }
        return -1;
    }

}