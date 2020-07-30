package Analizadores;

import java_cup.runtime.Symbol;

%%

%class Lexer
%public
%cup
%line
%column

/* special chars */
LineTerminator = \r|\n|\r\n
WhiteSpace = [ \t\f]+

/* integer literals */
BinLiteral = [01]

%{
    private boolean error = false;

    private Symbol symbol(int type) {
        String lexeme = yytext();
        return new Symbol(type, Double.parseDouble(lexeme));
    }

    private Symbol symbol(int type, String lexeme) {
        return new Symbol(type, Double.parseDouble(lexeme));
    }

    private void error(String lexeme) {
        error = true;
        System.out.println("No se ingreso un número octal");
    }
    
    public boolean getError(){
        return error;
    }
%}

%%

/* reglas lexicas */
<YYINITIAL> {

    {BinLiteral}                  {   return symbol(BIN);}
    "\."                          {   return symbol(PUNTO);}

}

/* error fallback */
[^]                              {   error(yytext());    }
