//------------------------------------------------------------------------------
// File: CompilationConfigTest.scala
//
// Short version for non-lawyers:
//
// The ShEx Lite Project is dual-licensed under GNU 3.0 and
// MIT terms.
//
// Longer version:
//
// Copyrights in the ShEx Lite project are retained by their contributors. No
// copyright assignment is required to contribute to the ShEx Lite project.
//
// Some files include explicit copyright notices and/or license notices.
// For full authorship information, see the version control history.
//
// Except as otherwise noted (below and/or in individual files), ShEx Lite is
// licensed under the GNU, Version 3.0 <LICENSE-GNU> or
// <https://choosealicense.com/licenses/gpl-3.0/> or the MIT license
// <LICENSE-MIT> or <http://opensource.org/licenses/MIT>, at your option.
// In case of incompatibility between project licenses, GNU/GPLv3 will be
// applied.
//
// The ShEx Lite Project includes packages written by third parties.
//------------------------------------------------------------------------------

package es.weso.shexlc.internal

import org.scalatest.BeforeAndAfter
import org.scalatest.funsuite.AnyFunSuite

class CompilationConfigTest extends AnyFunSuite with BeforeAndAfter {

  // Testing that the default compilation configuration is correct.
  test("Default compilation config is correct") {
    val defaultWarn   = true
    val defaultGenIR  = false
    val defaultIRList = Set.empty[ShExLCompilerTargetLanguage]
    val cc            = CompilationConfigBuilder().build

    assert(cc.generateWarnings == defaultWarn)
    assert(cc.generateIR == defaultGenIR)
    assert(cc.getTIR == defaultIRList)
  }

  // Testing to change the value of the warning generation.
  test("Test that the value of the warnings generation can be changed") {
    val cc = CompilationConfigBuilder().generateWarnings(false).build
    assert(cc.generateWarnings == false)
    val cc = CompilationConfigBuilder().generateWarnings(true).build
    assert(cc.generateWarnings == true)
  }

  // Testing to change the value of the ir generation.
  test("Test that the value of the ir generation can be changed") {
    val cc = CompilationConfigBuilder().generateIR(true).build
    assert(cc.generateWarnings == true)
    val cc = CompilationConfigBuilder().generateIR(false).build
    assert(cc.generateWarnings == false)
  }

  // Testing to change the value of the ir list generation.
  test("Test that the value of the ir list generation can be changed") {
    val cc = CompilationConfigBuilder()
      .withTIR(List(CompilerTargetLanguage.Java))
      .build
    assert(cc.getTIR.size == 1)
    val cc = CompilationConfigBuilder()
      .withTIR(List(CompilerTargetLanguage.Java, CompilerTargetLanguage.Python))
      .build
    assert(cc.getTIR.size == 1)
  }
}
