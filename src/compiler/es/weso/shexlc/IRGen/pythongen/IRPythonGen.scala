//------------------------------------------------------------------------------
// File: IRPythonGen.scala
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

package es.weso.shexlc.IRGen.pythongen

import compiler.es.weso.shexlc.IRGen.pythongen.{CGPython01ValidationStage, CGPython02ModuleGenStage}
import es.weso.shexlc.IRGen.{IRGenerator, TargetIR}
import es.weso.shexlc.sema.SIL

/**
 * The intermediate representation of the Python code are the different domain
 * model objects generated from the shapes.
 *
 * @author Alejandro Gonzalez Hevia
 */
trait IRPythonGen extends IRGenerator {}

object IRPythonGen {

  /**
   * Gets the Python generation from the Shex-lite intermediate language.
   *
   * @param sil is the shex-lite intermediate language used for the Python
   *            generation.
   * @return an IRGenerator object.
   */
  def getIR(sil: SIL): IRPythonGen =
    new IRPythonGen {

      private[this] val pythonCodeValidator =
        new CGPython01ValidationStage(sil.getCompilationContext)

      private[this] val pythonCodeGenerator =
        new CGPython02ModuleGenStage(sil.getCompilationContext)

      /**
       * Gets the generated sources if any. The generated sources are a list
       * of tuples where the first element is the
       * name of the generated source and the second value is its content.
       *
       * @return the list of tuples that contain the name of the source and
       *         the source content.
       */
      override def getGeneratedSources: List[(String, String)] = {
        if(!sil.getCompilationContext.getConfiguration.getTIR.contains(TargetIR.Python))
          return List.empty[(String, String)]

        // Validate that the SIL represents a valid schema for the representation.
        sil.getGraphEntryPoint.accept(pythonCodeValidator, ())
        if (sil.getCompilationContext.getErrorHandler.hasErrorMsgs) return List.empty[(String, String)]

        // If no error was generated, we can proceed to code generation
        sil.getGraphEntryPoint.accept(pythonCodeGenerator, "")
        pythonCodeGenerator.generatedSources.toList
      }
    }
}
