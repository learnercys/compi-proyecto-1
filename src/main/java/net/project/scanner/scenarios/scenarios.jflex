package net.project.scanner.scenarios;

import java_cup.runtime.Symbol;
import java.util.ArrayList;
import java.util.HashMap;
import net.project.parser.scenarios.sym;

%%
%public
%class ScenariosScanner
%unicode
%line
%column
%cupsym sym
%cup

%{
    public ArrayList<HashMap<String, String>> errors = new ArrayList<>();

    private Symbol symbol(int type) {
        return new Symbol(type, yyline, yycolumn);
    }

    private Symbol symbol(int type, Object value) {
        return new Symbol(type, yyline, yycolumn);sss
    }
%}

%%

// tags

// single chars with meaning

// single words with meaning

// ER
{ID} { return symbol(sym.ID); }
{STRING} { return symbol(sym.STRING); }
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
