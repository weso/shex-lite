package compiler.semantic
import compiler.ast.{ASTNode, BaseDeclaration, IRILiteral, PrefixDeclaration, ShapeDeclaration, StartDeclaration, Warning, Error}

import scala.collection.mutable.HashMap

object MemorySymbolTable extends SymbolTable {

  /**
    * The base default declaration.
    */
  override var base: BaseDeclaration = new BaseDeclaration("memsym.table", 6,3,
    new IRILiteral("memsym.table", 6,3,"<internal>"))

  /**
    * The start default declaration. If not definied at the end will continue being null.
    */
  override var start: StartDeclaration = null

  val prefixesTable = new HashMap[String, PrefixDeclaration]()
  val shapesTable = new HashMap[String, ShapeDeclaration]()

  /**
    * Inserts a prefix in the prefixes table, if it exists it will update its record.
    *
    * @param prefixDef is the prefix definition to be inserted.
    */
  override def insert(prefixDef: PrefixDeclaration): Either[Warning, PrefixDeclaration] = {
    if( prefixesTable contains prefixDef.name ) {
      val prevDecl = prefixesTable.get(prefixDef.name).get

      // Throw warning.
      val warn = new Warning(prefixDef, 1,
        s"The prefix declaration found at (${prefixDef.filename}:${prefixDef.line}:${prefixDef.column} " +
          s"is overwriting the already existing prefix declaration from (${prevDecl.filename}:${prevDecl.line}:${prevDecl.column}). " +
          s"Previous IRI was (${prevDecl.iri.value}), new value is (${prefixDef.iri.value})")
      MemoryErrorHandler.addWarning(warn)
    }

    // Prefixes can be override.
    prefixesTable + (prefixDef.name -> prefixDef)
    Right(prefixDef)
  }

  /**
    * Inserts a shape in the shapes table, shapes definitions must be unique.
    *
    * @param shapeDef is the shape definition to be inserted.
    */
  override def insert(shapeDef: ShapeDeclaration): Either[Error, ShapeDeclaration] = {
    if(shapesTable contains shapeDef.name.content) {
      val prevShp = shapesTable.get(shapeDef.name.content).get
      // Throw error.
      val err = new Error(shapeDef, 1,
        s"Shapes declarations cannot be overwritten. Shape declaration at (${shapeDef.filename}:${shapeDef.line}:${shapeDef.column}) " +
          s"with label (${shapeDef.name.content}) is trying to override shape declaration at (${prevShp.filename}:${prevShp.line}:${prevShp.column}) " +
          s"with label (${prevShp.name.content})")
      MemoryErrorHandler.addError(err)
      Left(err)
    } else {
      shapesTable + (shapeDef.name.content -> shapeDef)
      Right(shapeDef)
    }
  }

  /**
    * Gets the prefix definition indexed at the given prefix name.
    *
    * @param prefixName is the prefix name to look for in the table.
    * @return is a option object that might contain the prefix definition.
    */
  override def getPrefix(prefixName: String): Either[Error, PrefixDeclaration] = {
    val valOnTable = prefixesTable.get(prefixName)
    if(valOnTable.isDefined) {
      Right(valOnTable.get)
    } else {
      // Throw error.
      val err = new Error(null, 2,
        s"Prefix ($prefixName) not defined. Prefix invocations must make reference to a defined prefix on " +
          s"the current scheme. You can add the prefix to your schema by adding 'PREFIX $prefixName: <the_prefix_iri>' " +
          s"to your source file.")

      MemoryErrorHandler.addError(err)
      Left(err)
    }
  }

  /**
    * Gets the shape definition indexed at the given shape name.
    *
    * @param shapeName is the prefix name to look for in the table.
    * @return is a option object that might contain the prefix definition.
    */
  override def getShape(shapeName: String): Either[Error, ShapeDeclaration] = {
    val valOnTable = shapesTable.get(shapeName)
    if(valOnTable.isDefined) {
      Right(valOnTable.get)
    } else {
      // Throw error.
      val err = new Error(null, 2,
        s"Shape ($shapeName) not defined. Shape invocations must make reference to a defined shape on " +
          s"the current scheme. You can add the shape to your schema by adding '$shapeName constraint' " +
          s"to your source file.")

      MemoryErrorHandler.addError(err)
      Left(err)
    }
  }
}
