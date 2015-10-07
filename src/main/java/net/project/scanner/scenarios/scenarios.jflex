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
        System.out.println( yytext() );
        return new Symbol(type, yyline, yycolumn, yytext());
    }

    private Symbol symbol(int type, String value) {
        System.out.println( value );
        return new Symbol(type, yyline, yycolumn, value);
    }

    private Symbol intSymbol(int type) {
        System.out.println(Integer.parseInt(yytext()));
        return new Symbol(type, yyline, yycolumn, Integer.parseInt(yytext()));
    }
%}
// single charts
LESS_THAN = "<"
LESS_THAN_S = "</"
MORE_THAN = ">"

// single words
SW_SCENARIO = "escenario"
SW_CHARACTERS = "personajes"
SW_HEROES = "heroes"
SW_VILLAINS = "villanos"
SW_WALLS = "paredes"
SW_FLOOR = "suelo"
SW_EXTRAS = "extras"
SW_WEAPONS = "armas"
SW_BONUS = "bonus"
SW_FINISH = "meta"

// tags
INIT_SCENARIO = {LESS_THAN} {SW_SCENARIO}
END_SCENARIO = {LESS_THAN_S} {SW_SCENARIO} {MORE_THAN}
INIT_CHARACTERS = {LESS_THAN} {SW_CHARACTERS} {MORE_THAN}
END_CHARACTERS = {LESS_THAN_S} {SW_CHARACTERS} {MORE_THAN}
INIT_HEROES = {LESS_THAN} {SW_HEROES} {MORE_THAN}
END_HEROES = {LESS_THAN_S} {SW_HEROES} {MORE_THAN}
INIT_VILLAINS = {LESS_THAN} {SW_VILLAINS} {MORE_THAN}
END_VILLAINS = {LESS_THAN_S} {SW_VILLAINS} {MORE_THAN}
INIT_WALLS = {LESS_THAN} {SW_WALLS} {MORE_THAN}
END_WALLS = {LESS_THAN_S} {SW_WALLS} {MORE_THAN}
INIT_FLOOR = {LESS_THAN} {SW_FLOOR} {MORE_THAN}
END_FLOOR = {LESS_THAN_S} {SW_FLOOR} {MORE_THAN}
INIT_EXTRAS = {LESS_THAN} {SW_EXTRAS} {MORE_THAN}
END_EXTRAS = {LESS_THAN_S} {SW_EXTRAS} {MORE_THAN}
INIT_WEAPONS = {LESS_THAN} {SW_WEAPONS} {MORE_THAN}
END_WEAPONS = {LESS_THAN_S} {SW_WEAPONS} {MORE_THAN}
INIT_BONUS = {LESS_THAN} {SW_BONUS} {MORE_THAN}
END_BONUS = {LESS_THAN_S} {SW_BONUS} {MORE_THAN}
INIT_FINISH = {LESS_THAN} {SW_FINISH} {MORE_THAN}
END_FINISH = {LESS_THAN_S} {SW_FINISH} {MORE_THAN}

// ER
ID = [a-zA-Z][a-zA-Z0-9_]+
%%

// tags
{INIT_SCENARIO} { return symbol(sym.INIT_SCENARIO); }
{END_SCENARIO} { return symbol(sym.END_SCENARIO); }
{INIT_CHARACTERS} { return symbol(sym.INIT_CHARACTERS); }
{END_CHARACTERS} { return symbol(sym.END_CHARACTERS); }
{INIT_HEROES} { return symbol(sym.INIT_HEROES); }
{END_HEROES} { return symbol(sym.END_HEROES); }
{INIT_VILLAINS} { return symbol(sym.INIT_VILLAINS); }
{END_VILLAINS} { return symbol(sym.END_VILLAINS); }
{INIT_WALLS} { return symbol(sym.INIT_WALLS); }
{END_WALLS} { return symbol(sym.END_WALLS); }
{INIT_FLOOR} { return symbol(sym.INIT_FLOOR); }
{END_FLOOR} { return symbol(sym.END_FLOOR); }
{INIT_EXTRAS} { return symbol(sym.INIT_EXTRAS); }
{END_EXTRAS} { return symbol(sym.END_EXTRAS); }
{INIT_WEAPONS} { return symbol(sym.INIT_WEAPONS); }
{END_WEAPONS} { return symbol(sym.END_WEAPONS); }
{INIT_BONUS} { return symbol(sym.INIT_BONUS); }
{END_BONUS} { return symbol(sym.END_BONUS); }
{INIT_FINISH} { return symbol(sym.INIT_FINISH); }
{END_FINISH} { return symbol(sym.END_FINISH); }

// single chars with meaning
{MORE_THAN} { return symbol(sym.MORE_THAN); }
"=" { return symbol(sym.EQUAL); }
";" { return symbol(sym.SEMICOLON); }
"," { return symbol(sym.COMMA); }
"(" { return symbol(sym.O_PAREN); }
")" { return symbol(sym.C_PAREN); }
"." { return symbol(sym.DOT); }


// single words with meaning
"nombre" { return symbol(sym.NAME); }
"fondo" { return symbol(sym.BG); }
"ancho" { return symbol(sym.WIDTH); }
"alto" { return symbol(sym.HEIGHT); }

// ER
{ID} { return symbol(sym.ID); }
[:digit:]+ { return intSymbol(sym.INT); }

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
