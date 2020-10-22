package es.weso.shexl;

/**
 * This interface defines the translation methods that different translators implement.
 * A different translator is an abstraction of an specific configuration of the inner
 * translator.
 *
 * @author Guillermo Facundo Colunga
 * @versio 20201006
 */
public interface ShExLiteTranslator {

    /**
     * Gets an input directory and translates the contents of it that match a shape expression. The result of the
     * translation is stored in the output directory.
     *
     * @param inDirectory contains the files to translate. The files that the translation will translate are only those
     *                    that end with .shexl extension.
     * @param outDir will contain the result of the translation if no error.
     */
    void translate(String inDirectory, String outDir);
}
