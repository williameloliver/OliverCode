package cl.will.codepadai;

import java.io.File;

final class DocumentTab {
    final File file;
    String text;
    boolean dirty;
    int cursor;
    DocumentTab(File file, String text) { this.file=file; this.text=text; }
    String name() { return file.getName() + (dirty ? " *" : ""); }
}
