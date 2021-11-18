echo BuildConfig.ENV_NAME

ANDROIDCONFIG="{\
\"ResDir\":\"src/main/src\"\
}"

FRONTEND="{\
\"frontend\":\"android\",\
\"config\":$ANDROIDCONFIG\
}"

AMPLIFY="{\
\"envName\":\"${BuildConfig.ENV_NAME}\",\
\"appId\":\"d194x8oiwokw1k\",\
\"defaultEditor\":\"AndroidStudio\",\
}"

amplify init \
--frontend $FRONTEND \
--amplify $AMPLIFY \
--yes