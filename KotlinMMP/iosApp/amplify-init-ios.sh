let ENV_NAME

source "../../env.txt"

if [[ $BRANCH_NAME == "prod" ]]; then
  ENV_NAME=\"prod\"
elif [[ $BRANCH_NAME == "main" ]]; then
  ENV_NAME=\"test\"
else
  ENV_NAME=\"dev\"
fi

FRONTEND="{\
\"frontend\":\"ios\"\
}"

AMPLIFY="{\
\"envName\":\"$ENV_NAME\",\
\"appId\":\"d194x8oiwokw1k\",\
\"defaultEditor\":\"AndroidStudio\"\
}"

amplify init \
--frontend $FRONTEND \
--amplify $AMPLIFY \
--yes