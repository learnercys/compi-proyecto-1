package net.project.scanner.structures;

import java_cup.runtime.Symbol;
import java.util.ArrayList;
import java.util.HashMap;
import net.project.parser.structures.sym;

%%
%public
%class StructuresScanner
%unicode
%line
%column
%cupsym sym
$cup

%{
    public ArrayList<HashMap<String, String>> errors = new ArrayList<>();

    private Symbol symbol(int type) {
        return new Symbol(type, yyline, yycolumn);
    }

    private Symbol symbol(int type, String value) {
        return new Symbol(type, yyline, yycolumn);
    }

%}

%%

// single chars
LESS_THAN = "<"
LESS_THAT_S = "</"

//single chars with meaning

/ tags




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
