FRONTEND="{\
\"frontend\":\"android\"\
}"

AMPLIFY="{\
\"envName\":\"test\",\
\"appId\":\"d194x8oiwokw1k\",\
\"defaultEditor\":\"android\"\
}"

amplify init \
--frontend $FRONTEND \
--amplify $AMPLIFY \
--yes