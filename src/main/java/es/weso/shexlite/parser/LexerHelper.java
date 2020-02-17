/*
 * MIT License
 *
 * Copyright (c) 2020 WESO Research Group, University of Oviedo.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 */

package es.weso.shexlite.parser;

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