#!/bin/bash
rm -r src/main/java/se/sics/kola/analysis
rm -r src/main/java/se/sics/kola/lexer
rm -r src/main/java/se/sics/kola/node
rm -r src/main/java/se/sics/kola/parser
sablecc --no-inline -d src/main/java/ src/main/sablecc/kola-0.1.7.sablecc
mkdir -p src/main/resources/se/sics/kola/lexer
mkdir -p src/test/resources/se/sics/kola/lexer
cp src/main/java/se/sics/kola/lexer/lexer.dat src/main/resources/se/sics/kola/lexer/lexer.dat
cp src/main/java/se/sics/kola/lexer/lexer.dat src/test/resources/se/sics/kola/lexer/lexer.dat
mkdir -p src/main/resources/se/sics/kola/parser
mkdir -p src/test/resources/se/sics/kola/parser
cp src/main/java/se/sics/kola/parser/parser.dat src/main/resources/se/sics/kola/parser/parser.dat
cp src/main/java/se/sics/kola/parser/parser.dat src/test/resources/se/sics/kola/parser/parser.dat