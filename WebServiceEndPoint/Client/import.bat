echo off
echo  lookup for the wsdl file from publishing URL and reverse engineer the WS to generate the types 
echo wsimport -d . -p wspack -keep http://localhost:7779/ws/hello?wsdl
wsimport -d . -p wspack -keep http://localhost:7779/ws/hello?wsdl
pause