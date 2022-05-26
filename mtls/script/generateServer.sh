cd ../src/main/resources/ || exit

keytool -genkeypair -alias server -keyalg RSA -keysize 4096 -validity 365 -dname "CN=Server,OU=Server,O=Examples,L=,S=CA,C=U" \
 -keypass key@123 -keystore server.p12 -storeType PKCS12 -storepass server@123