cd ../src/main/resources/ || exit

keytool -genkeypair -alias client -keyalg RSA -keysize 4096 -validity 365 -dname "CN=Client,OU=Server,O=Examples,L=,S=CA,C=U" \
 -keypass key@123 -keystore client.p12 -storeType PKCS12 -storepass client@123