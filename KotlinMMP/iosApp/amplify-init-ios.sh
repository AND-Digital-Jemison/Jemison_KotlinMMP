FRONTEND="{\
\"frontend\":\"ios\"\
}"

AMPLIFY="{\
\"envName\":\"test\",\
\"appId\":\"d194x8oiwokw1k\",\
\"defaultEditor\":\"AndroidStudio\"\
}"

amplify init \
--frontend $FRONTEND \
--amplify $AMPLIFY \
--yes