//------------------------------------------------------------------------------
// File: PythonDatatypeMappings.scala
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

import es.weso.shexlc.parse.ast.expr.{CallPrefixExpr, CallShapeExpr, Expression}
import UriConstants.{RDF_BASE, XSD_BASE, extractCompleteUriFrom}

/**
 * Collection of functions to map XML based datatypes
 * to Python ones.
 *
 * These functions are used in the generation of Python code
 * from shape expressions.
 *
 * @author Alejandro Gonzalez Hevia
 */
object PythonDatatypeMappings {

  // mappings of rdf datatypes to python datatypes
  private final val XML_2_PYTHON_TYPE = Map(
    s"${RDF_BASE}HTML" -> "DocumentFragment",
    s"${RDF_BASE}XMLLiteral" -> "Document",
    s"${XSD_BASE}boolean" -> "bool",
    s"${XSD_BASE}date" -> "date",
    s"${XSD_BASE}dateTime" -> "datetime",
    s"${XSD_BASE}decimal" -> "float",
    s"${XSD_BASE}double" -> "float",
    s"${XSD_BASE}float" -> "float",
    s"${XSD_BASE}integer" -> "int",
    s"${XSD_BASE}long" -> "long",
    s"${XSD_BASE}negativeInteger" -> "int",
    s"${XSD_BASE}nonNegativeInteger" -> "int",
    s"${XSD_BASE}nonPositiveInteger" -> "int",
    s"${XSD_BASE}normalizedString" -> "str",
    s"${XSD_BASE}short" -> "int",
    s"${XSD_BASE}string" -> "str",
    s"${XSD_BASE}time" -> "time",
    s"${XSD_BASE}token" -> "str",
    s"${XSD_BASE}unsignedByte" -> "int",
    s"${XSD_BASE}unsignedInt" -> "long",
    s"${XSD_BASE}unsignedShort" -> "int",
  )

  // mappings of rdf datatypes to python modules to import
  private final val XML_2_PYTHON_MODULE = Map(
    s"${RDF_BASE}HTML" -> ("xml.dom.minidom", "DocumentFragment"),
    s"${RDF_BASE}XMLLiteral" -> ("xml.dom.minidom", "Document"),
    s"${XSD_BASE}date" -> ("datetime", "date"),
    s"${XSD_BASE}dateTime" -> ("datetime", "datetime"),
    s"${XSD_BASE}time" -> ("datetime", "time")
  )

  /**
   * Returns whether the given URI has a valid Python mapping or not.
   *
   * @param xmlDatatypeURI String of the URI which points to a XML datatype.
   * @return True if the URI has a valid Python mapping, False otherwise.
   */
  def hasPythonDatatypeMapping(xmlDatatypeURI: String): Boolean = {
    XML_2_PYTHON_TYPE.contains(xmlDatatypeURI)
  }

  /**
   * Converts the string representation of a python type to a list.
   */
  def toList(pythonType: String): String = {
    s"List[$pythonType]"
  }

  /**
   * Converts a CallPrefixExpr to a tuple of strings that need to be imported.
   *
   * @return Option[(String, String)]. If the expr points to an URI which can be imported
   *         from Python, the first element of the tuple represents the package to import
   *         and the second the module from the package that needs to be imported. Otherwise,
   *         the Option will have no value.
   */
  def toPythonImport(expr: CallPrefixExpr, isList: String): Option[(String, String)] = {
    XML_2_PYTHON_MODULE.get(extractCompleteUriFrom(expr))
  }

  /**
   * Converts the given expression to its equivalent Python type
   *
   * @return String with the representation of the Python type from the given
   *         expression. If no suitable type is found, "Any" is returned instead,
   *         according to the official Python Typing documentation.
   */
  def toPythonType(expr: Expression, isList: String): String = {
    val typeStr = if (expr.isCallPrefixExpr) generateFieldTypingFrom(expr.asCallPrefixExpr)
                  else generateFieldTypingFrom(expr.asCallShapeExpr)
    if (isList > "1") toList(typeStr) else typeStr
  }

  private def generateFieldTypingFrom(expr: CallPrefixExpr): String = {
    XML_2_PYTHON_TYPE.get(extractCompleteUriFrom(expr)) match {
      case Some(value) => value
      case None => "Any"
    }
  }

  private def generateFieldTypingFrom(expr: CallShapeExpr): String = {
    val baseExprArg = if (expr.label.isCallPrefixExpr) expr.label.asCallPrefixExpr.argument else expr.label.asCallBaseExpr.argument
    baseExprArg.toLowerCase.capitalize
  }
}