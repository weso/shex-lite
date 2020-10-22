package es.weso.shexl.impl;

import es.weso.shexl.ShExLiteTranslator;
import es.weso.shexlc.IRGen.TargetIR;
import es.weso.shexlc.IRGen.TargetIR$;
import es.weso.shexlc.internal.CompilationConfig;
import scala.collection.mutable.HashMap;
import java.util.HashSet;
import java.util.Set;

public class ToJavaShExLiteTranslator implements ShExLiteTranslator {

    private CompilationConfig config = new CompilationConfig() {

        @Override
        public boolean generateWarnings() {
            return false;
        }

        @Override
        public boolean generateIR() {
            return true;
        }

        @Override
        public Set<TargetIR> getTIR() {
            Set<TargetIR> aux = new HashSet<>();
            aux.add(TargetIR.Java());
        }

        @Override
        public HashMap<String, String> getProperties() {
            return super.getProperties();
        }
    }

    @Override
    public void translate(String inDirectory, String outDir) {

    }
}
