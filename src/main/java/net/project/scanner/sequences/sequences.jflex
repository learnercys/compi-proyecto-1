package net.project.scanner.sequences;

%%
%public
%class SequencesScanner
%unicode
%line
%column
%cupsym sy
%cup

%%

// ER
[:digit:]+ { return symbol(sym.INT); }

[ \n\t\f]   { /* white space */}

. {
    System.out.println("Line: " + (yyline + 1) + ", column: " + (yycolumn + 1) + ", Lexical error in: " + yytext());
    HashMap<String, String> error = new HashMap<>();
    error.put("line", Integer.toString(yyline + 1));
    error.put("column", Integer.toString(yycolumn +1));
    error.put("text", yytext());
    error.put("number", Integer.toString(errors.size() + 1));
    errors.add( error );
}

