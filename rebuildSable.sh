#!/bin/bash
rm -r src/main/java/se/sics/kola/analysis
rm -r src/main/java/se/sics/kola/lexer
rm -r src/main/java/se/sics/kola/node
rm -r src/main/java/se/sics/kola/parser
sablecc -d src/main/java/ src/main/sablecc/kola-0.1.7.sablecc