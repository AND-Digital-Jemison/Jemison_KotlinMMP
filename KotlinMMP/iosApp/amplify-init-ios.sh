FRONTEND="{\
\"frontend\":\"iOS\"\
}"

AMPLIFY="{\
\"envName\":${BuildConfig.ENV_NAME},\
\"appId\":\"d194x8oiwokw1k\",\
\"defaultEditor\":\"android\"\
}"

amplify init \
--frontend $FRONTEND \
--amplify $AMPLIFY \
--yes