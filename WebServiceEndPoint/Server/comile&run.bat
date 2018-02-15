echo off
echo hello to WS Server BAT by :: MotYim ::
pause
echo compile java classes...
echo $ javac -d . *.java
javac -d . *.java 
pause
echo generate the artifacts and WSDL 
echo $ wsgen -verbose -keep -cp . mypack.ServerImp -wsdl
wsgen -verbose -keep -cp . mypack.ServerImp -wsdl
pause
echo run server ...
echo $ java mypack.PublishWS
java mypack.PublishWS
pause