/*
 * Short version for non-lawyers:
 *
 * The ShEx Lite Project is dual-licensed under GNU 3.0 and
 * MIT terms.
 *
 * Longer version:
 *
 * Copyrights in the ShEx Lite project are retained by their contributors. No
 * copyright assignment is required to contribute to the ShEx Lite project.
 *
 * Some files include explicit copyright notices and/or license notices.
 * For full authorship information, see the version control history.
 *
 * Except as otherwise noted (below and/or in individual files), ShEx Lite is
 * licensed under the GNU, Version 3.0 <LICENSE-GNU> or
 * <https://choosealicense.com/licenses/gpl-3.0/> or the MIT license
 * <LICENSE-MIT> or <http://opensource.org/licenses/MIT>, at your option.
 *
 * The ShEx Lite Project includes packages written by third parties.
 */

package internal.error

/**
 * Skeleton fot error type objects.
 *
 * @param code        of the error. must be unique.
 * @param description of the error.
 */
class SuperErrorType(val code: String, val description: String) extends ErrType

/**
 * Element Override Error Types.
 */
object BaseOverrideErr extends SuperErrorType("E001", "attempt to override a base directive value")

object StartOverrideErr extends SuperErrorType("E002", "attempt to override an start directive value")

object PrefixOverrideErr extends SuperErrorType("E003", "attempt to override an already defined prefix")

object ShapeOverrideErr extends SuperErrorType("E004", "attempt to override an already defined shape")

/**
 * Element Not Found Error.
 */
object BaseNotFoundErr extends SuperErrorType("E005", "base not defined")

object StartNotFoundErr extends SuperErrorType("E006", "start not defined")

object PrefixNotFoundErr extends SuperErrorType("E007", "prefix not defined")

object ShapeNotFoundErr extends SuperErrorType("E008", "shape not defined")


object NullReferenceErr extends SuperErrorType("E009", "null reference")

object NonValidActionErr extends SuperErrorType("E010", "non valid action")