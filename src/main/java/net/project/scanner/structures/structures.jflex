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
%cup

%{
    public ArrayList<HashMap<String, String>> errors = new ArrayList<>();

    private Symbol symbol(int type) {
        System.out.println("init" + yytext() + " " + type + "end");
        return new Symbol(type, yyline, yycolumn, yytext());
    }

    private Symbol symbol(int type, Object value) {
        return new Symbol(type, yyline, yycolumn, value);
    }

%}

// single chars
LESS_THAN = "<"
LESS_THAN_S = "</"
MORE_THAN = ">"

// single words
SW_CONFIGURATION = "configuracion"
SW_BG = "fondo"
SW_FIGURE = "figura"
SW_DESIGN = "diseño"

// tags
INIT_CONF = {LESS_THAN} {SW_CONFIGURATION} {MORE_THAN}
END_CONF  = {LESS_THAN_S} {SW_CONFIGURATION} {MORE_THAN}

INIT_BG = {LESS_THAN} {SW_BG} {MORE_THAN}
END_BG = {LESS_THAN_S} {SW_BG} {MORE_THAN}

INIT_FIGURE = {LESS_THAN} {SW_FIGURE} {MORE_THAN}
END_FIGURE = {LESS_THAN_S} {SW_FIGURE} {MORE_THAN}

INIT_DESIGN = {LESS_THAN} {SW_DESIGN} {MORE_THAN}
END_DESIGN = {LESS_THAN_S} {SW_DESIGN} {MORE_THAN}

// ER
ID = [a-zA-Z][a-zA-Z0-9_]+

PATH = [\"](\/[^/\" ]*)+\/?[\"]
STRING = [\"][^\"]+[\"]

%%

//single chars with meaning

// tags
{INIT_CONF} { return symbol(sym.INIT_CONF); }
{END_CONF} { return symbol(sym.END_CONF); }

{INIT_BG} { return symbol(sym.INIT_BG); }
{END_BG} { return symbol(sym.END_BG); }

{INIT_FIGURE} { return symbol(sym.INIT_FIGURE); }
{END_FIGURE} { return symbol(sym.END_FIGURE); }

{INIT_DESIGN} { return symbol(sym.INIT_DESIGN); }
{END_DESIGN} { return symbol(sym.END_DESIGN); }

// single chars with meaning
";" { return symbol(sym.SEMICOLON); }
"," { return symbol(sym.COMMA); }
"=" { return symbol(sym.EQUAL); }
"{" { return symbol(sym.O_BRACE); }
"}" { return symbol(sym.C_BRACE); }

// single words with meaning
"nombre" { return symbol(sym.NAME); }
"imagen" { return symbol(sym.PICTURE); }
"tipo" { return symbol(sym.TYPE); }
"heroe" { return symbol(sym.HERO); }
"enemigo" { return symbol(sym.ENEMY); }
"vida" { return symbol(sym.LIVE); }
"destruir" { return symbol(sym.DESTROY); }
"descripcion" { return symbol(sym.DESCRIPTION); }
"meta" { return symbol(sym.FINISH); }
"bloque" { return symbol(sym.BLOCK); }
"bonus" { return symbol(sym.BONUS); }
"bomba" { return symbol(sym.BOMB); }
"arma" { return symbol(sym.WEAPON); }

// ER
{ID} { return symbol(sym.ID); }
{PATH} { return symbol(sym.PATH); }
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
