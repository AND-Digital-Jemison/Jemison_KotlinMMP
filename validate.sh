# !/bin/zsh
# SCRIPTS
# to RUN without execute permission
#
# zsh tests.sh
# sh tests.sh
#         OR
# to set execute permission do   
#
# chmod 744 tests.sh
#
function separator_line {
    echo "\n-----------------------------------------------------------------------------\n"
}

# VARIABLES
username=$(whoami)
RED="\033[1;31m"
GREEN="\033[1;32m"
NOCOLOR="\033[0m"
ANDROID_SDK_PATH="/Users/${username}/Library/Android/sdk"
JAVA_JDK_PATH="/Library/Java/JavaVirtualMachines/" 

clear
#echo "User:"
#echo "$USER"

#echo "my ${GREEN}username ${NOCOLOR}is ${RED}$username ${NOCOLOR}"

#check JAVA version
separator_line
echo "\t\t\t\t\t ${GREEN}START${NOCOLOR}"
separator_line
echo "\n${GREEN}JAVA ${NOCOLOR}version...\n"
java -version

echo "\nChecking ${GREEN}Java JDK${NOCOLOR}..."
[ -d "${JAVA_JDK_PATH}" ] &&
echo "\n${GREEN}JAVA JDK folder found"
echo "${NOCOLOR}${JAVA_JDK_PATH}"
echo "${GREEN}"
ls $JAVA_JDK_PATH
echo "${NOCOLOR}" || 
echo "${RED}Error${NOCOLOR}: No JAVA JDK folder found at ${JAVA_JDK_PATH}"
separator_line

#check android sdk folder exists
echo "Checking ${GREEN}Android SDK${NOCOLOR}...\n"
[ -d "${ANDROID_SDK_PATH}" ] &&
echo "${GREEN}Android SDK installed"
echo "${NOCOLOR}${ANDROID_SDK_PATH}" || 
echo "${RED}Error${NOCOLOR}: No Android sdk folder found at ${ANDROID_SDK_PATH}"
separator_line

echo "Checking ${GREEN}Cocoapods ${NOCOLOR}version"
pod --version
separator_line

echo "Checking ${GREEN}Gradle version${NOCOLOR}...\n"
gradle -v
separator_line

echo "Checking ${GREEN}GIT version${NOCOLOR}...\n"
git --version
separator_line

#check if comand return result or not
if [[ $(gradle -v) ]]; then
    echo "${GREEN}gradle \t\t\t installed${NOCOLOR}"
else
    echo "${RED}gradle \t\t\t not installed${NOCOLOR}"
fi

#check if comand return result or not
if [[ $(pod --version) ]]; then
    echo "${GREEN}cocoapods \t\t installed${NOCOLOR}"
else
    echo "${RED}cocoapods \t\t not installed${NOCOLOR}"
fi

if [[ $(git --version) ]]; then
    echo "${GREEN}Git \t\t\t installed${NOCOLOR}"
else
    echo "${RED}Git \t\t\t not installed${NOCOLOR}"
fi
separator_line

echo "${GREEN}PATHS${NOCOLOR} set in ./zshrc ...\n"
grep '\<export\>' ~/.zshrc  
# exclude character or word -v "#" and continue with selection
# but id doesnt exclude full line, just that specific character
#grep -v "#" ~/.zshrc | grep '\<export\>'  
separator_line
