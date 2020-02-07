package es.weso.shexl.ast;

public interface ASTNode {

    /** The Constant DEFAULT_ROW_COLUMN. */
    int DEFAULT_ROW_COLUMN = -1;

    /**
     * Gets the line where the element that is contained by the node is written.
     *
     * @return the line where the element that the node contains is written in
     *         the input file.
     */
    int getLine();

    /**
     * Gets the column where the element that is contained by the node is
     * written.
     *
     * @return the column where the element that the node contains is written in
     *         the input file.
     */
    int getColumn();
}
