ANDROIDCONFIG="{\
\"ResDir\":\"src/main/src\"\
}"

FRONTEND="{\
\"frontend\":\"android\",\
\"config\":$ANDROIDCONFIG\
}"

AMPLIFY="{\
\"envName\":\"dev\",\
\"appId\":\"d194x8oiwokw1k\",\
\"defaultEditor\":\"AndroidStudio\",\
}"

amplify init \
--frontend $FRONTEND \
--amplify $AMPLIFY \
--yes