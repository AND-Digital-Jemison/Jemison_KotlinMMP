FRONTEND="{\
\"frontend\":\"iOS\"\
}"

AMPLIFY="{\
\"envName\":${process.env.ENV_NAME},\
\"appId\":\"d194x8oiwokw1k\",\
\"defaultEditor\":\"android\"\
}"

amplify init \
--frontend $FRONTEND \
--amplify $AMPLIFY \
--yes