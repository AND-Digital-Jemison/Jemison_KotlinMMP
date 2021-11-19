ENV=$(cat ./src/main/assets/env)

let CURRENT_ENV

if [[ $ENV == *"ENV_NAME=prod"* ]]; then
  CURRENT_ENV=\"prod\"
elif [[ $ENV == *"ENV_NAME=main"* ]]; then
  CURRENT_ENV=\"test\"
else
  CURRENT_ENV=\"dev\"
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
\"envName\":$CURRENT_ENV\
}"

amplify init \
--frontend $FRONTEND \
--amplify $AMPLIFY \
--yes