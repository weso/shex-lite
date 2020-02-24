#!/bin/sh

set -e

if [[ -n "$SSH_PRIVATE_KEY" ]]
then
  mkdir -p /root/.ssh
  echo "$SSH_PRIVATE_KEY" > /root/.ssh/id_rsa
  chmod 600 /root/.ssh/id_rsa
fi

mkdir -p ~/.ssh
cp /root/.ssh/* ~/.ssh/ 2> /dev/null || true

SOURCE_REPO=$1
SOURCE_BRANCH=$2
DESTINATION_REPO=$3
DESTINATION_BRANCH=$4

SOURCE_REPO="git@github.com:${SOURCE_REPO}.git"
GIT_SSH_COMMAND="ssh -v"

DESTINATION_REPO="git@github.com:${DESTINATION_REPO}.git"
GIT_SSH_COMMAND="ssh -v"

echo "SOURCE=$SOURCE_REPO:$SOURCE_BRANCH"
echo "DESTINATION=$DESTINATION_REPO:$DESTINATION_BRANCH"

git clone "$SOURCE_REPO" --origin source && cd `basename "$SOURCE_REPO" .git`
rm source/LICENSE

git remote add destination "$DESTINATION_REPO"
git push destination "${SOURCE_BRANCH}:${DESTINATION_BRANCH}" -f
