AWS_CONFIG="{\
\"configLevel\":\"project\",\
\"useProfile\":false,\
\"profileName\":\"my-profile\"\
}"

FRONTEND="{\
\"frontend\":\"android\"\
}"

AMPLIFY="{\
\"envName\":\"dev\",\
\"appId\":\"d194x8oiwokw1k\",\
\"defaultEditor\":\"android\"\
}"

amplify init \
--frontend $FRONTEND \
--amplify $AMPLIFY \
--yes