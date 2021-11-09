#!/bin/bash
set -e
IFS='|'

CODEGEN="{\
\"generateCode\":true,\
\"codeLanguage\":\"kotlin\",\
\"fileNamePattern\":\"src/java/**/*.java\",\
\"generateDocs\":true\
}"

amplify push \
--codegen $CODEGEN \
--yes
