
%%

%int

%xstate LINE BLOCK DOC

%%

<YYINITIAL> {

    \".*\"            {}
    "//"              { yybegin(LINE);  }
    "/*"              { yybegin(BLOCK); }
    "/**"             { yybegin(DOC);   }
    [^]               {}

}

<LINE> {

    [^\s\t\r\n]       { JCom.addLine(yylength()); }
    \n                { yybegin(YYINITIAL); }
    [^]               {}

}

<BLOCK> {

    "*/"              { yybegin(YYINITIAL); }
    [^\s\t\r\n]       { JCom.addBlock(yylength()); }
    [^]               {}

}

<DOC> {

    "*/"              { yybegin(YYINITIAL); }
    [^\s\t\r\n]       { JCom.addDoc(yylength()); }
    [^]               {}

}
