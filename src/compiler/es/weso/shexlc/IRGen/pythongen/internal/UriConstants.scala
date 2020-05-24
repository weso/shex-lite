//------------------------------------------------------------------------------
// File: UriConstants.scala
//
// Copyright 2020 Alejandro González Hevia
//
// Permission is hereby granted, free of charge, to any person obtaining a
// copy of this software and associated documentation files (the "Software"),
// to deal in the Software without restriction, including without limitation
// the rights to use, copy, modify, merge, publish, distribute, sublicense,
// and/or sell copies of the Software, and to permit persons to whom the
// Software is furnished to do so, subject to the following conditions:
//
// The above copyright notice and this permission notice shall be included in
// all copies or substantial portions of the Software.
//
// THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
// IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
// FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
// AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
// LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
// OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
// THE SOFTWARE.
//------------------------------------------------------------------------------

package compiler.es.weso.shexlc.IRGen.pythongen.internal

import es.weso.shexlc.parse.ast.expr.CallPrefixExpr

/**
 * Constants and functions used to work with URIs
 * for the Python code generation from shape expressions
 *
 * @author Alejandro Gonzalez Hevia.
 */
object UriConstants {

  final val GEO_BASE = "http://www.opengis.net/ont/geosparql#"
  final val OWL_BASE = "http://www.w3.org/2002/07/owl#"
  final val RDF_BASE = "http://www.w3.org/1999/02/22-rdf-syntax-ns#"
  final val RDFS_BASE = "http://www.w3.org/2000/01/rdf-schema#"
  final val XSD_BASE = "http://www.w3.org/2001/XMLSchema#"

  def extractCompleteUriFrom(expr: CallPrefixExpr): String = {
    val baseURI = expr
      .definition.asPrefixDefStmt
      .expression.getContent
      .stripPrefix("<").stripSuffix(">")
    s"${baseURI}${expr.argument}"
  }
}
