pid=$(ps -aef | grep "java -jar -Dspring.profiles.active=production build/libs/hcr.jar" | grep -v grep |  awk '{print $2}')
if [ -z "$pid" ]
then
    echo "HCR Service NOT RUNNING"
else
   echo "HCR Service is currently running with pid" $pid
   kill -9 $pid
   echo "Killed the HCR Service process."
fi


