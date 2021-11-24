let ENV_NAME

source "../../env.txt"

if [[ $BRANCH_NAME == "prod" ]]; then
  ENV_NAME=\"prod\"
elif [[ $BRANCH_NAME == "main" ]]; then
  ENV_NAME=\"test\"
else
  ENV_NAME=\"dev\"
fi

ANDROIDCONFIG="{\
\"ResDir\":\"src/main/src\"\
}"

FRONTEND="{\
\"frontend\":\"android\",\
\"config\":$ANDROIDCONFIG\
}"

AMPLIFY="{\
\"appId\":\"d194x8oiwokw1k\",\
\"defaultEditor\":\"AndroidStudio\",\
\"envName\":$ENV_NAME\
}"

amplify init \
--frontend $FRONTEND \
--amplify $AMPLIFY \
--yes