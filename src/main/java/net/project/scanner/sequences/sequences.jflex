package net.project.scanner.sequences;

import java_cup.runtime.Symbol;
import java.util.ArrayList;
import java.util.HashMap;
import net.project.parser.sequences.sym;

%%
%public
%class SequencesScanner
%unicode
%line
%column
%cupsym sym
%cup

%{
    public ArrayList<HashMap<String, String>> errors = new ArrayList<>();

    public Symbol symbol(int type) {
        return new Symbol(type, yyline, yycolumn, yytext());
    }

    public Symbol symbol(int type, Object value) {
        return new Symbol(type, yyline, yycolumn);
    }
%}

// single chars
LESS_THAN = "<"
LESS_THAN_S = "</"
MORE_THAN = ">"
MORE_THAN_S = "/>"

// tags
INIT_SCENARIOS = {LESS_THAN} "escenarios" {MORE_THAN}
END_SCENARIOS = {LESS_THAN_S} "escenarios" {MORE_THAN}

INIT_SCENARIO = {LESS_THAN} "escenario"

// ER
ID = [a-zA-Z][a-zA-Z0-9_]+

%%

// tags
{INIT_SCENARIOS} { return symbol(sym.INIT_SCENARIOS); }
{END_SCENARIOS} { return symbol(sym.END_SCENARIOS); }

{INIT_SCENARIO} { return symbol(sym.INIT_SCENARIO); }

// single words with meaning
"nombre" { return symbol(sym.NAME); }
"orden" { return symbol(sym.ORDER); }

// single chars with meaning
"=" { return symbol(sym.EQUAL); }
";" { return symbol(sym.SEMICOLON); }

{MORE_THAN_S} { return symbol(sym.MORE_THAN_S); }

// ER
{ID} { return symbol(sym.ID); }
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

