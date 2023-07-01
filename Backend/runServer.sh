#!/usr/bin/env bash
#cd /root/code/microservices/hax-sso/SSO-app
#echo "Pulling the latest changes from repository."
#gitOutput=$(git pull)
#echo $gitOutput
#tagOutput=$(git fetch --tags)
#echo $tagOutput
#echo "Pulled the latest changes from repository."

echo "Project Building start."
sudo ./gradlew clean build -x test
echo "Gradle build without tests done."
nohup java -jar -Dspring.profiles.active=production build/libs/hcr.jar  &
echo "HCR Service running."

echo "All is running in the background using the Development profile."